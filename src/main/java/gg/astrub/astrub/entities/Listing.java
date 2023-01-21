package gg.astrub.astrub.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", length = 20)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Listing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingId;
    private String listingTitle;
    private String listingDescription;
    private double listingPrice;
    private Date listingPublishDate;
    private String listingGameServer;
    private String listingCharacterName;
    private boolean isdDeleted;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
    @OneToMany(mappedBy = "listing")
    private List<Message> messages;
}
