package codekata.archunit.layered_architecture.model.entity;

// Entity for table "asset"
public class Asset {

    // Primary key
    private Long id;
    private String name;
    private String type;

    public Asset(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
