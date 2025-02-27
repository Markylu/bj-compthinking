
import java.util.ArrayList;


public abstract class Player {
    ArrayList<Card> hand;
    int handValue;
    int aceCount;
    int playerID;
    int balance;
    int bet;

    public Player() {
        hand = new ArrayList<>();
        handValue = 0;
        aceCount = 0;
        balance = 1000;
    }

    public void drawCard(){
        Card card = Deck.draw();
        hand.add(card);
        if (card.value.equals("A")) {
            aceCount++;
        }
        handValue += Card.getCardValue(card);
    }

    public abstract void placeBet();

    public int getBet() {
        return bet;
    }

    public void winBet() {
        balance += bet;
        System.out.println("Player " + playerID + " wins " + bet);
    }
    public void loseBet() {
        balance -= bet;
        System.out.println("Player " + playerID + " loses " + bet);
    }

    public void blackjack() {
        balance += bet * 1.5;
        System.out.println("Player " + playerID + " wins blackjack " + bet * 1.5);
    }

}
