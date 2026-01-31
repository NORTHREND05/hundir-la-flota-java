import java.util.Arrays;
import java.util.Random;

public class Board {
    private final int size;
    private final char[][] grid;
    private final Random rnd = new Random();

    private int totalShips;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        fillWater();
        this.totalShips = 0;
    }

    private void fillWater() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(grid[i], '~');
        }
    }

    public int getSize() {
        return size;
    }

    public int getTotalShips() {
        return totalShips;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public void placeShipsRandom(int ships) {
        int placed = 0;
        while (placed < ships) {
            int r = rnd.nextInt(size);
            int c = rnd.nextInt(size);

            if (grid[r][c] == '~') {
                grid[r][c] = 'B';
                placed++;
            }
        }
        totalShips = ships;
    }

    // Para mostrar el tablero (de momento sin ocultar nada)
    public void print() {
        System.out.print("   ");
        for (int c = 0; c < size; c++) System.out.print(c + " ");
        System.out.println();

        for (int r = 0; r < size; r++) {
            System.out.printf("%2d ", r);
            for (int c = 0; c < size; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
}