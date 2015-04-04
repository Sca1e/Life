public class Main {
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {
        Life game = new Life();
        Form form = new Form();
        form.changeInitialState(true);
        do {
            if (form.isInitialState()) {
                form.changeInitialState(false);
                game.initialArrayState();
                form.setPause(true);
                boolean[][] generation = game.nextGeneration();
                form.display(generation);
            }
                if (!form.isPause()) {
                    boolean[][] generation = game.nextGeneration();
                    form.display(generation);

                    try {
                        Thread.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
        }   while (true);
    }
}
