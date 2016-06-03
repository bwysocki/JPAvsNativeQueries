package pl.stalostech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.jpavsnative.jdbctemplate.Clearer;
import pl.stalostech.model.factory.CarFactory;

@Configuration 
@EnableAutoConfiguration 
@ComponentScan("pl.stalostech.*")
public class ApplicationJdbcTemplate implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJdbcTemplate")
	private CRUD nativeCrud;
	
	@Autowired
	private CarFactory carFactory;
	
	@Autowired
	private Clearer clearer;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJdbcTemplate.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {
    	
    	clearer.clearDB(); // clear all tables
    	
    	// postgres results : 1144+1173+1123+1181+1161 = 1156
    	nativeCrud.createBatch();
    	
    	//carFactory.prepareData(); //preapare test data
    	
    	//nativeCrud.readWithJoins();
    	
    }
}