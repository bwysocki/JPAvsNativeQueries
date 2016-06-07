package pl.stalostech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.stalostech.jpavsnative.Operations;
import pl.stalostech.jpavsnative.jdbctemplate.Helper;

@Configuration
@EnableAutoConfiguration
@ComponentScan("pl.stalostech.*")
public class ApplicationJPA implements CommandLineRunner {

	@Autowired
	@Qualifier("jpa")
	private Operations operations;

	@Autowired
	private Helper helper;

	public static void main(String args[]) {
		SpringApplication.run(ApplicationJPA.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		helper.clearDB(); // clear all tables

		// postgres results : 1460+1759+1921+1443+1518 = 1620
		// postgres results + allocation size = 1000 + increment sequence = 1000
		// : 507+503+527+506+543 = 517
		operations.createBatch();

		helper.prepareTestData();

		// postgres results (subselects) - default : 582+342+392+311+313 = 388
		// postgres results (inner joins) : 116+113+114+136+111 = 118
		// postgres results (jpql) : 127+108+118+119+124 = 119
		operations.readWithJoins();
		
		// postgres results : 101+92+93+105+64 = 91
		operations.readWithStoredProcedure();

	}
}