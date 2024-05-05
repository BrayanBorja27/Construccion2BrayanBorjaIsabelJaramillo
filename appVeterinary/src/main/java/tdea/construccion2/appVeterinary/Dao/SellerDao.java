package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.InvoiceDto;

public interface SellerDao {
	
	public void createInvoice(InvoiceDto invoiceDto) throws Exception;
    
}
