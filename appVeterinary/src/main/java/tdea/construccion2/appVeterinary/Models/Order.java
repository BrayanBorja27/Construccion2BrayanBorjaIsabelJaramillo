package tdea.construccion2.appVeterinary.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.OrderDto;
@Entity
@Table(name="orden")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private long orderId;
	@ManyToOne
    @JoinColumn(name="mascota")
    private Pet petId;
	@ManyToOne
    @JoinColumn(name="propietario")
    private Person ownerID;
	@ManyToOne
    @JoinColumn(name="medico")
    private Person veterinarianID;
	@Column(name="medicamento")
    private String medicationName;
	@Column(name="fecha")	
    private Date generationDate;
	
	public Order() {}
			

	public Order(OrderDto orderId) {
		this.orderId = orderId.getOrderId();
		this.petId = new Pet (orderId.getPetId());
		this.ownerID = new Person (orderId.getOwnerID());
		this.veterinarianID = new Person (orderId.getVeterinarianID());
		this.medicationName = orderId.getMedicationName();
		this.generationDate = orderId.getGenerationDate();
		
	}

	public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }

    public Person getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Person ownerID) {
        this.ownerID = ownerID;
    }

    public Person getVeterinarianID() {
        return veterinarianID;
    }

    public void setVeterinarianID(Person veterinarianID) {
        this.veterinarianID = veterinarianID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }


    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    
    
}
