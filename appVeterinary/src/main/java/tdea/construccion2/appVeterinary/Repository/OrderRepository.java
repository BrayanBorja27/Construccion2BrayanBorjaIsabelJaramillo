package tdea.construccion2.appVeterinary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.appVeterinary.Dto.OrderDto;
//import jakarta.persistence.criteria.Order;
import tdea.construccion2.appVeterinary.Models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	//public Order createOrden(Order order) throws Exception;

	public Order findById(long orderId) throws Exception;
	
	//public void  cancelOrderById (Order order) throws Exception;

}
