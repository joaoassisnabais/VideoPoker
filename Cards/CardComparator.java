package Cards;

import java.util.Comparator;

/**
 * Compares two cards
 */
public class CardComparator implements Comparator<Card> {

    /**
     * Compares the value of two cards
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return comparison
     */
    @Override
    public int compare(Card o1, Card o2) {

        return Integer.compare(o1.value(), o2.value());
    }
}
