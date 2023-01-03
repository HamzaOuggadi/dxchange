package gg.astrub.astrub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

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
    @ManyToOne
    private User user;
}
