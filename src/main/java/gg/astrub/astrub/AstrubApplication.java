package gg.astrub.astrub;

import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AstrubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstrubApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserRepository userRepository,
							ListingRepository listingRepository) {
		return args -> {

		};
	}

}
