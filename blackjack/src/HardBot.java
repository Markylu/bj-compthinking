import java.util.Random;

public class HardBot extends Player{
    Random random = new Random();
    String name = "HardBot";

    public HardBot(){
        super();
        playerID = 4;
    }

    @Override
    public void placeBet(){
        bet = random.nextInt(0,balance);
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue<21){
        int randomNumberInRange = random.nextInt(0, 2);
        if(randomNumberInRange == 0){
            hit();
        }
        else{
            stand();
        }
}
    }
}
