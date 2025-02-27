
public class blackjackGame {
    Player[] players;

    public blackjackGame() {

    }

    public void initializeGame() {
        // initialize game
        System.out.println("Initializing game");
        players = new Player[2];
        players[0] = new Dealer();
        players[1] = new User();
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

}
