package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.InvoiceDto;
import tdea.construccion2.appVeterinary.Models.Invoice;
import tdea.construccion2.appVeterinary.Repository.SellerRepository;

@Service
public class SellerDaoImp implements SellerDao {

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public void createInvoice(InvoiceDto invoiceDto) throws Exception {

		Invoice invoice = new Invoice(invoiceDto);
		sellerRepository.save(invoice);

	}

	public SellerRepository getSellerRepository() {
		return sellerRepository;
	}

	public void setSellerRepository(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

}
