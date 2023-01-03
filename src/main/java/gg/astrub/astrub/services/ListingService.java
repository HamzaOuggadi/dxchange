package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;

import java.util.List;

public interface ListingService {
    List<Listing> listListing();
    Listing getListingById(Long listingId);
    Listing addListing(Listing listing);
    Listing editListing(Listing listing);
    void deleteListingById(Long listingId);
}
