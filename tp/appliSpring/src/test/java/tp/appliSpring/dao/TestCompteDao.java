package tp.appliSpring.dao;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tp.appliSpring.AppliSpringApplication;
import tp.appliSpring.entity.Compte;

//@RunWith(SpringRunner.class) //si junit 4
@ExtendWith(SpringExtension.class) //si junit5/jupiter
@SpringBootTest(classes= {AppliSpringApplication.class}) //meme config que classe avec main()
public class TestCompteDao {
	
	private static Logger logger = LoggerFactory.getLogger(TestCompteDao.class);

	@Autowired //injection de dépendance spring
	private CompteDao compteDao; //à tester
	
	
	@Test()
	void testDao1() {
		Compte compteA = new Compte(null,"compteA",50.0);
		compteDao.save(compteA);
		Long numCptA = compteA.getNumero();
		//Compte compteARelu = compteDao.findById(numCptA).get(); //renvoi exception si pas trouvé
		Compte compteARelu = compteDao.findById(numCptA).orElse(null);
		logger.info("compteARelu="+compteARelu.toString());
		Assertions.assertEquals("compteA",compteARelu.getLabel());
		Assertions.assertEquals(50.0,compteARelu.getSolde(),0.0001);
	}
}
