package pl.stalostech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.stalostech.jpavsnative.CRUD;

@Configuration 
@EnableAutoConfiguration 
@ComponentScan("pl.stalostech.*")
public class ApplicationJPA implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJpa")
	private CRUD jpaCrud;
		
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJPA.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {

    	jpaCrud.createBatch();
    	
    }
}