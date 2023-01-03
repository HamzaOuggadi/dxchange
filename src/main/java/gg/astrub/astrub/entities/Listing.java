package gg.astrub.astrub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Listing {
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
    @OneToOne(mappedBy = "listing")
    private ListingProductCurrency listingProductCurrency;
    @OneToOne(mappedBy = "listing")
    private ListingProductAccount listingProductAccount;
}
