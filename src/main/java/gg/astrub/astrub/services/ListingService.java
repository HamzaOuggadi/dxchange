package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.UserException;

import java.util.List;

public interface ListingService {
    List<Listing> listAllListing() throws ListingException;
    List<ListingAccount> listAccountListing() throws ListingException;
    List<ListingCurrency> listCurrencyListing() throws ListingException;
    Listing getListingById(Long listingId) throws ListingException;
    List<Listing> getListingByUserId(Long userId) throws UserException;
    ListingCurrency addListingCurrency(ListingCurrency listingCurrency, Long userId) throws ListingException, UserException;
    ListingAccount addListingAccount(ListingAccount listingAccount, Long userId) throws ListingException, UserException;
    ListingCurrency editListingCurrency(ListingCurrency listingCurrency) throws ListingException;
    ListingAccount editListingAccount(ListingAccount listingAccount) throws ListingException;
    void deleteListingById(Long listingId) throws ListingException;
}
