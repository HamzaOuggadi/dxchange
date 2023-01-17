package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.entities.UserReview;
import gg.astrub.astrub.exceptions.ReviewException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.UserRepository;
import gg.astrub.astrub.repositories.UserReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class UserReviewServiceImpl implements UserReviewService{
    private UserReviewRepository userReviewRepository;
    private UserRepository userRepository;
    @Override
    public List<UserReview> userReviews() {
        return userReviewRepository.findAll();
    }

    @Override
    public UserReview getUserReviewById(Long userReviewId) throws ReviewException {
        return userReviewRepository.findById(userReviewId).orElseThrow(()-> new ReviewException("Review Not Found!"));
    }

    @Override
    public List<UserReview> getUserReviewsByUserId(Long userId) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));

        return null;
    }
}
