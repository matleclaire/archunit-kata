package codekata.archunit.layered_architecture.model.dto;

import java.util.List;

public class PortfolioDTO {

    private Long id;
    private String name;
    private String currency;
    private List<PositionDTO> positions;


    public PortfolioDTO(Long id, String name, String currency, List<PositionDTO> positions) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.positions = positions;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDTO> positions) {
        this.positions = positions;
    }


    @Override
    public String toString() {
        return "PortfolioDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", positions=" + positions +
                '}';
    }
}
