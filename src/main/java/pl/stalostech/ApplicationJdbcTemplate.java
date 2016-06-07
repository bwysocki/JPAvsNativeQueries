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
public class ApplicationJdbcTemplate implements CommandLineRunner {

	@Autowired
	@Qualifier("crudJdbcTemplate")
	private CRUD nativeCrud;
	
	@Autowired
	private Helper helper;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJdbcTemplate.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {
    	
    	helper.clearDB(); // clear all tables
    	
    	nativeCrud.createBatch(); // postgres results : 1144+1173+1123+1181+1161 = 1156
    	
    	helper.prepareTestData();
    	
    	nativeCrud.readWithJoins(); // postgres results : 81+87+104+78+79 = 85
    	
    }
}