package gg.astrub.astrub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "WebUser")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Date userCreatedAt;
    private boolean userBanned;
    @OneToMany(mappedBy = "user")
    private List<Listing> listings;
    @OneToMany(mappedBy = "userSender")
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "userRecipient")
    private List<Message> receivedMessages;
    @OneToMany(mappedBy = "reviewedUser")
    private List<UserReview> userOwnReviews;
    @OneToMany(mappedBy = "reviewOwnerUser")
    private List<UserReview> userReviewsLeft;
}
