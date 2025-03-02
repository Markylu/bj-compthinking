
import java.util.Random;
public class NormalBot extends Player{
    Random random = new Random();

    public NormalBot(){
        super();
        this.name = "NormalBot";
        playerID = 2;
    }

    @Override
    public void placeBet(){
        if (balance < 50){
            bet = balance;
        }
        else{
        bet = 2*balance/10;
    }
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
    if (handValue < 21){
        int randomNumberInRange = random.nextInt(2);
        if(randomNumberInRange == 0){
            hit();
            System.out.println("NormalBot hits");
        } else {
            stand();
            System.out.println("NormalBot stands");
            }
        }
    }
}


