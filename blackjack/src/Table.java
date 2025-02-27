import java.awt.*;
import javax.swing.JPanel;

public class Table extends JPanel {
    int cardheight = 154;
    int cardwidth = 110;
    int tableWidth = cardwidth*10;
    int tableHeight = cardheight*5;

    
	public Table() {
        setPreferredSize(new Dimension(tableWidth, tableHeight));
        setBackground(new Color(0, 128, 0));
        setLayout(null);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // try{
        //     Image img = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
        //     g.drawImage(img, 1024, 600, cardwidth, cardheight, null);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}
