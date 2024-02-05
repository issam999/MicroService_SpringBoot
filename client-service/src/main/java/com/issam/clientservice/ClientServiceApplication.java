package com.issam.clientservice;

import com.issam.clientservice.entities.customer;
import com.issam.clientservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){

		return args->{
			List<customer> customerList=List.of(
			customer.builder()
					.firstName("Issam")
					.lastName("Barhoumi")
					.email("issambar73@gmail.com")


					.build(),

			customer.builder()
					.firstName("houssine")
					.lastName("Barhoumi")
					.email("houssineBar@gmail.com")


					.build()
			);
			customerRepository.saveAll(customerList);
		};
	}

}
