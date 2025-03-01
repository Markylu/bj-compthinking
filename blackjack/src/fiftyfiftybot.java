import java.util.Random;
public class fiftyfiftybot extends Player {
    Random random = new Random();
    int randomNumberInRange = random.nextInt(0, 1);
    calculateHandValue();
    for (handValue<21) {
    if(randomNumberInRange == 0){
        hit();
    }
    else(randomNumberInRange == 1){
        stand();
    }
}
}
