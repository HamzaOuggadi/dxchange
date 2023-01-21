package gg.astrub.astrub.web;

import gg.astrub.astrub.entities.UserReview;
import gg.astrub.astrub.exceptions.ReviewException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.UserReviewServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Need to test every endpoint before Spring Security and Authentication */

@RestController
@AllArgsConstructor
public class ReviewService {
    private UserReviewServiceImpl reviewService;
    @GetMapping("/reviews")
    public List<UserReview> getAllReviews() {
        return reviewService.userReviews();
    }
    @GetMapping("/reviews/{reviewId}")
    public UserReview getReviewsById(@PathVariable Long reviewId) throws ReviewException {
        return reviewService.getUserReviewById(reviewId);
    }
    @GetMapping("/reviews/byUserId/{userId}")
    public List<UserReview> getReviewsByUserId(@PathVariable Long userId) throws UserException {
        return reviewService.getUserReviewsByUserId(userId);
    }
    @PostMapping("/reviews/addReview/{userReviewedId}/{userReviewOwnerId}")
    public void addReview(@RequestBody UserReview userReview,
                          @PathVariable Long userReviewedId,
                          @PathVariable Long userReviewOwnerId) throws UserException {
        reviewService.addUserReview(userReview, userReviewedId, userReviewOwnerId);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public void removeReview(@PathVariable Long reviewId) throws ReviewException {
        reviewService.removeUserReviewById(reviewId);
    }
}
