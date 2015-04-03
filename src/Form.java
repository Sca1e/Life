import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    public static boolean PAUSE = false;
    JPanel panel = new JPanel();
    JLabel label1 = new JLabel("Text");
    JButton buttonRun = new JButton("Run");
    JButton buttonReset = new JButton("Reset");
    public Form() {
        super("Life");
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(null);
        label1.setSize(300, 300);
        label1.setLocation(100, 0);
        buttonRun.setSize(150, 30);
        buttonRun.setLocation(40, 300);
        buttonReset.setSize(150, 30);
        buttonReset.setLocation(200, 300);
        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Run".equals(buttonRun.getText())) {
                    buttonRun.setText("Pause");
                    PAUSE = true;
                } else {
                    buttonRun.setText("Run");
                    PAUSE = false;
                }

            }
        });
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonRun.setText("Run");
                Life game = new Life();
                display(game.getDefineGeneration());
                PAUSE = false;
            }
        });
        panel.add(label1);
        panel.add(buttonRun);
        panel.add(buttonReset);
        this.add(panel);
        this.setVisible(true);
        label1.setForeground(Color.black);
    }
    private int isAlive(boolean temp){
        if (temp) return 1;
        else return 0;
    }
    public void display(boolean[][] generation){
        StringBuilder table = new StringBuilder();
        table.append("<HTML>");
        for (boolean[] x : generation) {
            for (boolean y : x) {
                table.append(" ");
                table.append(isAlive(y));
            }
            table.append("<br>");
        }
        label1.setText(table.toString());
    }

}
