import java.util.Random;
public class FiftyFiftyBot extends Player {

    Random random = new Random();
    //Random object declaration
    public FiftyFiftyBot(){
        super();
        this.name = "FiftyFiftyBot";
        playerID = 2;
    }

    @Override
    public void placeBet(){
        //places the bet
        bet = random.nextInt(0,balance);
        //generates a random value for the bet amount
        status = "Bet Amount: " + bet;
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
        if (handValue<21){
            //will only make hit or stand if the bot does not have black jack yet
        int randomNumberInRange = random.nextInt(0, 2);
        //generates either 0 or 1
        if(randomNumberInRange == 0){
        //If 0 it hits, if 1 it stands
            hit();
        }
        else{
            stand();
        }
}
    }

}
