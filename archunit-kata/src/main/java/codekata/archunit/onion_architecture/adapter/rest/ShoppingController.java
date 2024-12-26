package codekata.archunit.onion_architecture.adapter.rest;

import java.util.UUID;

import codekata.archunit.onion_architecture.adapter.persistence.ProductId;
import codekata.archunit.onion_architecture.adapter.persistence.ShoppingCartId;
import codekata.archunit.onion_architecture.domain.service.OrderQuantity;
import codekata.archunit.onion_architecture.domain.service.PortfolioService;

@SuppressWarnings("unused")
public class ShoppingController {
    private final PortfolioService shoppingService;

    public ShoppingController(PortfolioService shoppingService) {
        this.shoppingService = shoppingService;
    }

    // @POST or similar
    public void addToShoppingCart(UUID shoppingCartId, UUID productId, int quantity) {
        shoppingService.addToShoppingCart(new ShoppingCartId(shoppingCartId), new ProductId(productId), new OrderQuantity(quantity));
    }
}
