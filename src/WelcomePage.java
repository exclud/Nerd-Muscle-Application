import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame{

    private JButton homeButton;
    private JButton aboutButton;
    private JButton contactButton;
    private JPanel WelcomePage;

    WelcomePage(){

        setTitle("Welcome! ");
        setContentPane(WelcomePage);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation((DISPOSE_ON_CLOSE));
        setVisible(true);

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        ContactPage contactPage = new ContactPage();
        AboutPage aboutPage = new AboutPage();



    }

}
