package domain.basket;

import domain.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketServiceImpl implements BasketServicePort {

    BasketPersistencePort persistencePort;

    public BasketServiceImpl(BasketPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public void add(Item item) {
        persistencePort.add(item);
    }

    @Override
    public void remove(Item item) {
        persistencePort.remove(item);
    }

    @Override
    public void decrease(Item item) {
        persistencePort.decrease(item);
    }

    @Override
    public void clear() {
        persistencePort.clear();
    }

    @Override
    public int getBasketItemCount() {
        return persistencePort.getBasketItemCount();
    }

    @Override
    public Map<Item, Integer> getBasketItems() {
        return persistencePort.getBasketItems();
    }
}
