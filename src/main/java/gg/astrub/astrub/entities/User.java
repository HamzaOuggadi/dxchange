package gg.astrub.astrub.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String userProfilePicture;
    private Date userCreatedAt;
    private boolean userBanned;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Listing> listings;
    @OneToMany(mappedBy = "userSender", cascade = CascadeType.REMOVE)
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "userRecipient", cascade = CascadeType.REMOVE)
    private List<Message> receivedMessages;
    @OneToMany(mappedBy = "reviewedUser", cascade = CascadeType.REMOVE) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserReview> userOwnReviews;
    @OneToMany(mappedBy = "reviewOwnerUser", cascade = CascadeType.REMOVE) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UserReview> userReviewsLeft;
}
