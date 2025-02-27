


public class BlackjackGameManager {

    public BlackjackGameManager() {
        Table table = new Table();
        App.window.add(table);
        // window.addKeyListener(table);
        App.window.setResizable(false);
        App.window.pack();
        App.window.setLocationRelativeTo(null);
        App.window.setVisible(true); 
        Player[] players = new Player[2];
        players[0] = new Dealer();
        players[1] = new User();
        Deck.newDeck();
        Deck.shuffle();
        for (Player player : players) {
            player.getBets();
        }
        System.out.println("Game started");
    }

    

}
