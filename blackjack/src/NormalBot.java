import java.util.Random;

public class NormalBot extends Player{
    Random random = new Random();

    public NormalBot(){
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
            // hit();
            System.out.println("NormalBot hits");
        }
        else{
            // stand();
            System.out.println("NormalBot stands");
        }
}
    }

}
