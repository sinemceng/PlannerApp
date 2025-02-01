import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class form3 extends JFrame {
    JPanel panel3 = new JPanel();
    JTextField textField = new JTextField(20);
    JTextField textPlanner=new JTextField(20);
    JPanel todoPanel = new JPanel();
    JPanel weeklyPlannerPanel = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();

    public form3() {
        setTitle("Planner");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTodoItem(textField.getText());
                textField.setText("");
            }
        });

        textPlanner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWeeklyItem(textPlanner.getText());
                textPlanner.setText("");
            }
        });


        todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(todoPanel);

        weeklyPlannerPanel.setLayout(new BoxLayout(weeklyPlannerPanel, BoxLayout.Y_AXIS));
        JScrollPane sc =new JScrollPane(weeklyPlannerPanel);

        tabbedPane.addTab("Todo List", createTodoTab());
        tabbedPane.addTab("Weekly Planner", createWeeklyTab());


        panel3.setLayout(new BorderLayout());
        panel3.add(tabbedPane, BorderLayout.CENTER);


        add(panel3);
        setVisible(true);
    }


    private JPanel createTodoTab() {
        JPanel todoTabPanel = new JPanel();
        todoTabPanel.setLayout(new BorderLayout());
        todoTabPanel.add(textField, BorderLayout.NORTH);
        todoTabPanel.add(new JScrollPane(todoPanel), BorderLayout.CENTER);
        return todoTabPanel;
    }

    private JPanel createWeeklyTab(){
        JPanel weeklyTabPanel = new JPanel();
        weeklyTabPanel.setLayout(new BorderLayout());
        weeklyTabPanel.add(textPlanner,BorderLayout.NORTH);
        weeklyTabPanel.add(new JScrollPane(weeklyPlannerPanel),BorderLayout.CENTER);
        return  weeklyTabPanel;
    }

    private void addTodoItem(String task) {
        JCheckBox checkBox = new JCheckBox(task);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    checkBox.setForeground(Color.GRAY);
                    checkBox.setFont(new Font("Arial", Font.ITALIC, 12));
                    checkBox.setSelected(true);
                } else {
                    checkBox.setForeground(Color.BLACK);
                    checkBox.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
                    checkBox.setSelected(false);
                }
            }
        });

        JPopupMenu pm =new JPopupMenu("Menu");
        JMenuItem delete=new JMenuItem("Delete");
        JMenuItem edit=new JMenuItem("Edit");

        pm.add(delete);
        pm.add(edit);

        checkBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    pm.show(checkBox, e.getX(), e.getY());
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todoPanel.remove(checkBox);
                todoPanel.revalidate();
                todoPanel.repaint();
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt =JOptionPane.showInputDialog(null,"New entry please: ",checkBox.getText());

                if (txt != null && !txt.trim().isEmpty()) {
                    checkBox.setText(txt);
                    todoPanel.revalidate();
                    todoPanel.repaint();
                }
            }
        });

        todoPanel.add(checkBox);  //checkbox ı panelden siler
        todoPanel.revalidate();   //swing e değişiklik olduğunu bildirir
        todoPanel.repaint();      //arayüzü yeniler
    }

    private void addWeeklyItem(String task2) {
        JCheckBox checkBox2 = new JCheckBox(task2);
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox2.isSelected()) {
                    checkBox2.setForeground(Color.GRAY);
                    checkBox2.setFont(new Font("Arial", Font.ITALIC, 12));
                    checkBox2.setSelected(true);
                } else {
                    checkBox2.setForeground(Color.BLACK);
                    checkBox2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 12));
                    checkBox2.setSelected(false);
                }
            }
        });

        JPopupMenu pm =new JPopupMenu("Menu");
        JMenuItem delete=new JMenuItem("Delete");
        JMenuItem edit=new JMenuItem("Edit");

        pm.add(delete);
        pm.add(edit);

        checkBox2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    pm.show(checkBox2, e.getX(), e.getY());
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weeklyPlannerPanel.remove(checkBox2);
                weeklyPlannerPanel.revalidate();
                weeklyPlannerPanel.repaint();
            }
        });

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt =JOptionPane.showInputDialog(null,"New entry please: ",checkBox2.getText());

                if (txt != null && !txt.trim().isEmpty()) {
                    checkBox2.setText(txt);
                    weeklyPlannerPanel.revalidate();
                    weeklyPlannerPanel.repaint();
                }
            }
        });

        weeklyPlannerPanel.add(checkBox2);
        weeklyPlannerPanel.revalidate();
        weeklyPlannerPanel.repaint();
    }
}
