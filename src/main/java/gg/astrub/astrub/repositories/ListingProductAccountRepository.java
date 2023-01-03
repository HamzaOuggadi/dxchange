package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.ListingProductAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ListingProductAccountRepository extends JpaRepository<ListingProductAccount, Long> {
}
