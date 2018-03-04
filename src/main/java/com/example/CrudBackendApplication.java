package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.User;
import com.example.repository.UserRepository;

//@SpringBootApplication
//public class CrudBackendApplication implements CommandLineRunner {
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(CrudBackendApplication.class, args);
//	}
//	
//	@Override
//	public void run(String... args) throws Exception{
//		userRepository.save(new User("aaa", "111"));
//		userRepository.save(new User("bbb", "222"));
//		userRepository.save(new User("ccc", "333"));
//	}
//}


@SpringBootApplication
public class CrudBackendApplication extends SpringBootServletInitializer {
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CrudBackendApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);

	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
			userRepository.save(new User("aaa", "111"));
			userRepository.save(new User("bbb", "222"));
			userRepository.save(new User("ccc", "333"));
	      };
	 }

	
}
