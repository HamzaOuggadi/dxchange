package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.entities.UserReview;
import gg.astrub.astrub.exceptions.ReviewException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.UserRepository;
import gg.astrub.astrub.repositories.UserReviewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* NBA : Need to add limitations of how many reviews can be left by one single user for each review to prevent Spam reviews */
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserReviewServiceImpl implements UserReviewService{
    private UserReviewRepository userReviewRepository;
    private UserRepository userRepository;
    @Override
    public List<UserReview> userReviews() {
        return userReviewRepository.findAll();
    }

    @Override
    public UserReview getUserReviewById(Long userReviewId) throws ReviewException {
        UserReview userReview = userReviewRepository.findById(userReviewId).orElseThrow(()-> new ReviewException("Review Not Found !"));
        if (userReview.isRemoved()) {
            throw new ReviewException("Review Already Removed !");
        } else {
            return userReview;
        }
    }

    @Override
    public List<UserReview> getUserReviewsByUserId(Long userId) throws UserException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException("User Not Found!"));
        List<UserReview> userReviewsForUser = user.getUserOwnReviews();
//        log.info("------------LOG START-------------");
//        System.out.println(userReviewsForUser.size());
//        log.info("------------LOG END---------------");
        for (int i=0;i<userReviewsForUser.size(); i++) {
            if (userReviewsForUser.get(i).isRemoved()) {
                userReviewsForUser.remove(i);
            }
        }
//        log.info("------------LOG START After for Loop-------------");
//        System.out.println(userReviewsForUser.size());
//        log.info("------------LOG END---------------");
        return userReviewsForUser;
    }

    @Override
    public void addUserReview(UserReview userReview, Long userReviewedId, Long userReviewOwnerId) throws UserException {
        User userReviewed = userRepository.findById(userReviewedId).orElseThrow(()-> new UserException("User Not Found!"));
        User userReviewOwner = userRepository.findById(userReviewOwnerId).orElseThrow(()-> new UserException("User Not Found!"));
        UserReview newUserReview = UserReview.builder()
                .reviewedUser(userReviewed)
                .reviewTitle(userReview.getReviewTitle())
                .reviewContent(userReview.getReviewContent())
                .reviewStar(userReview.getReviewStar())
                .reviewOwnerUser(userReviewOwner)
                .isRemoved(false)
                .build();
        userReviewRepository.save(newUserReview);
    }

    @Override
    public void removeUserReviewById(Long userReviewId) throws ReviewException {
        UserReview userReview = userReviewRepository.findById(userReviewId).orElseThrow(()-> new ReviewException("Review Not Found!"));
        userReview.setRemoved(true);
        userReviewRepository.save(userReview);
    }
}
