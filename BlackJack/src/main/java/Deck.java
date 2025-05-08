import java.util.*;

public class Deck {
    private final List<Card> cards = new ArrayList<>();
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private final String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    public Deck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.remove(0);
    }
}
