package tp.appliSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.service.CompteService;

@RestController
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCrtl {
	
	private CompteService compteService;
	
	
	public CompteRestCrtl(CompteService compteService) {
		super(); //injection de dépendance par construteur
		this.compteService = compteService;
	}


    //url = http://localhost:8080/appliSpring/api-bank/compte/1
    @GetMapping("/{numCompte}")
	public Compte getCompteByNum(@PathVariable("numCompte")Long numCpt) {
		return compteService.compteSelonNumero(numCpt);
	}

	

}
