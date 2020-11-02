package com.example.bakery;

import com.example.bakery.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BakeryApplication {
	@Autowired
	private BreadRepository breadRepository;

	@Autowired
	private TypeRepository typeRepository;

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Add Type objects and save to db
			Type t1 = new Type("Ruis");
			Type t2 = new Type("Kaura");
			Type t3 = new Type("Vehna");
			Type t4 = new Type("Gluten-Free");
			typeRepository.save(t1);
			typeRepository.save(t2);
			typeRepository.save(t3);
			typeRepository.save(t4);
			//Add bread object with link to types and save these to db
			Bread bread1 = new  Bread("ruismies","Fazer",1.2, 5,t1);
			breadRepository.save(bread1);

			Bread bread2 = new Bread("Kauratyynyt", "Vaasan", 1.39, 4, t2);
			breadRepository.save(bread2);



		//save demo data to database h2
			//breadRepository.save(new Bread("ruismies","Fazer",1.2, 5));
			//breadRepository.save(new Bread("Kauratyynyt", "Vaasan", 1.39, 4));


			//username: user password: user
			userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			//username:adimin, password:admin
			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG","ADMIN"));


		};
	}
}
