package tp.appliSpring.experimentation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Version2 avec injection via constructeur

@Component
public class Afficheur {
	
	private Traducteur traducteurPrincipal/*=null*/;
	
	
	public Afficheur(@Qualifier("FrancaisAnglais") Traducteur traducteurPrincipal) {
		this.traducteurPrincipal=traducteurPrincipal;
		System.out.println("Dans le constructeur de Afficheur qui fait de l'injection de dépendance traducteurPrincipal="+traducteurPrincipal);
		//pas besoin de @PostConstruct si injection via constructeur
	}
	
	
	
	public void traduireEtAfficher(String message) {
		String traduction = this.traducteurPrincipal.traduire(message);
		System.out.println("traduction="+traduction);
	}

}
