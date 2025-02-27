


public class BlackjackGameManager {

    public BlackjackGameManager() {
        blackjackGame game = new blackjackGame();
        game.initializeGame();
        Table table = new Table(game);
        App.window.add(table);
        // window.addKeyListener(table);
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


        System.out.println("Game started");
    }

    

}
