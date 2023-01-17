package gg.astrub.astrub.repositories;

import gg.astrub.astrub.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
