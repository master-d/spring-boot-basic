package bsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ComponentScan(basePackages= {"bsb","bsb.controllers"})
public class BasicSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringBootApplication.class, args);
	}

}

