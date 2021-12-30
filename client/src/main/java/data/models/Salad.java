package data.models;

import java.util.List;
import java.util.UUID;

public class Salad extends BaseModel {
    private Long id;
    private String name;
    private Double calories;
    private List<Ingredient> ingredients;

    public Salad() {}

    public Salad(Long id, List<Ingredient> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }

    public Salad(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Salad(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Salad(Long id, String name, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Salad(Long id, String name, Double calories, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        String template = "Salad{ id=%s, name=%s, ingredients=%s }";
        return String.format(template, id, name, ingredients.toString());
    }
}
