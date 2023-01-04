package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.ListingCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ListingCurrencyRepository extends JpaRepository<ListingCurrency, Long> {
}
