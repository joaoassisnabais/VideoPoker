package Cards;

/**
 * Prints the hands of cards
 * <p>Created in order to be able to change the GUI if need be without altering the hand
 */
public class HandPrinter {

    /**
     * Prints the value and suit of all the cards in the hand
     * @param hand hand to print
     */
    public void PrintHand(Hand hand) {
        String cardSuit="";
        String cardValue="";
        StringBuilder str= new StringBuilder();

        for (int i=0; i<5; i++) {
            switch (hand.get(i).suit()) {
                case H -> cardSuit = "H";
                case D -> cardSuit = "D";
                case S -> cardSuit = "S";
                case C -> cardSuit = "C";
            }
            //Verification of values and conversion to integers
            switch (hand.get(i).value()) {
                case 2, 3, 4, 5, 6, 7, 8, 9 -> cardValue = Integer.toString(hand.get(i).value());
                case 10 -> cardValue = "T";
                case 11 -> cardValue = "J";
                case 12 -> cardValue = "Q";
                case 13 -> cardValue = "K";
                case 14 -> cardValue = "A";
            }

            str.append(cardValue).append(cardSuit).append(" ");
        }
        System.out.println("Player's hand is " + str);
    }
}
