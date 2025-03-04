
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
        // hand is the list of cards in the player's hand
        hand = new ArrayList<>();
        handValue = 0;
        balance = 1000;
        // status is what is displayed under the player's name
        status = "playing";
    }

    // draws a card from the deck and adds it to the player's hand
    public void drawCard(){
        if (bet != 0){
            Card card = Deck.draw();
            hand.add(card);
            if (card.value.equals("A")) {
                aceCount++;
            }
            Deck.cardsInPlay.add(card);
            calculateHandValue();
        }
    }

    // calculates the value of the player's hand
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

    // forces bet implementation
    public abstract void placeBet();
    
    // forces decision implementation
    public abstract void makeDecision();

    //allows for player to update table UI
    public void getTable(Table table) {
        this.table = table;
    }

    // player hits
    public void hit() {
        drawCard();
        table.repaint();
        System.out.println("Player " + name + " hits");
    }
    // player stands
    public void stand() {
        System.out.println("Player " + name + " stands");
    }
 
    // player's bet returns
    public int getBet() {
        System.out.println("Player " + name + " bets " + bet);
        return bet;
    }

    // player wins
    public void winBet() {
        balance += bet;
        System.out.println("Player " + name + " wins " + bet);
        bet = 0;
    }
    // player loses
    public void loseBet() {
        balance -= bet;
        System.out.println("Player " + name + " loses " + bet);
        bet = 0;
    }
    // player wins blackjack
    public void blackjack() {
        balance += bet * 1.5;
        System.out.println("Player " + name + " wins blackjack " + bet * 1.5);
        bet = 0;
    }
    // player busts
    public void bust() {
        System.out.println("Player " + name + " busts");
        loseBet();
        bet = 0;
    }
    // player pushes and draws
    public void push() {
        System.out.println("Player " + name + " pushes");
        bet = 0;
    }

    // player resets for the round
    public void reset() {
        hand.clear();
        handValue = 0;
        aceCount = 0;
        bet = 0;
        status = "playing";
        System.out.println("Player " + name + " resets");
    }

}
