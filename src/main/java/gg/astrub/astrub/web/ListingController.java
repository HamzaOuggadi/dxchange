package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.ListingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ListingController {
    private ListingServiceImpl listingService;

    @GetMapping("/listings")
    public List<Listing> getAllListings() throws ListingException {
        return listingService.listAllListing();
    }
    @GetMapping("/listings/accountListings")
    public List<ListingAccount> getAccountListings() throws ListingException {
        return listingService.listAccountListing();
    }
    @GetMapping("/listings/currencyListings")
    public List<ListingCurrency> getCurrencyListings() throws ListingException {
        return listingService.listCurrencyListing();
    }
    @GetMapping("/listings/{listingId}")
    public Listing getListingById(@PathVariable Long listingId) throws ListingException {
        return listingService.getListingById(listingId);
    }
    @GetMapping("/listings/listingsByUserId/{userId}")
    public List<Listing> getListingByUserId(@PathVariable Long userId) throws UserException {
        return listingService.getListingByUserId(userId);
    }
    @PostMapping("/listings/addAccountListing/{userId}")
    public ListingAccount addAccountListing(@RequestBody ListingAccount listingAccount,
                                            @PathVariable Long userId) throws ListingException, UserException {
        return listingService.addListingAccount(listingAccount, userId);
    }
    @PostMapping("/listings/addCurrencyListing/{userId}")
    public ListingCurrency addCurrencyListing(@RequestBody ListingCurrency listingCurrency,
                                              @PathVariable Long userId) throws ListingException, UserException {
        return listingService.addListingCurrency(listingCurrency, userId);
    }
    @PutMapping("/listings/editAccountListing")
    public ListingAccount editAccountListing(@RequestBody ListingAccount listingAccount) throws ListingException {
        return listingService.editListingAccount(listingAccount);
    }
    @PutMapping("/listings/editCurrencyListing")
    public ListingCurrency editCurrencyListing(@RequestBody ListingCurrency listingCurrency) throws ListingException {
        return listingService.editListingCurrency(listingCurrency);
    }

    @DeleteMapping("/listings/deleteListing/{listingId}")
    public void deleteListingById(@PathVariable Long listingId) throws ListingException {
        listingService.deleteListingById(listingId);
    }
}
