import java.util.Random;
public class FiftyFiftyBot extends Player {
    Random random = new Random();

    public FiftyFiftyBot(){
        super();
        playerID = 2;
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
            // hit();
            System.out.println("FiftyFiftyBot hits");
        }
        else{
            // stand();
            System.out.println("FiftyFiftyBot stands");
        }
}
    }

}
