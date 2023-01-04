package gg.astrub.astrub;


import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.UserRepository;
import gg.astrub.astrub.services.ListingServiceImpl;
import gg.astrub.astrub.services.UserServiceImpl;
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
							ListingRepository listingRepository,
							ListingServiceImpl listingService,
							UserServiceImpl userService) {
		return args -> {
			Stream.of("Hamza", "Yasmine", "Jessie").forEach(usr -> {
				User user = User.builder()
						.userName(usr)
						.userEmail(usr + "@gmail.com")
						.userPassword("1234")
						.userCreatedAt(new Date())
						.userBanned(false)
						.build();
				userRepository.save(user);
			});

			Stream.of("Vente 100M de Kamas", "Vend 450M Kamas Serveur Nidas", "Vends 200M Kamas sur Ilyzaelle").forEach(lst -> {
				ListingCurrency listingCurrency = ListingCurrency.builder()
						.listingTitle(lst)
						.listingDescription("Description : " + lst)
						.listingPrice(Math.random()*1000)
						.listingPublishDate(new Date())
						.listingGameServer("Ilyzaelle")
						.listingCharacterName("XxDarkxX")
						.currencyAmount(Long.valueOf((long) (1000000+(Math.random()*100000000))))
						.build();
				listingRepository.save(listingCurrency);
			});

			Stream.of("Vend Compte Cra LVL 200", "Vend Sadi Perso Métier Joilo 200", "Vend Perso 199 avec Stuff PVP").forEach(lstAcc -> {
				ListingAccount listingAccount = ListingAccount.builder()
						.listingTitle(lstAcc)
						.listingDescription("Description : " + lstAcc)
						.listingPrice(Math.random()*1000)
						.listingPublishDate(new Date())
						.listingGameServer("Nidas")
						.listingCharacterName("Best-Iop")
						.characterClass("Iop")
						.characterLevel(200)
						.characterProfession("Forgeron")
						.characterProfessionLevel(200)
						.characterCurrencyAmount(100L)
						.build();

				listingRepository.save(listingAccount);
			});

			for (int i=1; i<=3; i++) {
				int y = i +3;
				User user = userRepository.findById(Long.valueOf(i)).orElseThrow();
				Listing listing = listingRepository.findById(Long.valueOf(i)).orElseThrow();
				listing.setUser(user);
				listingRepository.save(listing);

				Listing listing2 = listingRepository.findById(Long.valueOf(y)).orElseThrow();
				listing2.setUser(user);
				listingRepository.save(listing2);
			}
		};
	}

}
