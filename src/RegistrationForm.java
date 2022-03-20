import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationForm extends JDialog{
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;
    private JButton btnLogin;

    /*Create Constructor*/
    public RegistrationForm (JFrame parent){
        super(parent);
        setTitle("Create a new Account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent); /*sets the dialog in the middle*/
        setDefaultCloseOperation((DISPOSE_ON_CLOSE));


//        Action Listener for the Register Button
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();

            }
        });
//        Action Listener for the Cancel Button
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();/*Closes the Application*/

            }
        });
//        Action Listener for the Login Button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
//Create the Register User Function
    private void registerUser() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

//        Check that all fields are entered
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Please Enter All Fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
//        Ensure that password is confirmed Successfully
        if (!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(this,
                    "Confirm Password Does not Match",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = addUserToDatabase(name , email, phone, password);
        if (user!= null){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,
                    "Failed to Register New User",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
    public User user;
    private User addUserToDatabase ( String name, String email, String phone, String password){
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/JavaDashboard";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (name, email, phone, password)" +
                    "VALUES(? ,?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, password);

//            Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0){
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.password = password;
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        WelcomePage welcomePage = new WelcomePage();

        User user = myForm.user;
        if(user != null) {
            System.out.println("Successful registration of:" + user.name);
        }
        else {
            System.out.println("Registration Canceled");
        }


    }
}
