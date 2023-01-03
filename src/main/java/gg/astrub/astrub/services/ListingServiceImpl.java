package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
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
    public List<Listing> listListing() {
        return null;
    }

    @Override
    public Listing getListingById(Long listingId) {
        return null;
    }

    @Override
    public Listing addListing(Listing listing) {
        return null;
    }

    @Override
    public Listing editListing(Listing listing) {
        return null;
    }

    @Override
    public void deleteListingById(Long listingId) {

    }
}
