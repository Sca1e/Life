/**
 * Created by Sca1e on 18.03.2015.
 */
public class Life  {
    private boolean generation[][] = new boolean[][]{
            {false, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, false,false, true, false, true, true,false, true, false, true, true},
            {true, true, true, false, true,false, true, false, true, true,false, true, false, true, true},
            {true, false, true, false, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
            {true, true, false, true, true,false, true, false, true, true,false, true, false, true, true},
    };
    private boolean nextGeneration[][] = new boolean[15][15];
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
        if (isInBoundsAndAlive(universe, cellX,     cellY - 1)) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY - 1)) count++;
        if (isInBoundsAndAlive(universe, cellX - 1, cellY    )) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY    )) count++;
        if (isInBoundsAndAlive(universe, cellX - 1, cellY + 1)) count++;
        if (isInBoundsAndAlive(universe, cellX,     cellY + 1)) count++;
        if (isInBoundsAndAlive(universe, cellX + 1, cellY + 1)) count++;
        return count;
    }
    private boolean willComeAlive(boolean[][] universe, int cellX, int cellY) {
        int neighboursCount = countNeighbours(universe, cellX, cellY);
        boolean alive = isAlive(universe, cellX, cellY);
        return (alive && (neighboursCount == 2 || neighboursCount == 3)) || (!alive && neighboursCount == 3);
    }
    private void generateNext() {
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                nextGeneration[i][j] = willComeAlive(generation, i, j);
            }
        }
        boolean[][] t = generation;
        generation = nextGeneration;
        nextGeneration = t;
    }
    public boolean[][] returnNextGeneration(){
        generateNext();
        return generation;
    }
}

