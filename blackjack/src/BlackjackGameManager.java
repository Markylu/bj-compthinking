


public class BlackjackGameManager {

    public BlackjackGameManager() {
        blackjackGame game = new blackjackGame();
        game.initializeGame();
        Table table = new Table(game);
        game.tableToPlayers(table);
        App.window.add(table);
        App.window.setResizable(false);
        App.window.pack();
        App.window.setLocationRelativeTo(null);
        App.window.setVisible(true); 
        App.window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Deck.newDeck();
        Deck.shuffle();
        do { 
            System.out.println("Round started");
            System.out.println("Deck size: " + Deck.deck.size());
            game.resetGame();
            table.repaint();
            game.getBets();
            table.repaint();
            game.dealCards();
            table.repaint();
            game.hitOrStand();
            table.repaint();
            game.checkBlackjack();
            table.repaint();
            game.dealerTurn();
            table.repaint();
            game.checkWinners();
            table.repaint();
        } while (game.playAgain() || Deck.deck.size() >= 15);
        App.window.remove(table);
    }

    

}
