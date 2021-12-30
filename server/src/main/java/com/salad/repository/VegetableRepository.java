package com.salad.repository;

import com.salad.entity.Vegetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Long> {
}
