package gg.astrub.astrub.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ListingProductAccount extends ListingProduct{
    private String characterClass;
    private int characterLevel;
    private String characterProfession;
    private int characterProfessionLevel;
    private Long characterCurrencyAmount;
    @OneToOne
    private Listing listing;
}
