package tdea.construccion2.appVeterinary.Dto;


import tdea.construccion2.appVeterinary.Models.Invoice;

public class InvoiceDto {
	private long invoiceId;
	private PetDto petId;
	private PersonDto ownerId;
	private long orderId;
	private String productName;
	private long quantity;
	private double value;
	private long date;

	public InvoiceDto(long invoiceId, PetDto petId, PersonDto ownerId, long orderId, String productName, long quantity, double value,
			long date) {
		this.invoiceId = invoiceId;
		this.petId = petId;
		this.ownerId = ownerId;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.value = value;
		this.date = date;
	}

	public InvoiceDto() {
	}

	public InvoiceDto(Invoice invoice) {
		this.invoiceId = invoice.getInvoiceId();
		this.petId = new PetDto(invoice.getPetId().getId());
		this.ownerId = new PersonDto(invoice.getOwnerId().getId());
		this.productName = invoice.getProductName();
		this.quantity = invoice.getQuantity();
		this.date = invoice.getDate();
	}
	
	public InvoiceDto(InvoiceDto invoiceDto) {
		this.invoiceId = invoiceDto.getInvoiceId();
		this.petId = new PetDto(invoiceDto.getPetId());
		this.ownerId = new PersonDto(invoiceDto.getOwnerId().getId());
		this.productName = invoiceDto.getProductName();
		this.quantity = invoiceDto.getQuantity();
		this.date = invoiceDto.getDate();
	}
	
	public InvoiceDto(long invoiceId, PetDto pet, PersonDto ownerId, String productName, long quantity, double value,
			long date) {
		this.invoiceId = invoiceId;
		this.petId = pet;
		this.ownerId = ownerId;
		this.productName = productName;
		this.quantity = quantity;
		this.value = value;
		this.date = date;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public PetDto getPetId() {
		return petId;
	}

	public void setPetId(PetDto petId) {
		this.petId = petId;
	}

	public PersonDto getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(PersonDto ownerId) {
		this.ownerId = ownerId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
