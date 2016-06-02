package pl.stalostech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.factory.CarFactory;

@Configuration
@EnableAutoConfiguration
@ComponentScan("pl.stalostech.*")
public class ApplicationJPA implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJpa")
	private CRUD jpaCrud;

	@Autowired
	private CarFactory carFactory;

	public static void main(String args[]) {
		SpringApplication.run(ApplicationJPA.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		jpaCrud.createBatch(); // 1076

		carFactory.prepareData(); //preapare test data

	}
}