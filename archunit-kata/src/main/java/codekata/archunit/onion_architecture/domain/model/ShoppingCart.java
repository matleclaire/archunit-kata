package codekata.archunit.onion_architecture.domain.model;

import java.util.HashSet;
import java.util.Set;

import codekata.archunit.onion_architecture.adapter.persistence.ShoppingCartId;

@SuppressWarnings("unused")
public class ShoppingCart {
    private final ShoppingCartId id;
    private final Set<OrderItem> orderItems = new HashSet<>();

    public ShoppingCart(ShoppingCartId id) {
        this.id = id;
    }

    public void add(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void executeOrder(PaymentMethod method) {
        // complete financial transaction and initiate shipping process
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", orderItems=" + orderItems + '}';
    }
}
