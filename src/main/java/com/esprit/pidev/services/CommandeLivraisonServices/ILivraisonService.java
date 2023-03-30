package com.esprit.pidev.services.CommandeLivraisonServices;

import com.esprit.pidev.entities.CommandeLivraison.EtatCommande;
import com.esprit.pidev.entities.CommandeLivraison.Livraison;

import java.util.List;

public interface ILivraisonService {
    Livraison addLivraison(Livraison livraison);
    Livraison updateLivraison(Livraison livraison);
    void deleteLivraison(Long id);
    Livraison getLivraisonById(Long id);
    List<Livraison> getAllLivraisons();
    List<Livraison> getLivraisonsByEtatCommande(String etatCommande);
    Livraison accepterLivraison(Long id);
    Livraison refuserLivraison(Long id);
}





