import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactPage extends JFrame{
    private JButton homeButton;
    private JButton aboutButton;
    private JPanel ContactPage;
    private JButton contactButton;


    ContactPage(){
        setTitle("Contact! ");
        setContentPane(ContactPage);
        setMinimumSize(new Dimension(450, 474));
        setDefaultCloseOperation((DISPOSE_ON_CLOSE));
        setVisible(true);
        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
}
