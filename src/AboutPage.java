import javax.swing.*;
import java.awt.*;
import java.awt.desktop.AboutHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutPage extends JFrame {

    private JButton homeButton;
    private JButton aboutButton;
    private JButton contactButton;
    private JPanel AboutPage;


    AboutPage(){
        setTitle("About ");
        setContentPane(AboutPage);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation((DISPOSE_ON_CLOSE));
        setVisible(true);


        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
}
