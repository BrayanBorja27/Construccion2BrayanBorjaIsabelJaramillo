package tdea.construccion2.appVeterinary.Dto;

import java.sql.Date;

import tdea.construccion2.appVeterinary.Models.Order;
import tdea.construccion2.appVeterinary.Models.Pet;

public class OrderDto {

    private long orderId;
    private PetDto petId;
    private PersonDto ownerID;
    private PersonDto veterinarianID;
    private String medicationName;
    private String dosage;
    private Date generationDate;

    public OrderDto( PetDto petId, PersonDto ownerID, PersonDto veterinarianID, String medicationName, String dosage, Date generationDate) {
        
        this.petId = petId;
        this.ownerID = ownerID;
        this.veterinarianID = veterinarianID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.generationDate = generationDate;
    }

    public OrderDto(long orderId) {
        this.orderId = orderId;
    }

    public OrderDto(Order order) {
    	this.orderId = order.getOrderId();
    	this.petId = new PetDto(order.getPetId());
        this.ownerID = new PersonDto(order.getOwnerID());
        this.veterinarianID = new PersonDto(order.getVeterinarianID());
        this.medicationName = order.getMedicationName();
        //this.dosage = order.get;
        this.generationDate = order.getGenerationDate();
	}

	public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public PetDto getPetId() {
        return petId;
    }

    public void setPetId(PetDto petId) {
        this.petId = petId;
    }

    public PersonDto getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(PersonDto ownerID) {
        this.ownerID = ownerID;
    }

    public PersonDto getVeterinarianID() {
        return veterinarianID;
    }

    public void setVeterinarianID(PersonDto veterinarianID) {
        this.veterinarianID = veterinarianID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

}
