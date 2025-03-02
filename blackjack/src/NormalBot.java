public class NormalBot extends Player{
<<<<<<< HEAD
=======
    Random random = new Random();
    String name = "NormalBot";

>>>>>>> 797df652b3f0420fd4c941478b820ef02c20e5e8
    public NormalBot(){
        super();
        playerID = 2;
    }

    @Override
    public void placeBet(){
<<<<<<< HEAD
        if (balance < 50){
            bet = balance;
        }
        else{
        bet = 2*balance/10;
    }
=======
        bet = random.nextInt(balance);
>>>>>>> 797df652b3f0420fd4c941478b820ef02c20e5e8
    }

    @Override
    public void makeDecision(){
        calculateHandValue();
<<<<<<< HEAD
        if (handValue<15){
            // hit();
            System.out.println("NormalBot hits");
        }
        else{
            // stand();
            System.out.println("NormalBot stands");
        }
}
=======
        if (handValue < 21){
            int randomNumberInRange = random.nextInt(2);
            if(randomNumberInRange == 0){
                hit();
            } else {
                stand();
            }
        }
    }
>>>>>>> 797df652b3f0420fd4c941478b820ef02c20e5e8
}


