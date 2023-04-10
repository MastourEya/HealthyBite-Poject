package com.esprit.pidev.RestController.ReclamationEtReponseController;

import com.esprit.pidev.entities.ReclamationEtReponse.ReponseReclamation;
import com.esprit.pidev.services.ReclamationEtReponseService.IReponseReclamation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReponseReclamationController {
    IReponseReclamation iReponseReclamation;

    @PostMapping("/addReponseReclamation")
    public ReponseReclamation addReponseReclamation(@RequestBody ReponseReclamation repr){
      return iReponseReclamation.addReponseReclamation(repr) ;
    }

    @PutMapping("/updateReponseReclamation")
    public ReponseReclamation updateReponseReclamation(@RequestBody ReponseReclamation repr){
        return iReponseReclamation.updateReponseReclamation(repr);
    }
    @GetMapping("/retrieveReponseReclamationById/{idReponseReclamation}")
    public ReponseReclamation retrieveReponseReclamationById(@PathVariable("idReponseReclamation") Long idReponseReclamation){
        return iReponseReclamation.retrieveReponseReclamationById(idReponseReclamation);
    }
    @GetMapping("/retrieveAllReponseReclamation")
    public List<ReponseReclamation> retrieveAllReponseReclamation(){
        return iReponseReclamation.retrieveAllReponseReclamation();
    }
    @DeleteMapping("/deleteReponseReclamation/{idReponseReclamation}")
    public void deleteReclamation(@PathVariable("idReponseReclamation") Long idReponseReclamation){
        iReponseReclamation.deleteReponseReclamation(idReponseReclamation);
    }

    //@PostMapping("/assignResponseReclamationToReclamation/{idReponseReclamation}/{idReclamation}")
    //ReponseReclamation assignResponseReclamationToReclamation(@PathVariable("idReponseReclamation") Long idReponseReclamation,@PathVariable("idReclamation") Long idReclamation){
    //return iReponseReclamation.assignResponseReclamationToReclamation(idReponseReclamation, idReclamation);
    //}
}