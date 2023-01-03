package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.ListingProductCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ListingProductCurrencyRepository extends JpaRepository<ListingProductCurrency, Long> {
}
