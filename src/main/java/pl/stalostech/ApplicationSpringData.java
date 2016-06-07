package pl.stalostech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.jpavsnative.jdbctemplate.Helper;

@Configuration
@EnableAutoConfiguration
@ComponentScan("pl.stalostech.*")
public class ApplicationSpringData implements CommandLineRunner {

	@Autowired
	@Qualifier("crudSpringData")
	private CRUD springDataCrud;

	@Autowired
	private Helper helper;

	public static void main(String args[]) {
		SpringApplication.run(ApplicationSpringData.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		helper.clearDB(); // clear all tables

		// postgres results : 1579+1550+1488+1745+1896 = 1651
		springDataCrud.createBatch();

		helper.prepareTestData();

		// postgres results : 120+118+121+119+114 = 118
		springDataCrud.readWithJoins();

	}
}