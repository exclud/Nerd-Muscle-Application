import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{

    private JButton homeButton;
    private JButton aboutButton;
    private JButton contactButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JPanel WelcomePage;

    WelcomePage(){

        setTitle("Welcome! ");
        setContentPane(WelcomePage);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation((DISPOSE_ON_CLOSE));
        setVisible(true);

    }


}
