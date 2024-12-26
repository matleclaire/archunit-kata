package codekata.archunit.layered_architecture.model.dto;

public class PositionDTO {

    private Long assetId;
    private String assetName;
    private int quantity;

    public PositionDTO(Long productId, String productName, int quantity) {
        this.assetId = productId;
        this.assetName = productName;
        this.quantity = quantity;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }


    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "productId='" + assetId + '\'' +
                ", productName='" + assetName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
