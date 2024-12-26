package codekata.archunit.layered_architecture.api;


import codekata.archunit.layered_architecture.model.dto.PortfolioDTO;
import codekata.archunit.layered_architecture.model.dto.PositionDTO;
import codekata.archunit.layered_architecture.model.entity.Portfolio;
import codekata.archunit.layered_architecture.service.PortfolioService;

import java.util.ArrayList;

public class PortfolioController {

    private final PortfolioService portfolioService;


    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // @POST or similar
    public void addToPortfolio(long portfolioId, long assetId, int quantity) {
        portfolioService.addToPortfolio(portfolioId, assetId, quantity);
    }

    // @GET or similar
   public PortfolioDTO getPortfolio(long id) {
       var portfolio = portfolioService.getPortfolio(id);
       return convertToDTO(portfolio);
   }

    private PortfolioDTO convertToDTO(Portfolio portfolio) {
        var portfolioDTO = new PortfolioDTO(portfolio.getId(), portfolio.getName(), portfolio.getCurrency(), new ArrayList<>());
        portfolio.getPositions().forEach(position -> {
            var positionDTO = new PositionDTO(position.getAsset().getId(), position.getAsset().getName(), position.getQuantity());
            portfolioDTO.getPositions().add(positionDTO);
        });
        return portfolioDTO;
    }
}
