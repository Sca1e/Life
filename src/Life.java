import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sca1e on 18.03.2015.
 */
public class Life {
    public static void main(String[] args) throws IOException {
        System.out.println("The game called life, have been soon!!!");
//       byte[] b = new byte[]{};
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String s = bufferedReader.readLine();
//        return;
        int mas[][] = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        System.out.println("Result data:");
        int b = 0;
        for (int q = 0; q < 99; q++) {
             Runtime.getRuntime().exec("cls");
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    if (mas[i][j] == 0 & i > 0 & i < (mas.length - 1) & j > 0 & j < (mas.length - 1)) {
                        b = mas[i - 1][j - 1] + mas[i - 1][j] + mas[i - 1][j + 1] + mas[i][j - 1] + mas[i][j + 1] + mas[i + 1][j - 1] + mas[i + 1][j] + mas[i + 1][j + 1];
                        if (b == 3) {
                            mas[i][j] = 1;
                        } else {
                            mas[i][j] = 0;
                        }
                    }

                    if (mas[i][j] == 1 & i > 0 & i < (mas.length - 1) & j > 0 & j < (mas.length) - 1) {
                        b = mas[i - 1][j - 1] + mas[i - 1][j] + mas[i - 1][j + 1] + mas[i][j - 1] + mas[i][j + 1] + mas[i + 1][j - 1] + mas[i + 1][j] + mas[i + 1][j + 1];
                        if (b == 3 & b == 2) {
                            mas[i][j] = 1;
                        } else {
                            mas[i][j] = 0;
                        }
                    }
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

