package com.esprit.pidev.entities.ReclamationEtReponse;

import com.esprit.pidev.entities.ProduitRepas.Produit;
import com.esprit.pidev.entities.ProduitRepas.Repas;
import com.esprit.pidev.entities.UserRole.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;

    @Temporal(TemporalType.DATE )
    private Date dateReclamation;
    private String textReclamation;

    private String etatReclamation;
    private Boolean archived=false;

    @OneToOne
    @JsonIgnore
    private Notification notifications;

    @OneToOne
    @JsonIgnoreProperties("reclamation")
    private ReponseReclamation reponseReclamation;

    @ManyToOne
    @JsonIgnoreProperties("reclamations")
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("reclamations")
    private Repas repas;

    @ManyToOne
    @JsonIgnore
    private Produit produit;

}
