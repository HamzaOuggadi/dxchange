package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.UserReview;
import gg.astrub.astrub.exceptions.ReviewException;
import gg.astrub.astrub.exceptions.UserException;

import java.util.List;

public interface UserReviewService {
    List<UserReview> userReviews();
    UserReview getUserReviewById(Long userReviewId) throws ReviewException;
    List<UserReview> getUserReviewsByUserId(Long userId) throws UserException;
    void addUserReview(UserReview userReview, Long userReviewedId, Long userReviewOwner) throws UserException;
    void removeUserReviewById(Long userReviewId) throws ReviewException;
}
