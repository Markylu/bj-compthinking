import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Table extends JPanel {
    int cardheight = 154;
    int cardwidth = 110;
    int tableWidth = cardwidth*10;
    int tableHeight = cardheight*5;

    
    blackjackGame game;
    Player[] players;
    User user;
    // Dealer dealer;

    public Table(blackjackGame game) {
        this.game = game;
        this.players = game.players;
        // this.dealer = (Dealer) players[0];
        this.user = (User) players[1];
        setPreferredSize(new Dimension(tableWidth, tableHeight));
        setBackground(new Color(0, 128, 0));
        setLayout(null);
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
    }
    private void drawBet(Graphics g) {
        // set the text to be displayed
        String text ="Your Balance: $" + user.balance + "        Your Bet Amount: $" + user.bet + "       Pot: $" + game.getPot() + "        Hand Value: " + user.handValue;  
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
        // set the text color and font
        g2d.setColor(new Color(30, 201, 139));
        g2d.setFont(new Font("Lato", Font.BOLD, 25));
        // draw the score in the bottom center of the screen
        // https://stackoverflow.com/a/27740330/4655368
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        // the text will be contained within this rectangle.
        // here I've sized it to be the entire bottom row of board tiles
        Rectangle rect = new Rectangle(0, 0, tableWidth, metrics.getHeight());
        // determine the x coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // determine the y coordinate for the text
        // (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + rect.height;
        // draw the string
        g2d.drawString(text, x, y);
    }

    public void drawCards(Graphics g) {
        // draw the cards for each player
        for (Player player : players) {
            int x;
            int y;
            if (player.playerID == 0) {
                // dealer
                x = 20;
                y = 20;
            } else {
                // user
                x = 20;
                y = cardheight*3;
            }
            for (Card card : player.hand) {
                if (card.isHidden) {
                    try{
                        Image img = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                        g.drawImage(img, x, y, cardwidth, cardheight, null);
                    } catch (Exception e) {
                        System.err.println("Error loading card image: " + e.getMessage());
                    }
                } else {
                    try{
                        Image img = new ImageIcon(getClass().getResource(card.getCard())).getImage();
                        g.drawImage(img, x, y, cardwidth, cardheight, null);
                    } catch (Exception e) {
                        System.err.println("Error loading card image: " + e.getMessage());
                    }
                }
                x += cardwidth;
            }
        }
    }
}
