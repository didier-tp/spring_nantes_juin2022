package tp.appliSpring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.exception.NotFoundException;
import tp.appliSpring.service.CompteService;

@RestController
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCrtl {
	
	private CompteService compteService;
	
	
	public CompteRestCrtl(CompteService compteService) {
		super(); //injection de dépendance par construteur
		this.compteService = compteService;
	}

     /*
    //url = http://localhost:8080/appliSpring/api-bank/compte/1
    @GetMapping("/{numCompte}")
	public Compte getCompteByNum(@PathVariable("numCompte")Long numCpt) {
		return compteService.compteSelonNumero(numCpt);
	}
     */
	
	/*
	//url = http://localhost:8080/appliSpring/api-bank/compte/1
    @GetMapping("/{numCompte}")
	public ResponseEntity<Compte> getCompteByNum(@PathVariable("numCompte")Long numCpt) {
		Compte compte =  compteService.compteSelonNumero(numCpt);
		if(compte!=null)
			return new ResponseEntity<Compte>(compte,HttpStatus.OK);
		else
			return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
	}
	*/
    
    //url = http://localhost:8080/appliSpring/api-bank/compte/1
    @GetMapping("/{numCompte}")
   	public Compte getCompteByNum(@PathVariable("numCompte")Long numCpt) {
   		Compte compte = compteService.compteSelonNumero(numCpt);
   		if(compte!=null) 
   			return compte;
   		else 
   			throw new NotFoundException("compte " + numCpt + " pas trouve" );
   		//NB: au dessus de NotFoundException il y a @ResponseStatus(HttpStatus.NOT_FOUND)
   	}
	

}
