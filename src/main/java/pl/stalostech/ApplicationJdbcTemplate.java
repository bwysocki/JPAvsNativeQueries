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
public class ApplicationJdbcTemplate implements CommandLineRunner {

	@Autowired
	@Qualifier("jdbcTemplateOperations")
	private Operations operations;
	
	@Autowired
	private Helper helper;
	
    public static void main(String args[]) {
        SpringApplication.run(ApplicationJdbcTemplate.class, args);
    }

    
    @Override
    public void run(String... strings) throws Exception {
    	
    	helper.clearDB(); // clear all tables
    	
    	operations.createBatch(); // postgres results : 1144+1173+1123+1181+1161 = 1156
    	// shared buffers : 1107+1101+1126+1092+1105 = 1106
    	// unlogged table : 1083+1084+1089+1092+1104=1090
    	
    	helper.prepareTestData();
    	
    	operations.readWithJoins(); // postgres results : 81+87+104+78+79 = 85
    	// shared buffers : 78+77+77+80+84 = 79
    	
    	operations.readWithStoredProcedure(); // postgres results : 68+68+67+67+73 = 68
    	// shared buffers : 66+64+57+68+73 = 65
    	
    }
}