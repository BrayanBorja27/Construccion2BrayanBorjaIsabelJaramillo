package tdea.construccion2.appVeterinary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.InvoiceDto;

@Entity
@Table(name = "factura")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long invoiceId;
	@ManyToOne
	@JoinColumn(name = "mascota")
	private Pet petId;
	@ManyToOne
	@JoinColumn(name = "propietario")
	private Person ownerId;
	@Column(name = "producto")
	private String productName;
	@Column(name = "valor")
	private double value;
	@Column(name = "cantidad")
	private long quantity;
	@Column(name = "fecha")
	private long date;

	public Invoice() {

	}

	public Invoice(long invoiceId, Pet petId, Person ownerId, String productName, double value, long quantity,
			long date) {
		super();
		this.invoiceId = invoiceId;
		this.petId = petId;
		this.ownerId = ownerId;
		this.productName = productName;
		this.value = value;
		this.quantity = quantity;
		this.date = date;
	}

	public Invoice(InvoiceDto invoiceDto) {
		super();
		this.invoiceId = invoiceDto.getInvoiceId();
		this.petId = new Pet(invoiceDto.getPetId());
		this.ownerId = new Person(invoiceDto.getOwnerId().getId());
		this.productName = invoiceDto.getProductName();
		this.value = invoiceDto.getValue();
		this.quantity = invoiceDto.getQuantity();
		this.date = invoiceDto.getDate();
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Pet getPetId() {
		return petId;
	}

	public void setPetId(Pet petId) {
		this.petId = petId;
	}

	public Person getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Person ownerId) {
		this.ownerId = ownerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}
