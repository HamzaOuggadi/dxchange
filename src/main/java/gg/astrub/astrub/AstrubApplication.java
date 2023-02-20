package gg.astrub.astrub;


import gg.astrub.astrub.entities.*;
import gg.astrub.astrub.enums.ListingType;
import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.MessageRepository;
import gg.astrub.astrub.repositories.UserRepository;
import gg.astrub.astrub.repositories.UserReviewRepository;
import gg.astrub.astrub.services.ListingServiceImpl;
import gg.astrub.astrub.services.UserReviewServiceImpl;
import gg.astrub.astrub.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/* Added new branch "dev-env"*/

@SpringBootApplication
@Slf4j
public class AstrubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstrubApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserRepository userRepository,
							ListingRepository listingRepository,
							ListingServiceImpl listingService,
							UserServiceImpl userService,
							MessageRepository messageRepository,
							UserReviewRepository userReviewRepository,
							UserReviewServiceImpl userReviewService) {
		return args -> {
			User testUser = User.builder()
					.userName("TestUser")
					.userEmail("Testuser@gmail.com")
					.userPassword("1234")
					.userCreatedAt(new Date())
					.userBanned(false)
					.build();
			userService.addUser(testUser);


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
						.listingType(ListingType.CURRENCY_LISTING)
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
						.listingType(ListingType.ACCOUNT_LISTING)
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

			Stream.of("Wash", "Salut", "Hola").forEach(msg-> {
				Message message = Message.builder()
						.messageContent(msg)
						.messageDate(new Date())
						.messageViewed(false)
						.userSender(userRepository.findById(1L).orElseThrow())
						.userRecipient(userRepository.findById(2L).orElseThrow())
						.messageDeleted(false)
						.listing(listingRepository.findById(1L).orElseThrow())
						.build();
				messageRepository.save(message);
			});

			Stream.of("Review Title 1", "Achawa hadchi", "Rojoula").forEach(rvw -> {
				UserReview userReview = UserReview.builder()
						.reviewTitle(rvw)
						.reviewContent("Review Content : " + rvw)
						.reviewStar((byte) 4)
						.isRemoved(false)
						.reviewedUser(userRepository.findById(1L).orElseThrow())
						.reviewOwnerUser(userRepository.findById(2L).orElseThrow())
						.build();
				userReviewRepository.save(userReview);
			});

//			log.info("------------LOG START-------------");
//			List<UserReview> review = userReviewService.getUserReviewsByUserId(1L);
//			log.info("------------LOG END---------------");

//			User user2 = userService.getUserById(3L);
//
//			System.out.println("User2 : " + user2.getUserName() + " " + user2.getUserEmail() + " " + user2.getUserCreatedAt());
//
//			Listing listing = listingService.getListingById(4L);
//
//			System.out.println("Listing 4 : " + listing.getListingTitle() + " " + listing.getListingDescription());
		};
	}

}
