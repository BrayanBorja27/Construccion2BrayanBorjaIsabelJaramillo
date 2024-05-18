package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.OrderDto;

public interface OrderDao {

	public OrderDto createOrden(OrderDto orderDto) throws Exception;

	public OrderDto findOrderById(long orderId) throws Exception;

	public void cancelOrder(OrderDto orderDto) throws Exception;
}
