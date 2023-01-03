package gg.astrub.astrub.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("ACCOUNT_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ListingAccount extends Listing{
    private String characterClass;
    private int characterLevel;
    private String characterProfession;
    private int characterProfessionLevel;
    private Long characterCurrencyAmount;
}
