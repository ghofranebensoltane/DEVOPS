package com.example.zitounachref.repositories;

import com.example.zitounachref.entities.Cuisinier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuisinierRepository extends CrudRepository<Cuisinier,Integer> {
}
