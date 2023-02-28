package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.ListingAccount;
import gg.astrub.astrub.entities.ListingCurrency;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/* Need to test every endpoint before Spring Security and Authentication */
@RestController
@AllArgsConstructor
public class ListingController {
    private ListingService listingService;
    private MessageSource messageSource;

    @GetMapping("/listings") /* Tested => OK */
    public ResponseEntity<List<Listing>> getAllListings() throws ListingException {
        return ResponseEntity.ok(listingService.listAllListing());
    }
    @GetMapping("/listings/accountListings") /* Tested => OK */
    public ResponseEntity<List<ListingAccount>> getAccountListings() throws ListingException {
        return ResponseEntity.ok(listingService.listAccountListing());
    }
    @GetMapping("/listings/currencyListings") /* Tested => OK */
    public ResponseEntity<List<ListingCurrency>> getCurrencyListings() throws ListingException {
        return ResponseEntity.ok(listingService.listCurrencyListing());
    }
    @GetMapping("/listings/{listingId}") /* Tested => OK */
    public ResponseEntity<Listing> getListingById(@PathVariable Long listingId) throws ListingException {
        return ResponseEntity.ok(listingService.getListingById(listingId));
    }
    @GetMapping("/listings/listingsByUserId/{userId}") /* Tested => OK */
    public ResponseEntity<List<Listing>> getListingByUserId(@PathVariable Long userId) throws UserException {
        return ResponseEntity.ok(listingService.getListingByUserId(userId));
    }
    @PostMapping("/listings/addAccountListing/{userId}") /* Tested => OK */
    public ResponseEntity<ListingAccount> addAccountListing(@RequestBody ListingAccount listingAccount,
                                  @PathVariable Long userId) throws ListingException, UserException {
        return ResponseEntity.ok(listingService.addListingAccount(listingAccount, userId));
    }
    @PostMapping("/listings/addCurrencyListing/{userId}") /* Tested => OK */
    public ResponseEntity<ListingCurrency> addCurrencyListing(@RequestBody ListingCurrency listingCurrency,
                                   @PathVariable Long userId) throws ListingException, UserException {
        return ResponseEntity.ok(listingService.addListingCurrency(listingCurrency, userId));
    }
    @PutMapping("/listings/editAccountListing") /* Tested => OK */
    public ResponseEntity<ListingAccount> editAccountListing(@RequestBody ListingAccount listingAccount) throws ListingException {
        return ResponseEntity.ok(listingService.editListingAccount(listingAccount));
    }
    @PutMapping("/listings/editCurrencyListing") /* Tested => OK */
    public ResponseEntity<ListingCurrency> editCurrencyListing(@RequestBody ListingCurrency listingCurrency) throws ListingException {
        return ResponseEntity.ok(listingService.editListingCurrency(listingCurrency));
    }

    @DeleteMapping("/listings/deleteListing/{listingId}") /* Tested => OK */
    public ResponseEntity<String> deleteListingById(@PathVariable Long listingId) throws ListingException {
        listingService.deleteListingById(listingId);
        return ResponseEntity.ok(messageSource.getMessage("listing.deleted", new Object[]{listingId}, Locale.getDefault()));
    }
}
