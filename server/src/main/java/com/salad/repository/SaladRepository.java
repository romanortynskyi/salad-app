package com.salad.repository;

import com.salad.entity.Salad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaladRepository extends CrudRepository<Salad, Long> {
}
