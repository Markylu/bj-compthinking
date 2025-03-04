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
        // Panel for buttons
        
        JButton newGameButton = new JButton("New Game");
        JButton quitButton = new JButton("Quit");
        // Buttons for new game and quit
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            window.remove(panel); 
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // closes start game window
            BlackjackGameManager gameManager = new BlackjackGameManager();
            // runs game manager
            window.add(panel);
            window.setVisible(true);
            // reopens start game window
        }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                // closes the program
            }
        });

        panel.add(newGameButton);
        panel.add(quitButton);
        // adds buttons to panel

        window.add(panel);
        window.setSize(400, 100);
        App.window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        // Shows Window and sets it up
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {public void run() {initWindow();}});
        // Runs Start Game Window

    }

}
