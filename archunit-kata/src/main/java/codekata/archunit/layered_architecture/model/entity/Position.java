package codekata.archunit.layered_architecture.model.entity;

// Entity for table "position"
public class Position {

    // Primary key
    private Long id;

    private Portfolio portfolio;
    private Asset asset;
    private int quantity;

    public Position(Long id, Portfolio portfolio, Asset asset, int quantity) {
        this.id = id;
        this.portfolio = portfolio;
        this.asset = asset;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", portfolio=" + portfolio +
                ", asset=" + asset +
                ", quantity=" + quantity +
                '}';
    }
}
