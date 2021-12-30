package services;

import exceptions.NotFoundException;
import exceptions.SaladNotFoundException;
import exceptions.VegetableNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface IService<T> {
    T add(Object object) throws IOException, ClassNotFoundException, NotFoundException, InterruptedException;
    List<T> getAll() throws IOException, ClassNotFoundException, InterruptedException;
    T getById(Long id) throws IOException, ClassNotFoundException, NotFoundException, InterruptedException;
    T update(Long id, Object object) throws IOException, ClassNotFoundException, NotFoundException, InterruptedException;
    void delete(Long id) throws IOException, ClassNotFoundException, NotFoundException, InterruptedException;
}
