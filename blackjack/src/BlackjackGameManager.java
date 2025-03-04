public class BlackjackGameManager {

    public BlackjackGameManager() {
        // Initialize the game
        blackjackGame game = new blackjackGame();
        game.initializeGame();
        
        // Set up the table
        Table table = new Table(game);
        game.tableToPlayers(table);
        
        // Configure the application window
        App.window.add(table);
        App.window.setResizable(false);
        App.window.pack();
        App.window.setLocationRelativeTo(null);
        App.window.setVisible(true); 
        App.window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Create a new deck and shuffle it
        Deck.newDeck(2);
        Deck.shuffle();
        
        do { 
            // Start a new round
            System.out.println("Round started");
            System.out.println("Deck size: " + Deck.deck.size());
            
            // Reset the game
            game.resetGame();
            table.repaint();
            
            // Get bets from players
            game.getBets();
            table.repaint();
            
            // Deal cards to players
            game.dealCards();
            table.repaint();
            
            // Players make decision
            game.hitOrStand();
            table.repaint();
            
            // Check for blackjack
            game.checkBlackjack();
            table.repaint();
            
            // Dealer makes decision
            game.dealerTurn();
            table.repaint();
            
            // End round logic
            game.checkWinners();
            table.repaint();
        } while (game.playAgain());
        
        // Back to start game window
        App.window.remove(table);
    }
}
