package tp.appliSpring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.appliSpring.dao.CompteDao;
import tp.appliSpring.entity.Compte;
import tp.appliSpring.service.CompteService;

@Service //@Component de type "service metier"
//@Transactional
public class CompteServiceImpl implements CompteService {

	@Autowired //@Autowired (spécifique Spring) est un équivalent de
	//@Inject du concurrent DI/CDI/EJB/JEE
	//@Autowired demande au framework spring d'initialiser la référence compteDao
	//pour que ça pointe vers un commposant spring qui est compatible avec l'interface
	private CompteDao compteDao=null;
	
	@Override
	public List<Compte> comptesDuClient(long numClient) {
		// sera codé ultérieurement
		return null;
	}

	@Override
	public List<Compte> tousLesComptes() {
		return compteDao.findAll();
	}

	@Override
	public Compte compteSelonNumero(long numeroCompte) {
		//return compteDao.findById(numeroCompte).get(); //return exception si empty
		return compteDao.findById(numeroCompte).orElse(null); //return null if not null
	}

	@Override
	@Transactional
	public void effectuerVirement(double montant, long numCptDeb, long numCptCred) {
		Compte compteDeb = compteDao.findById(numCptDeb).get();
        compteDeb.setSolde(compteDeb.getSolde() - montant);
        compteDao.save(compteDeb);//pas nécessaire si @Transactional
        
        Compte compteCred = compteDao.findById(numCptCred).get();
        compteCred.setSolde(compteCred.getSolde() + montant);
        compteDao.save(compteCred);//pas nécessaire si @Transactional
	}

	@Override
	public Compte sauvegarderCompte(Compte compte) {
		return compteDao.save(compte);
	}

	@Override
	public void supprimerCompte(long numCpt) {
		compteDao.deleteById(numCpt);
	}

}
