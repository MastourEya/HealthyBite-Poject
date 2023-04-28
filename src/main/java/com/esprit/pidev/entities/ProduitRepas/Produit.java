package com.esprit.pidev.entities.ProduitRepas;

import com.esprit.pidev.entities.ConseilRecette.TypeActivite;
import com.esprit.pidev.entities.ReclamationEtReponse.Reclamation;
import com.esprit.pidev.entities.UserRole.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private double prix;
    private String ingredient;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private CategProduit categoriePro;
    private Boolean bloquee=false;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Nutrition nutrition;

    private int quantite;
    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private Set<Reclamation> reclamations;
}
