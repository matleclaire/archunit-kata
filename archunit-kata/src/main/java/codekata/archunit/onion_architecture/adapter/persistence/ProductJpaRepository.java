package codekata.archunit.onion_architecture.adapter.persistence;

import codekata.archunit.onion_architecture.domain.model.Product;
import codekata.archunit.onion_architecture.domain.service.ProductName;

@SuppressWarnings("unused")
public class ProductJpaRepository implements ProductRepository {
    @Override
    public Product read(ProductId id) {
        return new Product(id, new ProductName("would normally be read"));
    }

    @Override
    public long getTotalCount() {
        return 0;
    }
}
