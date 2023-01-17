package gg.astrub.astrub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private byte reviewStar;
    private String reviewContent;
    private boolean isRemoved;
    @ManyToOne
    private User reviewedUser;
    @ManyToOne
    private User reviewOwnerUser;
}
