package fr.oc.projet.microservicereservation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceReservationApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReservationApplication.class, args);
	}

	private static final Logger logger = LogManager.getLogger();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("MicroServiceReservation lancé");
	}
}
