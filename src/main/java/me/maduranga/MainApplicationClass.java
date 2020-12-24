package me.maduranga;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
//@ComponentScan("com.maduranga.Blog")
//@EnableAutoConfiguration
//@EnableJpaRepositories
@SpringBootApplication
@EntityScan("com.maduranga")
public class MainApplicationClass {

	public static void main(String[] args) {
        SpringApplication.run(MainApplicationClass.class, args);
    }
	
}
