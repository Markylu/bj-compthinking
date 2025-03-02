public class NormalBot extends Player{
    public NormalBot(){
        super();
        playerID = 4;
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
        if (handValue<15){
            // hit();
            System.out.println("NormalBot hits");
        }
        else{
            // stand();
            System.out.println("NormalBot stands");
        }
}
}


