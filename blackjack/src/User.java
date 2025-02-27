import javax.swing.JOptionPane;

public class User extends Player{
    public User() {
        super();
        playerID = 1;
    }

    @Override
    public void placeBet(){
    String input = JOptionPane.showInputDialog(null, "Enter your bet amount:", 
                                                "Place Your Bet", JOptionPane.QUESTION_MESSAGE);

    if (input != null) {
        try {
            int betamount = Integer.parseInt(input);
            if (betamount > balance) {
                JOptionPane.showMessageDialog(null, "Insufficient funds! Please enter a valid bet.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (betamount <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid bet amount! Please enter a positive number.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                placeBet();
            } else {
                bet = betamount;
                JOptionPane.showMessageDialog(null, "You placed a bet of $" + bet, 
                                            "Bet Confirmed", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
            placeBet();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
        placeBet();
    }
}



}
