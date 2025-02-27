
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
        balance = 1000;
    }

    public void drawCard(){
        Card card = Deck.draw();
        hand.add(card);
        if (card.value.equals("A")) {
            aceCount++;
        }
        calculateHandValue();
    }

    public void calculateHandValue() {
        handValue = 0;
        for (Card card : hand) {
            if (Card.getCardValue(card) == 1  && handValue + 11 <= 21) {
                handValue += 11;
            } else {
                handValue += Card.getCardValue(card);
            }
        }
    }


    public abstract void placeBet();

    public abstract void makeDecision();

    public void hit() {
        drawCard();
    }
    public void stand() {
        // do nothing
    }
 

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
        bet = 0;
    }

}
