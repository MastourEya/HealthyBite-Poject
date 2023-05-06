package com.esprit.pidev.RestController.ReclamationEtReponseController;

import com.esprit.pidev.entities.ReclamationEtReponse.Reclamation;
import com.esprit.pidev.entities.UserRole.User;
import com.esprit.pidev.repository.ReclamationEtReponseRepository.ReclamationRepository;
import com.esprit.pidev.services.ReclamationEtReponseService.IReclamation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ReclamationController {
    IReclamation iReclamation;
    ReclamationRepository reclamationRepository;

    @PostMapping("/assignRepasToReclamation/{idRepas}/{userId}")
    public void assignRepasToReclamation(@RequestBody Reclamation rec , @PathVariable("idRepas")Long idRepas,@PathVariable ("userId")  Long userId) {
        iReclamation.assignRepasToReclamation( rec, idRepas,userId);
    }
    @PostMapping("/addReclamation")
    public void addReclamation( @RequestBody Reclamation rec ) {
        iReclamation.addReclamation( rec);
    }

    @PostMapping("/assignProduitToReclamation/{idProduit}")
    public void assignProduitToReclamation( @RequestBody Reclamation rec ,@PathVariable("idProduit")Long idProduit) {
        iReclamation.assignProduitToReclamation(rec, idProduit);
    }

    @PutMapping("/updateReclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation rec) {
        return iReclamation.updateReclamation(rec);
    }

    @GetMapping("/retrieveReclamationById/{idReclamation}")
    public Reclamation retrieveReclamationById(@PathVariable("idReclamation") Long idReclamation) {
        return iReclamation.retrieveReclamationById(idReclamation);
    }

    @GetMapping("/retrieveAllReclamation")
    public List<Reclamation> retrieveAllReclamation() {
        return iReclamation.retrieveAllReclamation();
    }


    @DeleteMapping("/deleteReclamation/{idReclamation}")
    public void deleteReclamation(@PathVariable("idReclamation") Long idReclamation){
        iReclamation.deleteReclamation(idReclamation);
    }




    @GetMapping("/archived-reclamations")
    public List<Reclamation> getArchivedReclamations(Model model) {
        List<Reclamation> archivedReclamations = reclamationRepository.findByArchivedTrue();
        model.addAttribute("archivedReclamations", archivedReclamations);
        return archivedReclamations;
    }
    @PutMapping("/archiverReclamationNonTraitee")
    public void archiveReclamationsNonTraitees(){
        iReclamation.archiveReclamationsNonTraitees();
    }

    @GetMapping("/retrieveReclamation")
    public List<Reclamation> retrieveReclamation(boolean archived) {
        return iReclamation.retrieveReclamation(archived);
    }

    @GetMapping("/retrieveAllReclamationByUser/{id}")
    public List<Reclamation> retrieveAllReclamationByUser(@PathVariable("id") long userId) {
        return iReclamation.retrieveAllReclamationByUser(userId);
    }

    @GetMapping("/afficherReclamationsTries")
    public List<Reclamation> afficherReclamationsTries(Model model) {
        List<Reclamation> reclamations = reclamationRepository.findAllByOrderByDateReclamation();
        model.addAttribute("reclamations", reclamations);
        return reclamations;
    }

    @GetMapping("/reclamations/mois")
    public List<Object[]> countReclamationsByMonth() {
        return iReclamation.countReclamationsByMonth();
    }
}



//@PostMapping("/assignNotificationToReclamation/{idReclamation}/{idNotification}")
//public void assignNotificationToReclamation(@PathVariable("idReclamation") Long idReclamation,@PathVariable("idNotification") Long idNotification){
//  iReclamation.assignNotificationToReclamation(idReclamation,idNotification);
//}

    //@PostMapping("/assignReclamationToUser/{idReclamation}/{id}")
    //public void assignReclamationToUser(@PathVariable("idReclamation") Long idReclamation,@PathVariable("id") Long id){
    // iReclamation.assignReclamationToUser(idReclamation,id);
    //}


