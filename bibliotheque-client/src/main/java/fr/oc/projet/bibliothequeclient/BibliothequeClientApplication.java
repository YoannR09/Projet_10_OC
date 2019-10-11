package fr.oc.projet.bibliothequeclient;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class BibliothequeClientApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		final Logger logger = LogManager.getLogger();
		return application.sources(BibliothequeClientApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeClientApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
		registrationBean.setFilter(struts);
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
