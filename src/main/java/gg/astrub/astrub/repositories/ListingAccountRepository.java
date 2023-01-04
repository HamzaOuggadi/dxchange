package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.ListingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ListingAccountRepository extends JpaRepository<ListingAccount, Long> {
}
