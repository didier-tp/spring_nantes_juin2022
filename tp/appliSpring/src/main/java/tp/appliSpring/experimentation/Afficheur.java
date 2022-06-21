package tp.appliSpring.experimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Afficheur {
	
	@Autowired
	private Traducteur traducteurPrincipal;
	
	public void traduireEtAfficher(String message) {
		String traduction = this.traducteurPrincipal.traduire(message);
		System.out.println("traduction="+traduction);
	}

}
