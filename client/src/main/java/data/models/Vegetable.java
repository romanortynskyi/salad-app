package data.models;

import java.util.UUID;

public class Vegetable extends BaseModel {
    private Long id;
    private String name;
    private double calories;

    public Vegetable() {}

    public Vegetable(Long id) {
        this.id = id;
    }

    public Vegetable(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public Vegetable(Long id, String name, double calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
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

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        String template = "Vegetable{ id=%s, name=%s, calories=%f }";
        return String.format(template, id, name, calories);
    }
}
