import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    public static JFrame window;

    public static void initWindow() {
        window = new JFrame("Blackjack");
        JPanel panel = new JPanel();
        
        JButton newGameButton = new JButton("New Game");
        JButton quitButton = new JButton("Quit");

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            window.remove(panel); 
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            BlackjackGameManager blackjackgame = new BlackjackGameManager();
        }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(newGameButton);
        panel.add(quitButton);

        window.add(panel);
        window.setSize(400, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {public void run() {initWindow();}});

    }

}
