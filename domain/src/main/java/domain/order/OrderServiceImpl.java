package domain.order;

import domain.item.Item;

import java.util.Map;

public class OrderServiceImpl implements OrderServicePort {

    OrderPersistencePort orderPersistencePort;

    public OrderServiceImpl(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public void completeOrder(String orderInfo, Map<Item, Integer> basketItems) {
        this.orderPersistencePort.saveOrder(orderInfo, basketItems);
    }
}
