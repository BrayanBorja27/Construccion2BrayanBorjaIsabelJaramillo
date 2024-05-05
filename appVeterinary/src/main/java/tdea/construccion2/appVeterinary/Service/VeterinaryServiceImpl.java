package tdea.construccion2.appVeterinary.Service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dao.ClinicalHistoryDao;
import tdea.construccion2.appVeterinary.Dao.LoginDao;
import tdea.construccion2.appVeterinary.Dao.OrderDao;
import tdea.construccion2.appVeterinary.Dao.PersonDao;
import tdea.construccion2.appVeterinary.Dao.PetDao;
import tdea.construccion2.appVeterinary.Dao.SellerDao;
import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;
import tdea.construccion2.appVeterinary.Dto.InvoiceDto;
import tdea.construccion2.appVeterinary.Dto.OrderDto;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Dto.PetDto;
import tdea.construccion2.appVeterinary.Dto.SessionDto;

@Service
public class VeterinaryServiceImpl implements LoginService, AdministratorService, VeterinarianService, SellerService {

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ClinicalHistoryDao clinicalHistoryDao;
	@Autowired
	private PetDao petDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private SellerDao sellerDao;

	List<String> role = Arrays.asList("Administrador", "Medico Veterinario", "Vendedor", "Dueño de mascota");
	List<String> species = Arrays.asList("perro", "gato", "conejo", "cobaya", "huron", "hámster", "ardilla", "erizo",
			"periquito", "canario", "loro", "tortuga", "lagartija", "serpiente", "salamandra", "chinchilla");
	private static long sessionID = 0;

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("usuario o contraseña incorrectos");
		}
		personDto.setRole(personDtoValidate.getRole());
		SessionDto sesionDto = loginDao.login(personDtoValidate);
		setSessionID(sesionDto.getId());
		System.out.println("se inicia la sesion " + sessionID);
	}

	@Override
	public void logout(long sesionId) throws Exception {
		loginDao.logout(sesionId);
		setSessionID(0);
	}

	@Override
	public void setSessionID(long sesionId) {
		sessionID = sesionId;
	}

	@Override
	public void createVeterinarian(PersonDto personDto) throws Exception {
		personDto.setRole("Medico Veterinario");

		System.out.println("cedula del usuario" + personDto.getId());
		if (personDao.findUserExistById(personDto)) {
			throw new Exception("Ya existe un usuario con esa cedula");
		}
		if (personDao.findExistingUserByUserName(personDto)) {
			throw new Exception("Ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("Se ha creado el usuario");
	}

	@Override
	public void createSeller(PersonDto personDto) throws Exception {
		personDto.setRole("Vendedor");
		if (personDao.findUserExistById(personDto)) {
			throw new Exception("Ya existe un usuario con esa cedula");
		}
		if (personDao.findExistingUserByUserName(personDto)) {
			throw new Exception("Ya existe el usuario");
		}
		personDao.createPerson(personDto);
		System.out.println("Se ha creado el usuario");
	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		if (!species.contains(petDto.getSpecies())) {
			throw new Exception("La especie no es valida " + petDto.getSpecies());
		}
		petDao.createPet(petDto);
		System.out.println("Se ha creado la mascota ");
	}

	@Override
	public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception {
		// Buscar la sesión activa
		SessionDto sessionDto = loginDao.findSessionById(sessionID);
		if (sessionDto == null) {
			throw new Exception("No hay una sesión válida.");
		}
		clinicalHistoryDto.setDate(System.currentTimeMillis());
		// Verificar la existencia y validez de la sesión
		PersonDto personDto = new PersonDto(sessionDto.getUserName());
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("No hay un usuario válido asociado a la sesión.");
		}
		clinicalHistoryDto.setVeterinarian(personDto);
		// Buscar la mascota en la historia clínica
		PetDto petDto = new PetDto(petDao.findById(clinicalHistoryDto.getPetId().getIdPet()));
		if (petDto == null) { throw new Exception("La mascota especificada no existe.");
		}
		clinicalHistoryDto.setPetId(petDto);
		// Crear Orden
		OrderDto orderDto = new OrderDto(petDto, personDto, clinicalHistoryDto.getVeterinarian(),
				clinicalHistoryDto.getMedication(), clinicalHistoryDto.getMedicationDose(),
				new Date(clinicalHistoryDto.getDate()));
		orderDto = orderDao.createOrden(orderDto);
		if (orderDto != null) {
			long orderId = orderDto.getOrderId();
			System.out.println("ID de la orden asociada a la historia es clínica es: " + orderId);
		} else {
			System.out.println("No hay una orden asociada a la historia es clínica:");
		}

		// Crear la historia clínica
		clinicalHistoryDto.setOrderId(orderDto);
		clinicalHistoryDao.createClinicalHistory(clinicalHistoryDto);
		System.out.println("Se ha creado la Historia clínica.");
	}

	@Override
	public void createOwner(PersonDto personDto) throws Exception {
		personDto.getId();
		personDto.getName();
		personDto.getAge();
		personDto.setRole("Dueño");
		personDto.setUserName("Dueño");
		personDto.setPassword("Dueño");
		if (personDao.findUserExistById(personDto)) {
			throw new Exception("Ya existe un usuario con esa cedula");
		}
		personDao.createPerson(personDto);
		System.out.println("Se ha creado el propietario correctamente.");
	}

	@Override
	public void cancelOrder(OrderDto orderDto) throws Exception {
		SessionDto sessionDto = loginDao.findSessionById(sessionID);
		if (sessionDto == null) {
			throw new Exception("No hay una sesión válida.");
		}
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("No hay un usuario valido");
		}
		OrderDto order = orderDao.findOrderById(orderDto.getOrderId());
		if (order == null) {
			throw new Exception("El id de la orden no es invalido");
		}
		orderDto.getOrderId();
		orderDto.setVeterinarianID(personDto);
		orderDao.cancelOrder(orderDto);

	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public ClinicalHistoryDao getClinicalHistoryDao() {
		return clinicalHistoryDao;
	}

	public void setClinicalHistoryDao(ClinicalHistoryDao clinicalHistoryDao) {
		this.clinicalHistoryDao = clinicalHistoryDao;
	}

	public PetDao getPetDao() {
		return petDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public SellerDao getSellerDao() {
		return sellerDao;
	}

	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}

	@Override
	public void checkOrder(OrderDto OrderDto) throws Exception {
		
		
	}

	@Override
	public void generateSalesInvoice(InvoiceDto invoiceDto) throws Exception {
		sellerDao.createInvoice(invoiceDto);
		System.out.println("Se ha creado la factura correctamente.");
		
	}

}
