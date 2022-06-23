package tp.appliSpring.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.appliSpring.entity.Compte;
import tp.appliSpring.service.CompteService;

@Component
@Profile("init")
public class ReInitDefaultDataSet {

	@Autowired
	private CompteService compteService;
	
	@PostConstruct
	public void initDataSet() {
		compteService.sauvegarderCompte(new Compte(null,"compteA",50.0));
		compteService.sauvegarderCompte(new Compte(null,"compteB",150.0));
		compteService.sauvegarderCompte(new Compte(null,"compteC",250.0));
	}
}
