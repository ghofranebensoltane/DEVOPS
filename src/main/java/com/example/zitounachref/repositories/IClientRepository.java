package com.example.zitounachref.repositories;

import com.example.zitounachref.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<Client,Integer> {
    Client findDistinctFirstByNomAndPrenom(String nom, String prenom);
}
