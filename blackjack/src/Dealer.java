
public class Dealer extends Player {
    public Dealer() {
        super();
        playerID = 0;
    }

    @Override
    public void getBets() {
        // dealer does not place bets
        System.out.println("Dealer does not place bets");
    }


}
