package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.ListingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Need to test every endpoint before Spring Security and Authentication */
@RestController
@AllArgsConstructor
public class ListingController {
    private ListingServiceImpl listingService;

    @GetMapping("/listings") /* Tested => OK */
    public List<Listing> getAllListings() throws ListingException {
        return listingService.listAllListing();
    }
    @GetMapping("/listings/accountListings") /* Tested => OK */
    public List<ListingAccount> getAccountListings() throws ListingException {
        return listingService.listAccountListing();
    }
    @GetMapping("/listings/currencyListings") /* Tested => OK */
    public List<ListingCurrency> getCurrencyListings() throws ListingException {
        return listingService.listCurrencyListing();
    }
    @GetMapping("/listings/{listingId}") /* Tested => OK */
    public ResponseEntity<Listing> getListingById(@PathVariable Long listingId) throws ListingException {
        return ResponseEntity.ok(listingService.getListingById(listingId));
    }
    @GetMapping("/listings/listingsByUserId/{userId}") /* Tested => OK */
    public List<Listing> getListingByUserId(@PathVariable Long userId) throws UserException {
        return listingService.getListingByUserId(userId);
    }
    @PostMapping("/listings/addAccountListing/{userId}") /* Tested => OK */
    public void addAccountListing(@RequestBody ListingAccount listingAccount,
                                  @PathVariable Long userId) throws ListingException, UserException {
        listingService.addListingAccount(listingAccount, userId);
    }
    @PostMapping("/listings/addCurrencyListing/{userId}") /* Tested => OK */
    public void addCurrencyListing(@RequestBody ListingCurrency listingCurrency,
                                   @PathVariable Long userId) throws ListingException, UserException {
        listingService.addListingCurrency(listingCurrency, userId);
    }
    @PutMapping("/listings/editAccountListing") /* Tested => OK */
    public void editAccountListing(@RequestBody ListingAccount listingAccount) throws ListingException {
        listingService.editListingAccount(listingAccount);
    }
    @PutMapping("/listings/editCurrencyListing") /* Tested => OK */
    public void editCurrencyListing(@RequestBody ListingCurrency listingCurrency) throws ListingException {
        listingService.editListingCurrency(listingCurrency);
    }

    @DeleteMapping("/listings/deleteListing/{listingId}") /* Tested => OK */
    public void deleteListingById(@PathVariable Long listingId) throws ListingException {
        listingService.deleteListingById(listingId);
    }
}
