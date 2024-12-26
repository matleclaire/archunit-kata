package codekata.archunit.layered_architecture.model.entity;

import java.util.List;

// Entity for table "portfolio"
public class Portfolio {

    // Primary key
    private Long id;

    private String name;

    private String currency;

    private List<Position> positions;

    public Portfolio(Long id, String name, String currency, List<Position> positions) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.positions = positions;
    }

    public boolean hasNoPositions() {
        return positions != null && positions.isEmpty();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", positions=" + positions +
                '}';
    }
}
