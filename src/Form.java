import javax.swing.*;
import java.awt.*;
/**
 * Created by Sca1e on 27.03.2015.
 */
public class Form extends JFrame {
    JLabel label1 = new JLabel("Text");
    public Form() {
        super("Life");
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        this.add(label1);
        this.setVisible(true);
        label1.setForeground(Color.black);
    }
    private int isAlive(boolean temp){
        if (temp) return 1;
        else return 0;
    }
    public void display(boolean[][] generation){
        String table = "<HTML>";
        for (boolean[] x : generation) {
            for (boolean y : x) {
                table = table + " " + isAlive(y);
            }
            table = table + "<br>";
        }
        label1.setText(table);
    }

}
