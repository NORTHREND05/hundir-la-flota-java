import java.util.Arrays;

public class Board {
    private final int size;
    private final char[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        fillWater();
    }

    private void fillWater() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(grid[i], '~');
        }
    }

    public int getSize() {
        return size;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
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