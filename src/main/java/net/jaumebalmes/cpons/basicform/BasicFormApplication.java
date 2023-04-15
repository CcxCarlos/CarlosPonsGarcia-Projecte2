package net.jaumebalmes.cpons.basicform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/api")
public class BasicFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicFormApplication.class, args);
	}

}
