import com.sun.deploy.util.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Sca1e on 18.03.2015.
 */
public class Life extends JFrame{

    public static final int REFRESH_QUANTITY = 10;

        public Life() {
            super("Life");
            setBounds(300, 300, 400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


//**********************************************************************************************************************
    public static int addCellStatus(int cellStatus, int number){
        if ((cellStatus == 1 && (number == 2 || number == 3)) || (cellStatus == 0 && number == 3)){
            return 1;
        } else return 0;
    }
//**********************************************************************************************************************

    public static int calcNumber(int display[][], int i, int j){
        int number = 0;
        if ( i > 0 && i < (display.length - 1) && j > 0 && j < (display.length - 1)) {
            number = display[i - 1][j - 1] + display[i - 1][j] + display[i - 1][j + 1] + display[i][j - 1] + display[i][j + 1] + display[i + 1][j - 1] + display[i + 1][j] + display[i + 1][j + 1];
        }
        if ( i == 0 && j == 0) {
            number = display[i][j + 1] + display[i + 1][j] + display[i + 1][j + 1];
        }
        if ( i == display.length && j == 0) {
            number = display[i - 1][j] + display[i - 1][j + 1] + display[i][j + 1];
        }
        if ( i == 0 && j == display.length) {
            number = display[i][j - 1] + display[i + 1][j - 1] + display[i + 1][j];
        }
        if ( i == display.length && j == display.length) {
            number = display[i - 1][j - 1] + display[i - 1][j] + display[i][j - 1];
        }
        return number;
    }
//**********************************************************************************************************************

    public static void main(String[] args) throws InterruptedException {
        JLabel label1 = new JLabel("Text");
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

//        JButton button1 = new JButton("Run");
//        button1.setHorizontalAlignment(JButton.CENTER);
//        button1.setVerticalAlignment(JButton.BOTTOM);
//        button1.doClick();
        
        Life app = new Life();
        app.add(label1);
//        app.add(button1);
        app.setVisible(true);

        label1.setForeground(Color.black);
        int display[][] = {
                {0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        String labelOut = "<html>";
        System.out.println("Result data:");

        for (int q = 0; q < REFRESH_QUANTITY; q++) {
            for (int i = 0; i < display.length; i++) {
                for (int j = 0; j < display.length; j++) {

                    int number = calcNumber(display, i, j);
                    display[i][j] = addCellStatus(display[i][j], number);

//                    System.out.print(display[i][j] + " ");
                    labelOut = labelOut + display[i][j] + " ";
                }
                System.out.println();
                labelOut = labelOut + " <br>";
            }
            label1.setText(labelOut);
            labelOut = "<html>";
            Thread.sleep(1000);

        }
        labelOut = "Finish";
        label1.setText(labelOut);
    }
}

