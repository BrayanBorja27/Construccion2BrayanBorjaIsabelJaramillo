 package tdea.construccion2.appVeterinary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;

@Entity
@Table(name = "historia")
public class ClinicalHistory {
	@Id
	@Column(name = "fecha")
	private long date;
	@ManyToOne
	@JoinColumn(name = "mascota")
	private Pet petId;
	@ManyToOne
	@JoinColumn(name = "medico")
	private Person veterinarian;
	@Column(name = "motivo")
	private String reasonForConsultation;
	@Column(name = "sintomatologia")
	private String symptoms;
	@Column(name = "diagnosis")
	private String diagnosis;
	@Column(name = "medicamento")
	private String procedure;
	@Column(name = "procedimiento")
	private String medication;
	@Column(name = "medicationdosage")
	private String medicationDose;
	@ManyToOne
	@JoinColumn(name = "orden")
	private Order orderId;
	@Column(name = "vacunacion")
	private String vaccinationHistory;
	@Column(name = "alergia")
	private String allergies;
	@Column(name = "detalles_procedimientos")
	private String procedureDetails;
	@Column(name = "ordercancelation")
	private boolean orderCancellation;

	public ClinicalHistory(long date, Pet petId, Person veterinarian, String reasonForConsultation, String symptoms,
			String diagnosis, String procedure, String medication, String medicationDose, Order orderId,
			String vaccinationHistory, String allergies, String procedureDetails, boolean orderCancellation) {
		super();
		this.date = date;
		this.petId = petId;
		this.veterinarian = veterinarian;
		this.reasonForConsultation = reasonForConsultation;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.medication = medication;
		this.medicationDose = medicationDose;
		this.orderId = orderId;
		this.vaccinationHistory = vaccinationHistory;
		this.allergies = allergies;
		this.procedureDetails = procedureDetails;
		this.orderCancellation = orderCancellation;
	}

	public ClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) {
		super();
		this.date = clinicalHistoryDto.getDate();
		this.petId = new Pet (clinicalHistoryDto.getPetId());
		this.veterinarian = new Person (clinicalHistoryDto.getVeterinarian());
		this.reasonForConsultation = clinicalHistoryDto.getReasonForConsultation();
		this.symptoms = clinicalHistoryDto.getSymptoms();
		this.diagnosis = clinicalHistoryDto.getSymptoms();
		this.procedure = clinicalHistoryDto.getProcedure();
		this.medication = clinicalHistoryDto.getMedication();
		this.medicationDose = clinicalHistoryDto.getMedicationDose();
		this.orderId = new Order (clinicalHistoryDto.getOrderId());
		this.vaccinationHistory = clinicalHistoryDto.getVaccinationHistory();
		this.allergies = clinicalHistoryDto.getAllergies();
		this.procedureDetails = clinicalHistoryDto.getProcedureDetails();
		this.orderCancellation = clinicalHistoryDto.isOrderCancellation();
	}

	public ClinicalHistory() {

	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public Pet getPetId() {
		return petId;
	}

	public void setPetId(Pet petId) {
		this.petId = petId;
	}

	public Person getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Person veterinarian) {
		this.veterinarian = veterinarian;
	}

	public String getReasonForConsultation() {
		return reasonForConsultation;
	}

	public void setReasonForConsultation(String reasonForConsultation) {
		this.reasonForConsultation = reasonForConsultation;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getMedicationDose() {
		return medicationDose;
	}

	public void setMedicationDose(String medicationDose) {
		this.medicationDose = medicationDose;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public String getVaccinationHistory() {
		return vaccinationHistory;
	}

	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public boolean isOrderCancellation() {
		return orderCancellation;
	}

	public void setOrderCancellation(boolean orderCancellation) {
		this.orderCancellation = orderCancellation;
	}

}
