package com.example.zitounachref.controllers;

import com.example.zitounachref.entities.Client;
import com.example.zitounachref.entities.Cuisinier;
import com.example.zitounachref.entities.Plat;
import com.example.zitounachref.services.IServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class Controller {
    private final IServices services;

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return services.ajouterClient(client);
    }

    @PostMapping("/ajouterCuisisnier")
    public Cuisinier ajouterCuisisnier(@RequestBody Cuisinier cuisinier) {
        return services.ajouterCuisisnier(cuisinier);
    }

    @PutMapping("/ajouterPlatAffecterClientEtCuisinier/{idclient}/{idcuisinier}")
    public void ajouterPlatAffecterClientEtCuisinier(@RequestBody Plat plat, @PathVariable("idclient") Integer idClient,
                                                     @PathVariable("idcuisinier") Integer idCuisinier) {
        services.ajouterPlatAffecterClientEtCuisinier(plat, idClient, idCuisinier);
    }

    @GetMapping("/AfficherListePlatsParCliet/{nom}/{prenom}")
    public List<Plat> AfficherListePlatsParCliet(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return services.AfficherListePlatsParCliet(nom,prenom);
    }

    @GetMapping("/MontantAPayerParClient/{idclient}")
    public float MontantAPayerParClient(@PathVariable("idclient") Integer idClient) {
        return services.MontantAPayerParClient(idClient);
    }

    @PutMapping("/ModifierImc/{idclient}")
    public void ModifierImc(@PathVariable("idclient") Integer idClient) {
        services.ModifierImc(idClient);
    }




    }
