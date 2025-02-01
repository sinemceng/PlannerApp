import javax.swing.*;
import java.awt.*;

public class form2 extends JFrame {
    private JPanel panel2;

    public form2() {
        panel2 = new JPanel();
        JLabel lb =new JLabel("Correct Entry!",SwingConstants.CENTER);
        lb.setFont(new Font("Arial",Font.BOLD,16));
        panel2.setLayout(new BorderLayout());
        panel2.add(lb, BorderLayout.CENTER);
        panel2.add(lb);
        add(panel2);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setTitle("Success");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
