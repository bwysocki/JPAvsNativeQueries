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

@Configuration 
@EnableAutoConfiguration 
@ComponentScan("pl.stalostech.*")
public class ApplicationJOOQ implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJooq")
	private CRUD jpaCrud;
		
	@Autowired
	private Clearer clearer;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJOOQ.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {
    	
    	clearer.clearDB(); // clear all tables
		
		// postgres results : 1573+1506+1421+1397+1454 = 1470
    	jpaCrud.createBatch();
    	
    }
}