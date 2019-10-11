package fr.oc.projet.microservicecategorie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceCategorieApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceCategorieApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("MicroServiceCategorie lancé");
	}
}
