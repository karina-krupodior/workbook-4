import java.util.List;

public class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        if (List.of("J", "Q", "K").contains(rank)) {
            return 10;
        } else if (rank.equals("A")) {
            return 11;
        } else {
            return Integer.parseInt(rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
