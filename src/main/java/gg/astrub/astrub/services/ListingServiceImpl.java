package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.ListingAccountRepository;
import gg.astrub.astrub.repositories.ListingCurrencyRepository;
import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ListingServiceImpl implements ListingService{
    private ListingRepository listingRepository;
    private ListingAccountRepository listingAccountRepository;
    private ListingCurrencyRepository listingCurrencyRepository;
    private UserRepository userRepository;

    @Override
    public List<Listing> listAllListing() throws ListingException {
        try {
            return listingRepository.findAll();
        } catch (Exception e) {
            throw new ListingException("Listings Not Found!");
        }
    }

    @Override
    public List<ListingAccount> listAccountListing() throws ListingException {
        try {
            return listingAccountRepository.findAll();
        } catch (Exception e){
            throw new ListingException("Listing Not Found!");
        }
    }

    @Override
    public List<ListingCurrency> listCurrencyListing() throws ListingException {
        try {
            return listingCurrencyRepository.findAll();
        } catch (Exception e) {
            throw new ListingException("Listing Not Found!");
        }
    }

    @Override
    public Listing getListingById(Long listingId) throws ListingException {
        return listingRepository.findById(listingId).orElseThrow(()->new ListingException("Listing Not Found With The Given ID"));
    }

    @Override
    public List<Listing> getListingByUserId(Long userId) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        return user.getListings();
    }

    @Override
    public ListingCurrency addListingCurrency(ListingCurrency listingCurrency, Long userId) throws ListingException, UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
            ListingCurrency newListingCurrency = ListingCurrency.builder()
                    .listingTitle(listingCurrency.getListingTitle())
                    .listingDescription(listingCurrency.getListingDescription())
                    .listingPrice(listingCurrency.getListingPrice())
                    .listingPublishDate(new Date())
                    .listingGameServer(listingCurrency.getListingGameServer())
                    .listingCharacterName(listingCurrency.getListingCharacterName())
                    .user(user)
                    .currencyAmount(listingCurrency.getCurrencyAmount())
                    .isdDeleted(false)
                    .build();
            listingRepository.save(newListingCurrency);
            return newListingCurrency;
//        ListingCurrency newListingCurrency = new ListingCurrency();
//        newListingCurrency.setListingTitle(listingCurrency.getListingTitle());
//        newListingCurrency.setListingDescription(listingCurrency.getListingDescription());
//        newListingCurrency.setListingPrice(listingCurrency.getListingPrice());
//        newListingCurrency.setListingPublishDate(listingCurrency.getListingPublishDate());
//        newListingCurrency.setListingGameServer(listingCurrency.getListingGameServer());
//        newListingCurrency.setListingCharacterName(listingCurrency.getListingCharacterName());
//        newListingCurrency.setCurrencyAmount(listingCurrency.getCurrencyAmount());
    }

    @Override
    public ListingAccount addListingAccount(ListingAccount listingAccount, Long userId) throws ListingException, UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        ListingAccount newListingAccount = ListingAccount.builder()
                .listingTitle(listingAccount.getListingTitle())
                .listingDescription(listingAccount.getListingDescription())
                .listingPrice(listingAccount.getListingPrice())
                .listingPublishDate(new Date())
                .listingGameServer(listingAccount.getListingGameServer())
                .listingCharacterName(listingAccount.getListingCharacterName())
                .user(user)
                .isdDeleted(false)
                .characterClass(listingAccount.getCharacterClass())
                .characterLevel(listingAccount.getCharacterLevel())
                .characterProfession(listingAccount.getCharacterProfession())
                .characterProfessionLevel(listingAccount.getCharacterProfessionLevel())
                .characterCurrencyAmount(listingAccount.getCharacterCurrencyAmount())
                .build();
        listingRepository.save(newListingAccount);
        return newListingAccount;

//        ListingAccount newListingAccount = new ListingAccount();
//        newListingAccount.setListingTitle(listingAccount.getListingTitle());
//        newListingAccount.setListingDescription(listingAccount.getListingDescription());
//        newListingAccount.setListingPrice(listingAccount.getListingPrice());
//        newListingAccount.setListingPublishDate(listingAccount.getListingPublishDate());
//        newListingAccount.setListingGameServer(listingAccount.getListingGameServer());
//        newListingAccount.setListingCharacterName(listingAccount.getListingCharacterName());
//        newListingAccount.setCharacterClass(listingAccount.getCharacterClass());
//        newListingAccount.setCharacterLevel(listingAccount.getCharacterLevel());
//        newListingAccount.setCharacterProfession(listingAccount.getCharacterProfession());
//        newListingAccount.setCharacterProfessionLevel(listingAccount.getCharacterProfessionLevel());
//        newListingAccount.setCharacterCurrencyAmount(listingAccount.getCharacterCurrencyAmount());
    }

    @Override
    public ListingCurrency editListingCurrency(ListingCurrency listingCurrency) throws ListingException {
        if (listingRepository.findById(listingCurrency.getListingId()).isEmpty()) {
            throw new ListingException("This Listing Doesn't Exist !");
        } else {
            return listingRepository.save(listingCurrency);
        }
    }
    @Override
    public ListingAccount editListingAccount(ListingAccount listingAccount) throws ListingException {
        if (listingRepository.findById(listingAccount.getListingId()).isEmpty()) {
            throw new ListingException("This Listing Doesn't Exist!");
        } else {
            return listingRepository.save(listingAccount);
        }
    }
    @Override
    public void deleteListingById(Long listingId) throws ListingException {
        Listing listing = listingRepository.findById(listingId).orElseThrow(()-> new ListingException("Listing Not Found!"));
        listing.setIsdDeleted(true);
        listingRepository.save(listing);
    }
}
