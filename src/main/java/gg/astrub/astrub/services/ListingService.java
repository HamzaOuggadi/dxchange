package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;

import java.util.List;

public interface ListingService {
    List<Listing> listAllListing() throws ListingException;
    List<ListingAccount> listAccountListing() throws ListingException;
    List<ListingCurrency> listCurrencyListing() throws ListingException;
    Listing getListingById(Long listingId) throws ListingException;
    ListingCurrency addListingCurrency(ListingCurrency listingCurrency) throws ListingException;
    ListingAccount addListingAccount(ListingAccount listingAccount) throws ListingException;
    ListingCurrency editListingCurrency(ListingCurrency listingCurrency) throws ListingException;
    ListingAccount editListingAccount(ListingAccount listingAccount) throws ListingException;
    void deleteListingById(Long listingId);
}
