package gg.astrub.astrub.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListingAccount {
    private String characterClass;
    private int characterLevel;
    private String characterProfession;
    private int characterProfessionLevel;
    private Long characterCurrencyAmount;
}
