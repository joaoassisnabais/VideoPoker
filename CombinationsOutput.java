/**
 * Contains the name of the combination, the interest card and the payment table of the combination
 * @param Combo name of the combination
 * @param interestCard interest card for special cases in some combinations
 * @param payTableIndex credits to pay the player according to the bet
 */
public record CombinationsOutput(String Combo, int interestCard, int payTableIndex) {
}
