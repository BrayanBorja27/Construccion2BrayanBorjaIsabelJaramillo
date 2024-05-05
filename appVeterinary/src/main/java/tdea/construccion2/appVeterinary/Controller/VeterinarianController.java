package tdea.construccion2.appVeterinary.Controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tdea.construccion2.appVeterinary.Dao.ClinicalHistoryDao;
import tdea.construccion2.appVeterinary.Dao.OrderDao;
import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;
import tdea.construccion2.appVeterinary.Dto.OrderDto;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Dto.PetDto;
import tdea.construccion2.appVeterinary.Models.ClinicalHistory;
import tdea.construccion2.appVeterinary.Service.VeterinarianService;
import tdea.construccion2.appVeterinary.Validator.ClinicalHistoryValidator;
import tdea.construccion2.appVeterinary.Validator.PersonValidator;
import tdea.construccion2.appVeterinary.Validator.PetValidator;

@Component
public class VeterinarianController {

	@Autowired
	private PetValidator petValidator;
	@Autowired
	private ClinicalHistoryValidator clinicalHistoryValidator;
	@Autowired
	private ClinicalHistoryDao clinicalHistoryDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PersonValidator personValidator;
	private static Scanner reader = new Scanner(System.in);
	@Autowired
	private VeterinarianService veterinarianService;
	private final String Menú = "Ingrese: " + "\n1.Crear dueño" + "\n2.Crear mascota" + "\n3.Crear historia Clinica"
			+ "\n4.Consultar historia Clinica" + "\n5.Buscar Orden" + "\n6.Cancelar la orden"
			+ "\n7.Para cerrar Sesion";
	// private static ClinicalHistoryDto clinicalHistoryDto;

	private void createOwner() throws Exception {
		System.out.println("Ingrese la cedula del dueño: ");
		long idOwner = personValidator.idValidator(reader.nextLine());
		System.out.println("Ingrese el nombre del dueño: ");
		String fullNameOwner = reader.nextLine();
		personValidator.nameValidador(fullNameOwner);
		System.out.println("Ingrese la edad del dueño: ");
		int age = personValidator.ageValidator(reader.nextLine());
		System.out.println("Ingrese el rol: ");
		String role = reader.nextLine();
		personValidator.roleValidator(role);
		System.out.println("Ingrese el usuario: ");
		String userName = reader.nextLine();
		personValidator.userNameValidador(userName);
		System.out.println("Ingrese la contraseña: ");
		String password = reader.nextLine();
		personValidator.passwordValidator(password);
		PersonDto personDto = new PersonDto(idOwner, fullNameOwner, age, role, userName, password);
		veterinarianService.createOwner(personDto);
	}

	private void createPet() throws Exception {
		/*
		 * System.out.println("Ingrese la identificación de la mascota: "); long idPet =
		 * petValidator.idValidator(reader.nextLine());
		 */
		System.out.println("Ingrese la cedula del dueño: ");
		Long idOwner = personValidator.idValidator(reader.nextLine());
		PersonDto Owner = new PersonDto(idOwner);
		System.out.println("Ingrese el nombre de la mascota: ");
		String fullName = reader.nextLine();
		petValidator.nameValidador(fullName);
		System.out.println("Ingrese la edad de la mascota: ");
		int age = petValidator.ageValidator(reader.nextLine());
		System.out.println("Ingrese el peso de la mascota: ");
		double Weight = petValidator.weightValidator(reader.nextLine());
		System.out.println("Ingrese la raza de la mascota: ");
		String breed = reader.nextLine();
		petValidator.breedValidador(breed);
		System.out.println("Ingrese la especie de la mascota: ");
		String species = reader.nextLine();
		petValidator.speciesValidador(species);
		System.out.println("Ingrese las caracteristicas de la mascota: ");
		String characteristics = reader.nextLine();
		petValidator.characteristicsValidador(characteristics);
		PetDto petDto = new PetDto(0, Owner, fullName, age, Weight, breed, species, characteristics);
		veterinarianService.createPet(petDto);
	}

	private void createClinicalHistory() throws Exception {
		long date = System.currentTimeMillis();
		System.out.println("Ingrese la identificación de la mascota: ");
		long pet = clinicalHistoryValidator.petIdValidator(reader.nextLine());
		PetDto petId = new PetDto(pet);
		System.out.println("Ingrese el motivo de consulta: ");
		String reasonForConsultation = reader.nextLine();
		clinicalHistoryValidator.reasonForConsultationValidador(reasonForConsultation);
		System.out.println("Ingrese los sintomas de la mascota: ");
		String symptoms = reader.nextLine();
		clinicalHistoryValidator.symptomsValidador(symptoms);
		System.out.println("Ingrese el diagnostico de la mascota: ");
		String diagnosis = reader.nextLine();
		clinicalHistoryValidator.diagnosisValidador(diagnosis);
		System.out.println("Ingrese los medicamentos: ");
		String medication = reader.nextLine();
		clinicalHistoryValidator.medicationValidador(medication);
		System.out.println("Ingrese la dosis correspondiente a cada medicamento: ");
		String medicationDose = reader.nextLine();
		clinicalHistoryValidator.medicationDoseValidador(medicationDose);
		System.out.println("Ingrese el historial de vacunación de la mascota: ");
		String vaccinationHistory = reader.nextLine();
		clinicalHistoryValidator.vaccinationHistoryValidador(vaccinationHistory);
		System.out.println("Ingrese las alergias de la mascota: ");
		String allergies = reader.nextLine();
		clinicalHistoryValidator.allergiesValidador(allergies);
		System.out.println("Ingrese el procedimiento realizado a la mascota: ");
		String procedure = reader.nextLine();
		clinicalHistoryValidator.procedureValidador(procedure);
		System.out.println("Ingrese ingrese los detalles del procedimiento realizado a la mascota: ");
		String procedureDetails = reader.nextLine();
		clinicalHistoryValidator.procedureDetailsValidador(procedureDetails);
		ClinicalHistoryDto clinicalHistoryDto = new ClinicalHistoryDto(date, petId, null, reasonForConsultation,
				symptoms, diagnosis, procedure, medication, medicationDose, null, vaccinationHistory, allergies,
				procedureDetails, true);
		veterinarianService.createClinicalHistory(clinicalHistoryDto);

	}

	public ClinicalHistoryDto findClinicalHistoryById() throws Exception {
		System.out.println("Ingrese el ID de la historia clínica: ");
		long date = clinicalHistoryValidator.dateValidator(reader.nextLine());
		ClinicalHistoryDto clinicalHistory = new ClinicalHistoryDto();
		clinicalHistory.setDate(date);
		ClinicalHistoryDto clinicalHistoryDto = clinicalHistoryDao.findClinicalHistoryById(clinicalHistory);

		if (clinicalHistoryDto != null) {
			System.out.println("Se encontró la historia clínica con el ID " + clinicalHistoryDto.getDate());
			System.out.println("Fecha: " + clinicalHistoryDto.getDate());
			System.out.println("Mascota: " + clinicalHistoryDto.getPetId().getIdPet());
			System.out.println("Médico: " + clinicalHistoryDto.getVeterinarian().getName());
			System.out.println("Motivo: " + clinicalHistoryDto.getReasonForConsultation());
			System.out.println("Sintomatología: " + clinicalHistoryDto.getSymptoms());
			System.out.println("Diagnóstico: " + clinicalHistoryDto.getDiagnosis());
			System.out.println("Medicamento: " + clinicalHistoryDto.getMedication());
			System.out.println("Dosificación del medicamento: " + clinicalHistoryDto.getMedicationDose());
			System.out.println("Vacunación: " + clinicalHistoryDto.getVaccinationHistory());
			System.out.println("Alergia: " + clinicalHistoryDto.getAllergies());
			System.out.println("Procedimiento: " + clinicalHistoryDto.getProcedure());
			System.out.println("Detalles del procedimiento: " + clinicalHistoryDto.getProcedureDetails());
			if (!clinicalHistoryDto.getOrderId().equals(null)) {
				System.out.println("Orden: " + clinicalHistoryDto.getOrderId().getOrderId());
			}

		} else {
			System.out.println("No se encontró una historia clínica válida con el ID " + clinicalHistory.getDate());

		}
		return clinicalHistoryDto;
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

	private void cancelOrder() throws Exception {
		System.out.println("Ingrese el id de la orden a cancelar:  ");
		long idOrder = clinicalHistoryValidator.orderId(reader.nextLine());
		OrderDto orderDto = orderDao.findOrderById(idOrder);
		if (orderDto == null) {
			throw new Exception("No hay una orden válida.");
		}
		ClinicalHistoryDto clinicalHistoryDto = clinicalHistoryDao.findClinicalHistoryByOrderId(idOrder);
		clinicalHistoryDto.setOrderCancellation(false);
		clinicalHistoryDao.createClinicalHistory(clinicalHistoryDto);
		System.out.println("La historia clinica con Id " + clinicalHistoryDto.getDate() + " ha anulado la orden con Id "
				+ clinicalHistoryDto.getOrderId().getOrderId());
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
			createOwner();
			return true;
		}
		case "2": {
			createPet();
			return true;
		}
		case "3": {
			createClinicalHistory();
			return true;
		}
		case "4": {
			findClinicalHistoryById();
			return true;
		}
		case "5": {
			findOrderById();
			return true;
		}
		case "6": {
			cancelOrder();
			return true;
		}
		case "7": {
			return false;
		}
		default: {
			System.out.println("Ingrese una opcion valida");
			return true;
		}
		}
	}

	public PetValidator getPetValidator() {
		return petValidator;
	}

	public void setPetValidator(PetValidator petValidator) {
		this.petValidator = petValidator;
	}

	public ClinicalHistoryValidator getClinicalHistoryValidator() {
		return clinicalHistoryValidator;
	}

	public void setClinicalHistoryValidator(ClinicalHistoryValidator clinicalHistoryValidator) {
		this.clinicalHistoryValidator = clinicalHistoryValidator;
	}

	public PersonValidator getPersonValidator() {
		return personValidator;
	}

	public void setPersonValidator(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	public VeterinarianService getVeterinarianService() {
		return veterinarianService;
	}

	public void setVeterinarianService(VeterinarianService veterinarianService) {
		this.veterinarianService = veterinarianService;
	}

	public ClinicalHistoryDao getClinicalHistoryDao() {
		return clinicalHistoryDao;
	}

	public void setClinicalHistoryDao(ClinicalHistoryDao clinicalHistoryDao) {
		this.clinicalHistoryDao = clinicalHistoryDao;
	}

}
