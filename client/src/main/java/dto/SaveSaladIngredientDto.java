package dto;

public class SaveSaladIngredientDto {
    private Long vegetableId;
    private Double mass;

    public SaveSaladIngredientDto(Long vegetableId, Double mass) {
        this.vegetableId = vegetableId;
        this.mass = mass;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }
}
