package com.manning.liveproject.dg.liveproject.pastries;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PastryRepository extends CrudRepository<Pastry, Long> {
    List<Pastry> findAll();
}
