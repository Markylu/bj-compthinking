
public class blackjackGame {
    Player[] players;
    int pot;

    public blackjackGame() {

    }

    public void initializeGame() {
        // initialize game
        System.out.println("Initializing game");
        players = new Player[2];
        players[0] = new Dealer();
        players[1] = new User();
        pot = 0;
    }
    
    public void getBets() {
        for (Player player : players) {
            player.placeBet();
        }
    }

    public void dealCards(){
        for (Player player : players) {
            player.drawCard();
            player.drawCard();
        }
    }

    public int getPot(){
        for (Player player : players) {
            pot += player.bet;
        }
        return pot;
    }

    public void hitOrStand() {
        for (Player player : players) {
            if (!(player instanceof Dealer)) {
                player.makeDecision();
            }
        }
    }

}
