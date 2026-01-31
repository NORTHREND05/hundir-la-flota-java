import java.util.Arrays;
import java.util.Random;

public class Board {
    private final int size;
    private final char[][] grid;
    private final Random rnd = new Random();

    private int totalShips;
    private int shipsRemaining;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        fillWater();
        this.totalShips = 0;
        this.shipsRemaining = 0;
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

    public int getShipsRemaining() {
        return shipsRemaining;
    }

    public boolean allShipsSunk() {
        return shipsRemaining == 0;
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
        shipsRemaining = ships;
    }

    // Devuelve:
    // 'X' tocado, 'O' agua, 'R' repetido
    public char shoot(int row, int col) {
        char cell = grid[row][col];

        if (cell == 'X' || cell == 'O') {
            return 'R'; // ya disparado
        }

        if (cell == 'B') {
            grid[row][col] = 'X';
            shipsRemaining--;
            return 'X';
        } else {
            grid[row][col] = 'O';
            return 'O';
        }
    }

    // Mostrar tablero. revealShips=false oculta barcos no tocados.
    public void print(boolean revealShips) {
        System.out.print("   ");
        for (int c = 0; c < size; c++) System.out.print(c + " ");
        System.out.println();

        for (int r = 0; r < size; r++) {
            System.out.printf("%2d ", r);
            for (int c = 0; c < size; c++) {
                char v = grid[r][c];
                if (!revealShips && v == 'B') v = '~';
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}