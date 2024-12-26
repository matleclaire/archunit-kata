package codekata.archunit.layered_architecture.service;

import codekata.archunit.layered_architecture.model.entity.Portfolio;
import codekata.archunit.layered_architecture.repository.AssetRepository;
import codekata.archunit.layered_architecture.repository.PortfolioRepository;

public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final AssetRepository assetRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, AssetRepository assetRepository) {
        this.portfolioRepository = portfolioRepository;
        this.assetRepository = assetRepository;
    }

    public void addToPortfolio(long portfolioId, long assetId, int quantity) {

        var portfolioOpt = portfolioRepository.findById(portfolioId);
        if (portfolioOpt.isEmpty()) {
            throw new IllegalArgumentException("Portfolio not found");
        }

        var assetOpt = assetRepository.findById(assetId);
        if (assetOpt.isEmpty()) {
            throw new IllegalArgumentException("Asset not found");
        }

        var portfolio = portfolioOpt.get();

        //... Logic to create and add a position for this asset to the portfolio

        portfolioRepository.save(portfolio);

    }

    public Portfolio getPortfolio(long id) {
        return portfolioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Portfolio not found"));
    }
}
