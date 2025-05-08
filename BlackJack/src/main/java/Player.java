import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank().equals("A")) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10; //  11 → 1
            aces--;
        }

        return total;
    }

    public void printHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println("  " + card);
        }
        System.out.println("Score: " + getScore());
        System.out.println();
    }
}
