package dto;

public class AddSaladIngredientDto {
    private Long saladId;
    private Long vegetableId;
    private Double mass;

    public AddSaladIngredientDto(Long saladId, Long vegetableId, Double mass) {
        this.saladId = saladId;
        this.vegetableId = vegetableId;
        this.mass = mass;
    }

    public Long getSaladId() {
        return saladId;
    }

    public void setSaladId(Long saladId) {
        this.saladId = saladId;
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
