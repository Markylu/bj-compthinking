import javax.swing.JOptionPane;

public class blackjackGame {
    Player[] players;

    public blackjackGame() {
        
    }

    
    public void initializeGame() {
        // initialize game
        System.out.println("Initializing game");
        players = new Player[5];
        players[0] = new Dealer();
        players[1] = new User();
        players[2] = new FiftyFiftyBot();
        players[3] = new NormalBot();
        players[4] = new HardBot();
    }

    public void tableToPlayers(Table table) {
        for (Player player : players) {
            player.getTable(table);
        }
    }
    
    public void getBets() {
        for (Player player : players) {
            player.placeBet();
            System.out.println("Player " + player.name + " bet: " + player.bet);
        }
    }

    public void dealCards(){
        for (Player player : players) {
            player.drawCard();
            player.drawCard();
        }
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

    public void checkWinners(){
        for (int i = 1; i < players.length; i++) {
            if (players[i].getBet() > 0) {
                players[i].calculateHandValue();
                players[0].calculateHandValue();
                if (players[i].handValue > 21) {
                    players[i].bust();
                    players[i].status = "Bust";
                } else if (players[i].handValue == 21){
                    players[i].blackjack();
                    players[i].status = "Blackjack";
                }else if (players[0].handValue > 21) {
                    players[i].winBet();
                    players[i].status = "Dealer Bust";
                } else if (players[i].handValue > players[0].handValue) {
                    players[i].winBet();
                    players[i].status = "Win";
                } else if (players[i].handValue < players[0].handValue) {
                    players[i].loseBet();
                    players[i].status = "Lose";
                } else {
                    players[i].push();
                    players[i].status = "Push/Tie";
                }
            }
        }
    }

    public boolean playAgain() {
        if (players[1].balance <= 0 || Deck.deck.size() < 10) {
            JOptionPane.showMessageDialog(null, "Game Over");
            return false;
        } else {
        int response = JOptionPane.showConfirmDialog(
            null, 
            "Continue to next round?", 
            "Next Round", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
        );
        return response == JOptionPane.YES_OPTION;
        }
    }
    public void resetGame() {
        for (Player player : players) {
            player.reset();
        }
    }
}
