public class Main {
    public static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {
        Life game = new Life();
        Form form = new Form();
        form.display(game.getDefineGeneration());
        boolean t = true;
        while (t) {
            if (Form.PAUSE) {
                boolean[][] generation = game.nextGeneration();
                game.nextGeneration();
                form.display(generation);
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
