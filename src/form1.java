import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame{
    private JPanel panel1;
    private JLabel İsim;
    private JPasswordField pass;
    private JButton signInButton;
    private  JTextField name;

    public form1() {
        add(panel1);
        setSize(400,200);
        setLocationRelativeTo(null);
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = "stella";
                String newName = name.getText();
                String password = "abc123";
                String newPass = new String(pass.getPassword());

                if (newPass.equals(password) && newName.equals(userName)) {
                    form2 secondForm = new form2();
                    System.out.println("Correct Entry!");
                    secondForm.setVisible(true);

                    new Thread(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        dispose();
                        secondForm.dispose();
                        new form3();
                    }).start();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect entry, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
