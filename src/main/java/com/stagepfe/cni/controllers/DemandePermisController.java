package com.stagepfe.cni.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stagepfe.cni.exception.NotFoundException;
import com.stagepfe.cni.models.DemandeCIN;
import com.stagepfe.cni.models.DemandePermis;
import com.stagepfe.cni.repository.DemandeCinRepository;
import com.stagepfe.cni.repository.DemandePermisRepository;
import com.stagepfe.cni.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class DemandePermisController {

	@Autowired
	private DemandePermisRepository demandepermisRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/permis")
	public List<DemandePermis> getAllCins(){
		return demandepermisRepository.findAll();
	}
	
    @GetMapping("/users/{userId}/permis")
    public DemandePermis getPermisByUserId(@PathVariable Long userId) {
    	
        if(!userRepository.existsById(userId)) {
            throw new NotFoundException("Utilisateur non trouvé");
        }
    	
    	List<DemandePermis> permis = demandepermisRepository.findByUserId(userId);
    	if(permis.size() > 0) {
    		return permis.get(0);
    	}else {
    		throw new NotFoundException("Numéro de permis non trouvé");
    	}
    	
    }
    
    @PostMapping("/users/{userId}/permis")
    public DemandePermis addPermis(@PathVariable Long userId,
                            @Valid @RequestBody DemandePermis permis) {
        return userRepository.findById(userId)
                .map(user -> {
                    permis.setUser(user);
                    return demandepermisRepository.save(permis);
                }).orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));
    }
    
    @PutMapping("/permis/{permisId}")
    public DemandePermis updatePermis(@PathVariable Long permisId,
                               @Valid @RequestBody DemandePermis permisUpdated) {
        return demandepermisRepository.findById(permisId)
                .map(permis -> {
                    permis.setPlacebirth(permisUpdated.getPlacebirth());
                    permis.setNationality(permisUpdated.getNationality());
                    permis.setCity(permisUpdated.getCity());
                    permis.setPostalcode(permisUpdated.getPostalcode());  
             

                    return demandepermisRepository.save(permis);
                }).orElseThrow(() -> new NotFoundException("Permis non trouvé"));
    }
    
    @DeleteMapping("/permis/{permisId}")
    public String deletePermis(@PathVariable Long permisId) {
        return demandepermisRepository.findById(permisId)
                .map(permis -> {
                	demandepermisRepository.delete(permis);
                    return "Permis supprimé avec succés!";
                }).orElseThrow(() -> new NotFoundException("Permis non trouvé!"));
    }

}
