
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Table extends JPanel {

    int cardheight = 154;
    int cardwidth = 110;
    int tableWidth = cardwidth * 10;
    int tableHeight = cardheight * 5 + 81;

    blackjackGame game;
    Player[] players;
    User user;
    // Dealer dealer;

    public Table(blackjackGame game) {
        this.game = game;
        this.players = this.game.players;
        // this.dealer = (Dealer) players[0];
        this.user = (User) players[1];
        setPreferredSize(new Dimension(tableWidth, tableHeight));
        setBackground(new Color(0, 128, 0));
        setLayout(null);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        setupKeyBindings();
    }

    public void updateTable() {
        // update the table
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCards(g);
        drawBet(g);
        drawplayerNames(g);
        drawHandValue(g);
    }

    private void setupKeyBindings() {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "quit");
        getRootPane().getActionMap().put("quit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BlackjackGameManager.isRunning = false;
            }
        });
    }

    private void drawBet(Graphics g) {
        // set the text to be displayed
        String text = "Your Balance: $" + user.balance + "        Your Bet Amount: $" + user.bet + "        Hand Value: " + user.handValue;
        // we need to cast the Graphics to Graphics2D to draw nicer text
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(
                RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        // set the text color and font and get the metrics
        // to calculate the position of the text
        g2d.setColor(new Color(30, 201, 139));
        g2d.setFont(new Font("Lato", Font.BOLD, 25));
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        Rectangle rect = new Rectangle(0, 0, tableWidth, metrics.getHeight());
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + rect.height;
        // draw the string
        g2d.drawString(text, x, y);
    }

    public void drawCards(Graphics g) {
        // draw the cards for each player
        for (Player player : players) {
            int x = 0;
            int y = 0;
            switch (player.playerID) {
                case 0 -> {
                    // dealer
                    x = 250;
                    y = 20;
                }
                case 1 -> {
                    // user
                    x = 250;
                    y = 30 + cardheight * 4;
                }
                case 2 -> {
                    // fiftyfiftybot
                    x = 250;
                    y = 30 + cardheight;
                }
                case 3 -> {
                    // normalbot
                    x = 250;
                    y = 30 + cardheight * 2;
                }
                case 4 -> {
                    // hardbot
                    x = 250;
                    y = 30 + cardheight * 3;
                }
                default -> {
                    // no player
                }
            }
            for (Card card : player.hand) {
                // hidden cards
                if (card.isHidden) {
                    try {
                        Image img = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                        g.drawImage(img, x, y + 31, cardwidth, cardheight, null);
                    } catch (Exception e) {
                        System.err.println("Error loading card image: " + e.getMessage());
                    }
                } else {
                    // visible cards
                    // draw the card image
                    try {
                        Image img = new ImageIcon(getClass().getResource(card.getCard())).getImage();
                        g.drawImage(img, x, y + 31, cardwidth, cardheight, null);
                    } catch (Exception e) {
                        System.err.println("Error loading card image: " + e.getMessage());
                    }
                }
                x += cardwidth;
            }
        }
    }

    // draw the player names
    public void drawplayerNames(Graphics g) {
        // draw the player names
        for (Player player : players) {
            int x;
            int y;
            switch (player.playerID) {
                case 0 -> {
                    // dealer
                    x = 20;
                    y = 30;
                }
                case 1 -> {
                    // user
                    x = 20;
                    y = 40 + cardheight * 4;
                }
                case 2 -> {
                    // fiftyfiftybot
                    x = 20;
                    y = 40 + cardheight;
                }
                case 3 -> {
                    // normalbot
                    x = 20;
                    y = 40 + cardheight * 2;
                }
                case 4 -> {
                    // hardbot
                    x = 20;
                    y = 40 + cardheight * 3;
                }
                default -> {
                    // no player
                    continue;
                }
            }
            g.drawString(player.name, x, y + 51);
        }
    }

    // draw the hand value
    public void drawHandValue(Graphics g) {
        // draw the hand value
        for (Player player : players) {
            int x;
            int y;
            switch (player.playerID) {
                case 0 -> {
                    // dealer
                    x = 20;
                    y = 30;
                }
                case 1 -> {
                    // user
                    x = 20;
                    y = 40 + cardheight * 4;
                }
                case 2 -> {
                    // fiftyfiftybot
                    x = 20;
                    y = 40 + cardheight;
                }
                case 3 -> {
                    // normalbot
                    x = 20;
                    y = 40 + cardheight * 2;
                }
                case 4 -> {
                    // hardbot
                    x = 20;
                    y = 40 + cardheight * 3;
                }
                default -> {
                    // no player
                    continue;
                }
            }
            if (player != players[0]) {
                g.drawString("Hand Value: " + player.handValue, x, y + 71);
            }
        }
    }
    
    public void drawStatus(Graphics g) {
        // draw the status
        for (Player player : players) {
            int x;
            int y;
            switch (player.playerID) {
                case 0 -> {
                    // dealer
                    x = 20;
                    y = 30;
                }
                case 1 -> {
                    // user
                    x = 20;
                    y = 40 + cardheight * 4;
                }
                case 2 -> {
                    // fiftyfiftybot
                    x = 20;
                    y = 40 + cardheight;
                }
                case 3 -> {
                    // normalbot
                    x = 20;
                    y = 40 + cardheight * 2;
                }
                case 4 -> {
                    // hardbot
                    x = 20;
                    y = 40 + cardheight * 3;
                }
                default -> {
                    // no player
                    continue;
                }
            }
            if (player != players[0]) {
                g.drawString(player.status, x, y + 91);
            }
        }
    }
}
