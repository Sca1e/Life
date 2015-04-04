/**
 * This class represents the Conway's Game of Life.
 *
 * @author Sca1e
 * @see Life#nextGeneration()
 * @since 18.03.2015
 */
public class Life {
    private static final int ROW = 15;
    private static final int COLUMN = 15;
    private boolean generation[][] = new boolean[][]{
            {false, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, false, false, true, false, true, true, false, true, false, true, true},
            {true, true, true, false, true, false, true, false, true, true, false, true, false, true, true},
            {true, false, true, false, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
            {true, true, false, true, true, false, true, false, true, true, false, true, false, true, true},
    };
    private boolean nextGeneration[][] = new boolean[ROW][COLUMN];
    private boolean currentGeneration[][] = new boolean[ROW][COLUMN];
    public void initialArrayState() {
        for (int i = 0; i < generation.length; i++){
            System.arraycopy(generation[i], 0, currentGeneration[i], 0, generation[i].length);
        }
    }
    //TODO: Comment me.
    private static boolean isAlive(boolean[][] universe, int cellX, int cellY) {
        return universe[cellX][cellY];
    }

    private static boolean isInBounds(boolean[][] universe, int cellX, int cellY) {
        if (cellX < 0 || cellX >= universe.length) return false;
        else if (cellY < 0 || cellY >= universe[cellX].length) return false;
        return true;
    }

    private static boolean isInBoundsAndAlive(boolean[][] universe, int cellX, int cellY) {
        return isInBounds(universe, cellX, cellY) && isAlive(universe, cellX, cellY);
    }

    private static int countNeighbours(boolean[][] universe, int cellX, int cellY) {
        int count = 0;
        if (isInBoundsAndAlive(universe, cellX - 1, cellY - 1)) count++;
        if (isInBoundsAndAlive(universe, cellX, cellY - 1)) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY - 1)) count++;
        if (isInBoundsAndAlive(universe, cellX - 1, cellY)) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY)) count++;
        if (isInBoundsAndAlive(universe, cellX - 1, cellY + 1)) count++;
        if (isInBoundsAndAlive(universe, cellX, cellY + 1)) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY + 1)) count++;
        return count;
    }

    private boolean willComeAlive(boolean[][] universe, int cellX, int cellY) {
        int neighboursCount = countNeighbours(universe, cellX, cellY);
        boolean alive = isAlive(universe, cellX, cellY);
        return (alive && (neighboursCount == 2 || neighboursCount == 3)) || (!alive && neighboursCount == 3);
    }

    /**
     * Calculate next generation
     *
     * @return next generation.
     */
    public boolean[][] nextGeneration() {
        boolean temp[][] = new boolean[ROW][COLUMN];
        for (int i = 0; i < currentGeneration.length; i++) {
            for (int j = 0; j < currentGeneration[i].length; j++) {
                temp[i][j] = nextGeneration[i][j] = willComeAlive(currentGeneration, i, j);
            }
        }
        boolean[][] t = currentGeneration;
        currentGeneration = nextGeneration;
        nextGeneration = t;
        return temp;
    }





}

