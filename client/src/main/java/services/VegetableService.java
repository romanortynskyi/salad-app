package services;

import data.models.Vegetable;
import exceptions.NotFoundException;
import exceptions.VegetableNotFoundException;
import global.ErrorResponse;
import utils.JsonUtils;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

public class VegetableService implements IService<Vegetable> {
    private HttpService httpService = HttpService.getInstance();
    private static VegetableService instance = new VegetableService();

    private VegetableService() {}

    public static VegetableService getInstance() {
        return instance;
    }

    @Override
    public Vegetable add(Object vegetable) throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        String uri = "http://localhost:9192/api/v1/vegetables";
        String json = JsonUtils.stringify(vegetable);
        HttpResponse<String> response = httpService.post(uri, json, new HashMap<>());
        Vegetable createdVegetable = JsonUtils.parse(response.body(), Vegetable.class);

        return createdVegetable;
    }

    @Override
    public List<Vegetable> getAll() throws IOException, InterruptedException {
        HttpResponse<String> response = httpService.get("http://localhost:9192/api/v1/vegetables", new HashMap<>());
        List<Vegetable> vegetables = JsonUtils.parseList(response.body(), Vegetable.class);

        return vegetables;
    }

    @Override
    public Vegetable getById(Long id) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/vegetables/%s", id);
        HttpResponse<String> response = httpService.get(uri, new HashMap<>());

        if(response.statusCode() == 200) {
            Vegetable vegetable = JsonUtils.parse(response.body(), Vegetable.class);
            return vegetable;
        }
        else {
            String prefix = String.format("Get vegetable by id %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    @Override
    public Vegetable update(Long id, Object vegetable) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/vegetables/%s", id);
        String json = JsonUtils.stringify(vegetable);
        HttpResponse<String> response = httpService.put(uri, json, new HashMap<>());

        if(response.statusCode() == 200) {
            Vegetable updatedVegetable = JsonUtils.parse(response.body(), Vegetable.class);
            return updatedVegetable;
        }
        else {
            String prefix = String.format("Update vegetable %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }

    @Override
    public void delete(Long id) throws IOException, InterruptedException, NotFoundException {
        String uri = String.format("http://localhost:9192/api/v1/vegetables/%s", id);
        HttpResponse<String> response = httpService.delete(uri, new HashMap<>());

        if(response.statusCode() != 204) {
            String prefix = String.format("Delete vegetable %s:", id);
            ErrorResponse error = JsonUtils.parse(response.body(), ErrorResponse.class);

            String message = String.format("%s %s", prefix, error.getMessage());
            throw new NotFoundException(message);
        }
    }
}
