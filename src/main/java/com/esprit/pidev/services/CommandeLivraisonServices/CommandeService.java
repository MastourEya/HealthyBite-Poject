package com.esprit.pidev.services.CommandeLivraisonServices;

import com.esprit.pidev.entities.CommandeLivraison.Commande;
import com.esprit.pidev.entities.CommandeLivraison.EtatCommande;
import com.esprit.pidev.repository.CommandeLivraisonRepo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService implements ICommande {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }
    @Override
    public Commande addCommande(Commande commande) {
        commande.setEtatCommande(EtatCommande.EN_ATTENTE);
        return commandeRepository.save(commande);
    }
    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommandeById(Long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande getCommandeById(Long id) {
        Optional<Commande> commandeOptional = commandeRepository.findById(id);
        return commandeOptional.orElse(null);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> getCommandesByEtat(EtatCommande etatCommande) {
        return commandeRepository.findByEtatCommande(etatCommande);
    }
}