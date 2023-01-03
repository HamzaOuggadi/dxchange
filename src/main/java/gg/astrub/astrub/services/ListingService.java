package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;

import java.util.List;

public interface ListingService {
    List<Listing> listListing() throws ListingException;
    Listing getListingById(Long listingId) throws ListingException;
    ListingCurrency addListingCurrency(ListingCurrency listingCurrency);
    ListingAccount addListingAccount(ListingAccount listingAccount);
    Listing editListing(Listing listing);
    void deleteListingById(Long listingId);
}
