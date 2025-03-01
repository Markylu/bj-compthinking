import java.util.Random;
public class Fiftyfiftybot extends Player {
    Random random = new Random();

    public Fiftyfiftybot(){
        super();
        playerID = 2;
    }

    @Override
    public void placeBet(){
        int betamount = random.nextInt(0,100);
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue<21){
        int randomNumberInRange = random.nextInt(0, 1);
        if(randomNumberInRange == 0){
            hit();
        }
        else{
            stand();
        }
}
    }

}
