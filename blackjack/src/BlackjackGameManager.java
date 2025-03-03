
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
        do { 
            System.out.println("Round started");
            game.resetGame();
            Deck.newDeck();
            Deck.shuffle();
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
        } while (game.playAgain());
        System.exit(0);
    }

    

}
