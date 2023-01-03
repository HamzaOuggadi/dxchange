package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.repositories.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ListingServiceImpl implements ListingService{
    private ListingRepository listingRepository;

    @Override
    public List<Listing> listListing() throws ListingException {
        try {
            return listingRepository.findAll();
        } catch (Exception e) {
            throw new ListingException("Listings Not Found!");
        }
    }

    @Override
    public Listing getListingById(Long listingId) throws ListingException {
        return listingRepository.findById(listingId).orElseThrow(()->new ListingException("Listing Not Found With The Given ID"));
    }

    @Override
    public ListingCurrency addListingCurrency(ListingCurrency listingCurrency) {
        ListingCurrency newListingCurrency = new ListingCurrency();
        newListingCurrency.setListingTitle(listingCurrency.getListingTitle());
        newListingCurrency.setListingDescription(listingCurrency.getListingDescription());
        newListingCurrency.setListingPrice(listingCurrency.getListingPrice());
        newListingCurrency.setListingPublishDate(listingCurrency.getListingPublishDate());
        newListingCurrency.setListingGameServer(listingCurrency.getListingGameServer());
        newListingCurrency.setListingCharacterName(listingCurrency.getListingCharacterName());
        newListingCurrency.setCurrencyAmount(listingCurrency.getCurrencyAmount());
        listingRepository.save(newListingCurrency);
        return newListingCurrency;
    }

    @Override
    public ListingAccount addListingAccount(ListingAccount listingAccount) {
        ListingAccount newListingAccount = new ListingAccount();
        newListingAccount.setListingTitle(listingAccount.getListingTitle());
        newListingAccount.setListingDescription(listingAccount.getListingDescription());
        newListingAccount.setListingPrice(listingAccount.getListingPrice());
        newListingAccount.setListingPublishDate(listingAccount.getListingPublishDate());
        newListingAccount.setListingGameServer(listingAccount.getListingGameServer());
        newListingAccount.setListingCharacterName(listingAccount.getListingCharacterName());
        newListingAccount.setCharacterClass(listingAccount.getCharacterClass());
        newListingAccount.setCharacterLevel(listingAccount.getCharacterLevel());
        newListingAccount.setCharacterProfession(listingAccount.getCharacterProfession());
        newListingAccount.setCharacterProfessionLevel(listingAccount.getCharacterProfessionLevel());
        newListingAccount.setCharacterCurrencyAmount(listingAccount.getCharacterCurrencyAmount());
        listingRepository.save(newListingAccount);
        return newListingAccount;
    }

    @Override
    public Listing editListing(Listing listing) {
        return null;
    }

    @Override
    public void deleteListingById(Long listingId) {
        listingRepository.deleteById(listingId);
    }
}
