

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        List<Player> players = new ArrayList<>();

        System.out.print("Enter number of players: ");
        int numPlayers = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // Deal 2 cards to each player
        for (Player player : players) {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }

        // Show hands
        for (Player player : players) {
            player.printHand();
        }

        // Determine winner
        Player winner = null;
        int highest = 0;

        for (Player player : players) {
            int score = player.getScore();
            if (score <= 21 && score > highest) {
                highest = score;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("🏆 The winner is " + winner.getName() + " with " + highest + " points!");
        } else {
            System.out.println("Nobody wins. All players busted!");
        }
    }
}
