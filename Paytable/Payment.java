package Paytable;

/**
 * Pays the player according to the combination of his hand and the credits bet
 */
public abstract class Payment {
    /**
     * Contains the credits to pay according to the bet
     */
    protected int[] payLine;

    /**
     * Pays the player according to the combination of his hand and the credits bet
     * @param credits numeber of credits that the player bet
     * @return number of credits to pay the player
     */
    public int payOut(int credits) {
        return payLine[credits-1];
    }
}
