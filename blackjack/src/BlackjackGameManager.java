


public class BlackjackGameManager {

    public BlackjackGameManager() {
        Table table = new Table();
        App.window.add(table);
        // window.addKeyListener(table);
        App.window.setResizable(false);
        App.window.pack();
        App.window.setLocationRelativeTo(null);
        App.window.setVisible(true); 
        blackjackGame game = new blackjackGame();
        game.initializeGame();
        game.getBets();
        Deck.newDeck();
        Deck.shuffle();


        System.out.println("Game started");
    }

    

}
