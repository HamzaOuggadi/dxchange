package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ListingRepository extends JpaRepository<Listing, Long> {
}
