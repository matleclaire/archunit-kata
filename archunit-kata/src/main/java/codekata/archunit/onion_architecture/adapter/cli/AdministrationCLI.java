package codekata.archunit.onion_architecture.adapter.cli;

import codekata.archunit.onion_architecture.adapter.persistence.ProductRepository;
import codekata.archunit.onion_architecture.application.AdministrationPort;
import codekata.archunit.onion_architecture.application.ShoppingApplication;

@SuppressWarnings("unused")
public class AdministrationCLI {
    public static void main(String[] args) {
        AdministrationPort port = ShoppingApplication.openAdministrationPort();
        handle(args, port);
    }

    private static void handle(String[] args, AdministrationPort port) {
        // violates the pairwise independence of adapters
        ProductRepository repository = port.getInstanceOf(ProductRepository.class);
        long count = repository.getTotalCount();
        // parse arguments and re-configure application according to count through port
    }
}
