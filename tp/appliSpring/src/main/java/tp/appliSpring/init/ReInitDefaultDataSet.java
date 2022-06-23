package tp.appliSpring.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tp.appliSpring.dao.ClientDao;
import tp.appliSpring.entity.Client;
import tp.appliSpring.entity.Compte;
import tp.appliSpring.service.CompteService;

@Component
@Profile("init")
public class ReInitDefaultDataSet {

	@Autowired
	private CompteService compteService;
	
	@Autowired
	private ClientDao clientDao ;
	
	@PostConstruct
	public void initDataSet() {
		
		Client c1 =  clientDao.save(new Client(null,"jean","Bon"));
		Compte cptA = new Compte(null,"compteA",50.0);
		cptA.setClient(c1);
		compteService.sauvegarderCompte(cptA);
		compteService.sauvegarderCompte(new Compte(null,"compteB",150.0));
		compteService.sauvegarderCompte(new Compte(null,"compteC",250.0));
	}
}
