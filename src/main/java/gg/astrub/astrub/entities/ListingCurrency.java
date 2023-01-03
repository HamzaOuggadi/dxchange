package gg.astrub.astrub.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@DiscriminatorValue("CURRENCY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ListingCurrency extends Listing {
    private Long currencyAmount;
}
