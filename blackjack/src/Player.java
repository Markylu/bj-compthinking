
import java.util.ArrayList;


public abstract class Player {
    ArrayList<Card> hand;
    int handValue;
    int aceCount;
    int playerID;
    int balance;
    int bet;
    Table table;
    String name;
    String status;

    public Player() {
        hand = new ArrayList<>();
        handValue = 0;
        balance = 1000;
        status = "playing";
    }

    public void drawCard(){
        Card card = Deck.draw();
        hand.add(card);
        if (card.value.equals("A")) {
            aceCount++;
        }
        Deck.cardsInPlay.add(card);
        calculateHandValue();
    }

    public void calculateHandValue() {
        handValue = 0;
        for (Card card : hand) {
            if (card.suit.equals("A") && handValue + 11 <= 21) {
                handValue += 11;
            } else {
                handValue += Card.getCardValue(card);
            }
        }
    }


    public abstract void placeBet();

    public abstract void makeDecision();

    public void getTable(Table table) {
        this.table = table;
    }

    public void hit() {
        drawCard();
        table.repaint();
        System.out.println("Player " + name + " hits");
    }
    public void stand() {
        System.out.println("Player " + name + " stands");
    }
 

    public int getBet() {
        System.out.println("Player " + name + " bets " + bet);
        return bet;
    }

    public void winBet() {
        balance += bet;
        System.out.println("Player " + name + " wins " + bet);
        bet = 0;
    }
    public void loseBet() {
        balance -= bet;
        System.out.println("Player " + name + " loses " + bet);
        bet = 0;
    }

    public void blackjack() {
        balance += bet * 1.5;
        System.out.println("Player " + name + " wins blackjack " + bet * 1.5);
        bet = 0;
    }
    public void bust() {
        System.out.println("Player " + name + " busts");
        loseBet();
        bet = 0;
    }

    public void push() {
        System.out.println("Player " + name + " pushes");
        bet = 0;
    }

    public void reset() {
        hand.clear();
        handValue = 0;
        aceCount = 0;
        bet = 0;
        status = "playing";
        System.out.println("Player " + name + " resets");
    }

}
