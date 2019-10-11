package fr.oc.projet.microserviceabonne;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MicroserviceAbonneApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAbonneApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("MicroServiceAbonne lancé");
	}
}
