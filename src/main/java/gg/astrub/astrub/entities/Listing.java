package gg.astrub.astrub.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import gg.astrub.astrub.enums.ListingType;
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
    protected Long listingId;
    protected String listingTitle;
    protected String listingDescription;
    protected double listingPrice;
    protected Date listingPublishDate;
    protected String listingGameServer;
    protected String listingCharacterName;
    protected boolean isdDeleted;
    protected ListingType listingType;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected User user;
    @OneToMany(mappedBy = "listing")
    protected List<Message> messages;
}
