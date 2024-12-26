package codekata.archunit.onion_architecture.adapter.persistence;

import codekata.archunit.onion_architecture.domain.model.ShoppingCart;

@SuppressWarnings("unused")
public class ShoppingCartJpaRepository implements ShoppingCartRepository {
    @Override
    public ShoppingCart read(ShoppingCartId id) {
        // would normally load fully initialized shopping cart
        return new ShoppingCart(id);
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        // store shopping cart via JPA
    }
}
