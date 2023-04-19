package com.esprit.pidev.repository.RepasproduitRepository;

import com.esprit.pidev.entities.ProduitRepas.ObjectifType;
import com.esprit.pidev.entities.ProduitRepas.Repas;
import com.esprit.pidev.entities.UserRole.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RepasRepository extends JpaRepository<Repas,Long> {
    Set<Repas> findByUserId(Long userId);
   // List<Repas> findByCategorieRep(String categorie);
    Optional<Repas> findByNom(String nom);
  List<Repas> findByNomContainingIgnoreCase(String nom);

    @Query("SELECT r FROM Repas r JOIN r.nutrition n WHERE n.calories BETWEEN :minCalories AND :maxCalories AND r.objectif = :objectif")
    List<Repas> findByCaloriesAndObjectif(double minCalories, double maxCalories, ObjectifType objectif);



    List<Repas> findByDateAjoutIsGreaterThan(LocalDateTime lastCheckTime);



}
