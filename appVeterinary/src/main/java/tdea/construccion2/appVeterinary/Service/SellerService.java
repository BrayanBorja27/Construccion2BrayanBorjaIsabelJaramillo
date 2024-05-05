package tdea.construccion2.appVeterinary.Service;

import tdea.construccion2.appVeterinary.Dto.InvoiceDto;
import tdea.construccion2.appVeterinary.Dto.OrderDto;

public interface SellerService {
    
    public void checkOrder(OrderDto OrderDto) throws Exception;

    public void generateSalesInvoice(InvoiceDto invoiceDto) throws Exception;
    
}
