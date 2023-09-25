package com.example.zitounachref.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPlat;

    String label;

    Float prix;

    Float calories;

    @Enumerated(EnumType.STRING)
    Categorie categorie;

    @ManyToMany
            @JsonIgnore
    Set<Cuisinier> cuisiniers;

    @ManyToOne
            @JsonIgnore
    Client client;

}
