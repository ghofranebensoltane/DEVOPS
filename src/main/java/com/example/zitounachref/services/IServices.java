package com.example.zitounachref.services;

import com.example.zitounachref.entities.Client;
import com.example.zitounachref.entities.Cuisinier;
import com.example.zitounachref.entities.Plat;

import java.util.List;

public interface IServices {
    public Client ajouterClient(Client client);

    public Cuisinier ajouterCuisisnier(Cuisinier cuisinier);

    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier);

    List<Plat> AfficherListePlatsParCliet(String nom, String prenom);

    public float MontantAPayerParClient(Integer idClient);

    public void ModifierImc(Integer idClient);

    public void AfficherListeCuisinier();

}
