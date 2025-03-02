import java.util.Random;

public class NormalBot extends Player{
    Random random = new Random();
    String name = "NormalBot";

    public NormalBot(){
        super();
        playerID = 2;
    }

    @Override
    public void placeBet(){
        bet = random.nextInt(balance);
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue < 21){
            int randomNumberInRange = random.nextInt(2);
            if(randomNumberInRange == 0){
                hit();
            } else {
                stand();
            }
        }
    }
}
