package fr.oc.projet.microservicelivre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceLivreApplication  implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLivreApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("MicroServiceLivre lancé");
	}
}
