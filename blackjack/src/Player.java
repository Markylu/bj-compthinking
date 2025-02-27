
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Player {
    ArrayList<Card> hand;
    int handValue;
    int aceCount;
    int playerID;
    int balance;
    int bet;

    public Player() {
        hand = new ArrayList<Card>();
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

    public void placeBet(){
        String input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                   "Place Your Bet", JOptionPane.QUESTION_MESSAGE);

        if (input != null) {
            try {
                int betamount = Integer.parseInt(input);
                if (betamount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds! Please enter a valid bet.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    getBets();
                } else if (betamount <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid bet amount! Please enter a positive number.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    getBets();
                } else {
                    bet = betamount;
                    JOptionPane.showMessageDialog(null, "You placed a bet of $" + bet, 
                                              "Bet Confirmed", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                              "Error", JOptionPane.ERROR_MESSAGE);
                getBets();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            getBets();
        }
        balance -= bet;
        System.out.println("Player balance: " + balance);
    }

}
