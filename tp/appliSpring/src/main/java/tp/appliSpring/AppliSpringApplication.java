package tp.appliSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import tp.appliSpring.experimentation.TraducteurConfig;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package

@SpringBootApplication
//@Import(TraducteurConfig.class) //si TraducteurConfig dans tpa et pas dans tp.appliSpring
public class AppliSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliSpringApplication.class, args);
		System.out.println("http://localhost:8080/appliSpring");
	}

}
