package data.models;

public class Ingredient extends BaseModel {
    private Long id;
    private Vegetable vegetable;
    private double mass;

    public Ingredient() {}

    public Ingredient(Long id) {
        this.id = id;
    }

    public Ingredient(Long id, Vegetable vegetable, double mass) {
        this.id = id;
        this.vegetable = vegetable;
        this.mass = mass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        String template = "Ingredient{ id=%s, vegetable=%s, mass=%f }";
        return String.format(template, id, vegetable, mass);
    }
}
