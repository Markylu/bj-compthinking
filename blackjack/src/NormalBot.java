

public class NormalBot extends Player {


    public NormalBot() {
        super();
        this.name = "NormalBot";
        playerID = 3;
    }

    @Override
    public void placeBet() {
        if (balance < 50) {
            bet = balance;
        } else {
            bet = 2 * balance / 10;
            //places 20% of its money as its bet
        }
        status = "Bet Amount: " + bet; 
    }

    @Override
    public void makeDecision() {
            calculateHandValue();
        if (handValue < 21) {
            if (handValue < 17) {
                //if its hand is less than 17 it will always hit
                hit();
                System.out.println("NormalBot hits");
            } else {
                stand();
                System.out.println("NormalBot stands");
            }
        }
    }
}
