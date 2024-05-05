package tdea.construccion2.appVeterinary.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.appVeterinary.Dao.OrderDao;
import tdea.construccion2.appVeterinary.Dto.InvoiceDto;
import tdea.construccion2.appVeterinary.Dto.OrderDto;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Dto.PetDto;
import tdea.construccion2.appVeterinary.Service.SellerService;
import tdea.construccion2.appVeterinary.Validator.ClinicalHistoryValidator;
import tdea.construccion2.appVeterinary.Validator.InvoiceValidator;
import tdea.construccion2.appVeterinary.Validator.OrderValidator;
import tdea.construccion2.appVeterinary.Validator.PersonValidator;
import tdea.construccion2.appVeterinary.Validator.PetValidator;

@Component
public class SellerController {

	@Autowired
	private OrderValidator orderValidator;
	@Autowired
	private InvoiceValidator invoiceValidator;
	@Autowired
	private PetValidator petValidator;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private ClinicalHistoryValidator clinicalHistoryValidator;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private SellerService sellerService;

	private Scanner reader = new Scanner(System.in);
	private final String Menú = "Ingrese: " + "\n1.Crear factura" + "\n2.Buscar Orden" + "\n3.Cerrar Sesion";

	public void generateSalesInvoice() throws Exception {
		System.out.println("Ingresa el id de la Orden");
		long invoiceId = orderValidator.orderIdValidator(reader.nextLine());
		System.out.println("Ingrese la identificación de la mascota: "); 
		long petId = petValidator.idValidator(reader.nextLine());
		PetDto pet = new PetDto(petId);
		System.out.println("Ingresa la identificació del propietario"); 
		long owner = personValidator.idValidator(reader.nextLine());
		PersonDto ownerId = new PersonDto(owner);
		System.out.println("Ingresa el nombre del producto");
		String productName = reader.nextLine();
		invoiceValidator.productNameValidador(productName);
		System.out.println("Ingresa la cantidad");
		long quantity = invoiceValidator.quantityValidator(reader.nextLine());
		System.out.println("Ingresa el precio");
		double value = invoiceValidator.valueValidator(reader.nextLine());
		long date = System.currentTimeMillis();
		InvoiceDto invoiceDto = new InvoiceDto(invoiceId, pet, ownerId, productName, quantity, value, date);
		sellerService.generateSalesInvoice(invoiceDto);

	}
	
	private OrderDto findOrderById() throws Exception {
		System.out.println("Ingrese el id de la orden:  ");
		long orderId = clinicalHistoryValidator.orderId(reader.nextLine());
		OrderDto orderDto = orderDao.findOrderById(orderId);
		if (orderDto == null) {
			throw new Exception("No hay una orden válida.");
		}
		System.out.println("ID: " + orderDto.getOrderId());
		System.out.println("Mascota: " + orderDto.getPetId().getFullName());
		System.out.println("Medicamento: " + orderDto.getMedicationName());
		System.out.println("Fecha: " + orderDto.getGenerationDate());
		return orderDto;

	}

	public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(Menú);
				String option = reader.nextLine();
				runApp = Menú(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private boolean Menú(String option) throws Exception {
		switch (option) {
		case "1": {
			generateSalesInvoice();
			return true;
		}
		case "2": {
			findOrderById();
			return true;
		}
		case "3": {
			return false;
		}
		default: {
			System.out.println("Ingrese una opcion valida");
			return true;
		}
		}
	}

	public OrderValidator getOrderValidator() {
		return orderValidator;
	}

	public void setOrderValidator(OrderValidator orderValidator) {
		this.orderValidator = orderValidator;
	}

	public InvoiceValidator getInvoiceValidator() {
		return invoiceValidator;
	}

	public void setInvoiceValidator(InvoiceValidator invoiceValidator) {
		this.invoiceValidator = invoiceValidator;
	}

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	public PetValidator getPetValidator() {
		return petValidator;
	}

	public void setPetValidator(PetValidator petValidator) {
		this.petValidator = petValidator;
	}

	public PersonValidator getPersonValidator() {
		return personValidator;
	}

	public void setPersonValidator(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	public ClinicalHistoryValidator getClinicalHistoryValidator() {
		return clinicalHistoryValidator;
	}

	public void setClinicalHistoryValidator(ClinicalHistoryValidator clinicalHistoryValidator) {
		this.clinicalHistoryValidator = clinicalHistoryValidator;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
