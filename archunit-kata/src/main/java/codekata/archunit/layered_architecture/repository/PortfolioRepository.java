package codekata.archunit.layered_architecture.repository;

import codekata.archunit.layered_architecture.model.entity.Portfolio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class PortfolioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioRepository.class);

    public Optional<Portfolio> findById(long portfolioId) {
        LOGGER.debug("Querying database for portfolio with id {}", portfolioId);
        // Query database and return portfolio
        return Optional.empty();
    }

    public void save(Portfolio portfolio) {
        LOGGER.debug("Saving portfolio {}", portfolio);
        // Update portfolio in database
    }
}
