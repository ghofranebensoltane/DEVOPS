package com.example.zitounachref.entities;

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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idClient;

    String nom;

    String prenom;

    @Enumerated(EnumType.STRING)
    Imc imc;

    @OneToMany(mappedBy = "client")
    Set<Plat> plats;

}
