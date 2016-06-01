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
public class ApplicationNative implements CommandLineRunner {

	@Autowired
	@Qualifier("crudNative")
	private CRUD nativeCrud;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationNative.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {

    	nativeCrud.createBatch();
    	
    }
}