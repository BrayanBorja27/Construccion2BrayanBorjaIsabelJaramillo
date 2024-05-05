
package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.OrderDto;
//import jakarta.persistence.criteria.Order;
import tdea.construccion2.appVeterinary.Models.Order;
import tdea.construccion2.appVeterinary.Repository.OrderRepository;

@Service
public class OrderDaoImp implements OrderDao {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDto createOrden(OrderDto orderDto) throws Exception {

		Order order = new Order(orderDto);
		order = orderRepository.save(order);

		return new OrderDto(order);
	}

	@Override
	public OrderDto findOrderById(long orderId) throws Exception {

		Order order = orderRepository.findById(orderId);
		if (order == null) {
			return null;
		}
		return new OrderDto(order);

	}

	@Override
	public void cancelOrder(OrderDto orderDto) throws Exception {
		//Person person = new Person(orderDto.getOwnerID());
		//orderDto = new OrderDto(orderDto.getOrderId());
		Order order = orderRepository.findById(orderDto.getOrderId());
		orderRepository.delete(order);
		
		System.out.println("Orden cancelada exitasamente: " + orderDto.getOrderId());
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

}
