package tdea.construccion2.appVeterinary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.appVeterinary.Models.Invoice;

@Repository
public  interface SellerRepository extends JpaRepository<Invoice, Long>{
	
	//public void createInvoice(Invoice invoice) throws Exception;

}
