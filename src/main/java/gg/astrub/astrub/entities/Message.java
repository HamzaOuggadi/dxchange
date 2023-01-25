package gg.astrub.astrub.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private String messageContent;
    private Date messageDate;
    private boolean messageViewed;
    private boolean messageDeleted;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User userRecipient;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User userSender;
    @ManyToOne
    private Listing listing;
}
