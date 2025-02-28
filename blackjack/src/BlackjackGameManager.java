


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
        game.getBets();
        table.repaint();
        Deck.newDeck();
        Deck.shuffle();
        game.dealCards();
        table.repaint();
        game.hitOrStand();
        table.repaint();
        game.checkBlackjack();
        table.repaint();
        game.dealerTurn();
        table.repaint();


        System.out.println("Game started");
    }

    

}
