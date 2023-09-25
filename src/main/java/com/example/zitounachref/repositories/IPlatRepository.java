package com.example.zitounachref.repositories;

import com.example.zitounachref.entities.Plat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatRepository extends CrudRepository<Plat, Integer> {
}
