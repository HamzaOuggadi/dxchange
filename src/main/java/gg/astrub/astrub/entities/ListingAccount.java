package gg.astrub.astrub.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("ACCOUNT")
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
