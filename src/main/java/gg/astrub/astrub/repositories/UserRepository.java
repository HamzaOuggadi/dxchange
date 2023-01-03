package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepository extends JpaRepository<User, Long> {
}
