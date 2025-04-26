package br.com.trampuu.trampuu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"br.com.trampuu.trampuu",
		"Controller",
		"Services",
		"Repository",
		"Model"
})
public class TrampuuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrampuuApplication.class, args);
	}

}
