package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
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
    @PostMapping("/listings/addAccountListing")
    public ListingAccount addAccountListing(@RequestBody ListingAccount listingAccount) throws ListingException {
        return listingService.addListingAccount(listingAccount);
    }
    @PostMapping("/listings/addCurrencyListing")
    public ListingCurrency addCurrencyListing(@RequestBody ListingCurrency listingCurrency) throws ListingException {
        return listingService.addListingCurrency(listingCurrency);
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
    public void deleteListingById(@PathVariable Long listingId) {
        listingService.deleteListingById(listingId);
    }
}
