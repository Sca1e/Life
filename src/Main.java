/**
 * Created by Sca1e on 27.03.2015.
 */
public class Main {
    public static final int REFRESH_QUANTITY = 30;
    public static final int SLEEP_TIME = 1000;
    public static void main(String[] args) {
        Life runLife = new Life();
        Form showOnScreen = new Form();
        for (int i = 0; i < REFRESH_QUANTITY; i++) {
            showOnScreen.printOnForm(runLife.returnNextGeneration());
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
