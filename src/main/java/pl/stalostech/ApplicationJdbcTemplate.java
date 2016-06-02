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
public class ApplicationJdbcTemplate implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJdbcTemplate")
	private CRUD nativeCrud;
	
	@Autowired
	private CarFactory carFactory;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJdbcTemplate.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {

    	nativeCrud.createBatch(); //557ms
    	
    	carFactory.prepareData(); //preapare test data
    	
    	nativeCrud.readWithJoins();
    	
    }
}