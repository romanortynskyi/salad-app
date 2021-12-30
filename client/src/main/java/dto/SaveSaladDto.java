package dto;

import java.util.List;

public class SaveSaladDto {
    private String name;
    private List<SaveSaladIngredientDto> ingredients;

    public SaveSaladDto(String name, List<SaveSaladIngredientDto> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SaveSaladIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<SaveSaladIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }
}
