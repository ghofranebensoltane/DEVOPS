package com.example.zitounachref.services;

import com.example.zitounachref.entities.*;
import com.example.zitounachref.repositories.IClientRepository;
import com.example.zitounachref.repositories.ICuisinierRepository;
import com.example.zitounachref.repositories.IPlatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class Services implements IServices {
    @Autowired
    private final IClientRepository clientRepository;
    @Autowired
    private final IPlatRepository platRepository;
    @Autowired
    private final ICuisinierRepository cuisinierRepository;

    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }


    @Override
    public Cuisinier ajouterCuisisnier(Cuisinier cuisinier) {
        return cuisinierRepository.save(cuisinier);
    }

    @Override
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {
        Client client = clientRepository.findById(idClient).orElse(null);
        Cuisinier cuisinier = cuisinierRepository.findById(idCuisinier).orElse(null);


        Integer i = 0;
        for(Plat p : client.getPlats()){
            if(p.getCategorie().toString().equals("PRINCIPALE"))
                i=i+1;
        }

        if(i<2 || plat.getCategorie().toString().equals("DESSERT") || plat.getCategorie().toString().equals("ENTREE") ){
            plat.setClient(client);
            Set<Cuisinier> cuisiniers = new HashSet<>();
            cuisiniers.add(cuisinier);
            plat.setCuisiniers(cuisiniers);
            platRepository.save(plat);
        }
        else {
            System.out.println("Plus que deux plats principales");
        }
    }

    @Override
    public List<Plat> AfficherListePlatsParCliet(String nom, String prenom) {
        Client client = clientRepository.findDistinctFirstByNomAndPrenom(nom,prenom);
        List<Plat> plats = new ArrayList<>();
        for(Plat p : client.getPlats()){
            plats.add(p);
        }
        return plats;
    }

    @Override
    public float MontantAPayerParClient(Integer idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        float somme = 0;
        for (Plat p : client.getPlats()){
            somme = somme + p.getPrix();
        }
        return somme;
    }

    @Override
    public void ModifierImc(Integer idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        float somme = 0;
        for(Plat p : client.getPlats()){
            somme = somme+p.getCalories();
        }

        if(somme<2000){
            client.setImc(Imc.FAIBLE);
        }
        else if(somme==2000){
            client.setImc(Imc.IDEAL);
        }
        else {
            client.setImc(Imc.FORT);
        }
        clientRepository.save(client);
    }

    @Override
    @Scheduled(cron = "1/15 * * * * *")
    @Transactional
    public void AfficherListeCuisinier() {
        List<Cuisinier> cuisiniers = new ArrayList<>();
        cuisinierRepository.findAll().forEach(cuisiniers::add);
        int i = 0;
        for (Cuisinier cuisinier: cuisiniers){
            i=0;
            for (Plat p : cuisinier.getPlats()){
                if(p.getCategorie().toString().equals("PRINCIPALE")){
                    i = i+1;
                }
            }
            if(i>=2){
                System.out.println("-------------------------");
                System.out.println(cuisinier.getNom() + " " + cuisinier.getPrenom());
            }
        }
    }




}
