package codekata.archunit.onion_architecture.domain.service;

import codekata.archunit.onion_architecture.adapter.persistence.ProductId;
import codekata.archunit.onion_architecture.adapter.persistence.ProductRepository;
import codekata.archunit.onion_architecture.adapter.persistence.ShoppingCartId;
import codekata.archunit.onion_architecture.adapter.persistence.ShoppingCartRepository;
import codekata.archunit.onion_architecture.domain.model.OrderItem;
import codekata.archunit.onion_architecture.domain.model.Product;
import codekata.archunit.onion_architecture.domain.model.ShoppingCart;

public class PortfolioService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public PortfolioService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public void addToShoppingCart(ShoppingCartId shoppingCartId, ProductId productId, OrderQuantity quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.read(shoppingCartId);
        Product product = productRepository.read(productId);
        OrderItem newItem = new OrderItem(product, quantity);
        shoppingCart.add(newItem);
        shoppingCartRepository.save(shoppingCart);
    }
}
