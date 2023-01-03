package gg.astrub.astrub;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class AstrubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstrubApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserRepository userRepository,
							ListingRepository listingRepository) {
		return args -> {
			Stream.of("Hamza", "Yasmine", "Jacky").forEach(us -> {
				User user = User.builder()
						.userName(us)
						.userEmail(us+"@gmail.com")
						.userPassword("1234")
						.userCreatedAt(new Date())
						.userBanned(false)
						.build();

				userRepository.save(user);
			});

			Stream.of("Vente Kamas", "Vente Compte Cra 200", "Vente 300 Million Ilyzaelle").forEach(list -> {
				Listing listing = Listing.builder()
						.listingTitle(list)
						.listingDescription("Description : " + list)
						.listingPrice(100+(Math.random()*100))
						.listingPublishDate(new Date())
						.listingGameServer("Ilyzaelle")
						.listingCharacterName("XxDarkxX")
						.build();

				listingRepository.save(listing);
			});

			for (int i=1; i<=3; i++) {
				User user = userRepository.findById(Long.valueOf(i)).orElseThrow();
				Listing listing = listingRepository.findById(Long.valueOf(i)).orElseThrow();
				listing.setUser(user);
				listingRepository.save(listing);
			}
		};
	}

}
