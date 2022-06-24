package tp.appliSpring.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class) //si junit5/jupiter
@WebMvcTest(CompteRestCtrl.class)
@ActiveProfiles({"embbededDb","init"})
public class CompteJsonRestCtrlTest {

	@Autowired
	private MockMvc mvc;

	
	@Test
	public void testXyz(){
		
	try {
		mvc.perform(get("api-bank/compte?numClient=1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2) ))
		.andExpect(jsonPath("$[0].label", is("compteA") ));
	} catch (Exception e) {
		System.err.println(e.getMessage());
		//e.printStackTrace();
	}
	//à adapter selon jeux de données de init.ReInitDefaultDataset
	}
}
