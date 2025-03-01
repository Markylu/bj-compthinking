import java.util.Random;

public class HardBot extends Player{
    Random random = new Random();

    public HardBot(){
        super();
        playerID = 3;
    }

    @Override
    public void placeBet(){
        bet = random.nextInt(0,balance);
        System.out.println("HardBot bet: " + bet);
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue<21){
        int randomNumberInRange = random.nextInt(0, 2);
        if(randomNumberInRange == 0){
            // hit();
            System.out.println("HardBot hits");
        }
        else{
            // stand();
            System.out.println("HardBot stands");
        }
}
    }
}
