
public class blackjackGame {
    Player[] players;
    int pot;

    public blackjackGame() {
        
    }

    
    public void initializeGame() {
        // initialize game
        System.out.println("Initializing game");
        players = new Player[3];
        players[0] = new Dealer();
        players[1] = new User();
        players[2] = new Fiftyfiftybot();
        pot = 0;
    }

    public void tableToPlayers(Table table) {
        for (Player player : players) {
            player.getTable(table);
        }
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
                if (player != null) {
                    player.makeDecision();
                }
            }
        }
    }

    public void dealerTurn(){
        boolean hasPlayer = false;
        for (int i = 1; i < players.length && hasPlayer == false; i++){
            players[i].calculateHandValue();
			if (players[i].getBet() > 0 && players[i].handValue <= 21 ) {
				hasPlayer = true;
			}
		}
		if (hasPlayer == true) {
			players[0].makeDecision();
		}
    }

    public void checkBlackjack() {
        for (Player player : players) {
            player.calculateHandValue();
            if (player.handValue == 21 && player.bet > 0) {
                player.blackjack();
            }
        }
    }

}
