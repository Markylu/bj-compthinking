import javax.swing.JOptionPane;

public class User extends Player{
    
    public User() {
        super();
        this.name = "User";
        playerID = 1;
    }

    // make decision with popup
    @Override
    public void makeDecision() {
        if (bet == 0) {
        } else {
            String[] options = {"Hit", "Stand"};
            int choice;
            do { 
                choice = JOptionPane.showOptionDialog(null, "Your hand value is: " + handValue + "\nDo you want to hit or stand?", 
                                                            "Make a Decision", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                App.window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                if (choice == 0) {
                    hit();
                    calculateHandValue();
                    table.repaint();
                    if (handValue > 21) {
                        JOptionPane.showMessageDialog(null, "You busted! Your hand value is: " + handValue, 
                                                        "Busted", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    if (handValue == 21) {
                        JOptionPane.showMessageDialog(null, "Blackjack! Your hand value is: " + handValue, 
                                                        "Blackjack", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                } else if (choice == 1) {
                    stand();
                    table.repaint();
                }            
            } while (choice == 0 && handValue < 21 && bet != 0);
        }
    }

    // place bet with popup
    @Override
    public void placeBet(){
    String input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                "Place Your Bet", JOptionPane.YES_OPTION);
    App.window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    boolean validBet = false;
    while (!validBet) {
        if (input != null) {
            try {
                int betamount = Integer.parseInt(input);
                if (betamount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds! Please enter a valid bet.", 
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                    input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                        "Place Your Bet", JOptionPane.QUESTION_MESSAGE);
                } else if (betamount < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid bet amount! Please enter a positive number.", 
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                    input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                        "Place Your Bet", JOptionPane.QUESTION_MESSAGE);
                } else {
                    bet = betamount;
                    JOptionPane.showMessageDialog(null, "You placed a bet of $" + bet, 
                                                "Bet Confirmed", JOptionPane.INFORMATION_MESSAGE);
                    status = "Bet Amount: " + bet;
                    validBet = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                    "Place Your Bet", JOptionPane.QUESTION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
            input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                "Place Your Bet", JOptionPane.QUESTION_MESSAGE);
        }
    }
}



}
