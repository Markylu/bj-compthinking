import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Table {
    int tableWidth = 1024;
    int tableHeight = tableWidth/16*9;
    int cardheight = 154;
    int cardwidth = 110;


    JFrame window = new JFrame("Blackjack");
    JPanel gamePanel = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            try{
                Image img = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                g.drawImage(img, 1024, 600, cardwidth, cardheight, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

	public Table() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setSize(tableWidth, tableHeight);
        window.setVisible(true);
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));
        window.add(gamePanel);
    }

}
