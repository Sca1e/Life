import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {

    private final String BTN_TEXT_RUN = "Run";
    private final String BTN_TEXT_PAUSE = "PAUSE";

    private boolean pause = false;
    private boolean initialState = false;

    private JLabel label1 = new JLabel();
    private JButton buttonRun = new JButton(BTN_TEXT_RUN);

    public Form() {
        super("Life");
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String BTN_TEXT_RESET = "Reset";
        JButton buttonReset = new JButton(BTN_TEXT_RESET);

        label1.setSize(300, 300);
        label1.setLocation(100, 0);

        buttonRun.setSize(150, 30);
        buttonRun.setLocation(40, 300);

        buttonReset.setSize(150, 30);
        buttonReset.setLocation(200, 300);

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonRun.setText(pause ? BTN_TEXT_PAUSE : BTN_TEXT_RUN);
                pause = !pause;
            }
        });
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonRun.setText(BTN_TEXT_RUN);
                pause = true;
                initialState = true;
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(label1);
        panel.add(buttonRun);
        panel.add(buttonReset);

        this.add(panel);
        this.setVisible(true);
    }

    private int isAlive(boolean temp) {
        if (temp) return 1;
        else return 0;
    }

    public void display(boolean[][] generation) {
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

    public boolean isPause() {
        return pause;
    }

    public void changeInitialState(boolean temp) {
        initialState = temp;
    }

    public boolean isInitialState() {
        return initialState;
    }
    public void setPause(boolean temp){
        pause = temp;
    }
}