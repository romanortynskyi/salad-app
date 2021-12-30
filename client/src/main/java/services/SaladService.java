package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import data.models.Ingredient;
import data.models.Salad;
import dto.AddSaladIngredientDto;
import dto.SaveSaladDto;
import dto.UpdateSaladDto;
import exceptions.NotFoundException;
import global.ErrorResponse;
import utils.JsonUtils;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

public class SaladService implements IService<Salad> {
    private HttpService httpService = HttpService.getInstance();
    private static SaladService instance = new SaladService();

    private SaladService() {}

    public static SaladService getInstance() {
        return instance;
    }

    @Override
    public Salad add(Object salad) throws IOException, InterruptedException {
        String uri = "http://localhost:9192/api/v1/salads";
        String json = JsonUtils.stringify(salad);
        HttpResponse<String> response = httpService.post(uri, json, new HashMap<>());
        Salad createdSalad = JsonUtils.parse(response.body(), Salad.class);

        return createdSalad;
    }

    @Override
    public List<Salad> getAll() throws IOException, InterruptedException {
        HttpResponse<String> response = httpService.get("http://localhost:9192/api/v1/salads", new HashMap<>());
        List<Salad> salads = JsonUtils.parseList(response.body(), Salad.class);

        return salads;
    }

    @Override
    public Salad getById(Long id) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/salads/%s", id);
        HttpResponse<String> response = httpService.get(uri, new HashMap<>());

        if(response.statusCode() == 200) {
            Salad salad = JsonUtils.parse(response.body(), Salad.class);
            return salad;
        }
        else {
            String prefix = String.format("Get salad by id %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    @Override
    public Salad update(Long id, Object salad) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/salads/%s", id);
        String json = JsonUtils.stringify(salad);
        HttpResponse<String> response = httpService.put(uri, json, new HashMap<>());

        if(response.statusCode() == 200) {
            Salad updatedSalad = JsonUtils.parse(response.body(), Salad.class);
            return updatedSalad;
        }
        else {
            String prefix = String.format("Update salad %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    @Override
    public void delete(Long id) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/salads/%s", id);
        HttpResponse<String> response = httpService.delete(uri, new HashMap<>());

        if(response.statusCode() != 204) {
            String prefix = String.format("Delete salad %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    public Ingredient addIngredient(AddSaladIngredientDto addSaladIngredientDto) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/ingredients");
        String json = JsonUtils.stringify(addSaladIngredientDto);
        HttpResponse<String> response = httpService.post(uri, json, new HashMap<>());

        if(response.statusCode() == 201) {
            Ingredient ingredient = JsonUtils.parse(response.body(), Ingredient.class);
            return ingredient;
        }
        else {
            String prefix = String.format("Add ingredient:");
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    public void deleteIngredient(Long id) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/ingredients/%s", id);
        HttpResponse<String> response = httpService.delete(uri, new HashMap<>());

        if(response.statusCode() != 204) {
            String prefix = String.format("Delete ingredient %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }
}
