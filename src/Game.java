public class Game {

    private final Board board;
    private int attempts;

    public Game(int size, int ships, int attempts) {
        this.board = new Board(size);
        this.board.placeShipsRandom(ships);
        this.attempts = attempts;
    }

    public int getSize() {
        return board.getSize();
    }

    public int getAttempts() {
        return attempts;
    }

    public int getShipsRemaining() {
        return board.getShipsRemaining();
    }

    public boolean isGameOver() {
        return board.allShipsSunk() || attempts <= 0;
    }

    public boolean hasWon() {
        return board.allShipsSunk();
    }

    // Disparo controlado por Game:
    // - valida rango (por si acaso)
    // - no consume intento si es repetido
    // Devuelve: 'X' tocado, 'O' agua, 'R' repetido
    public char shoot(int row, int col) {
        if (!isInRange(row, col)) {
            throw new IllegalArgumentException("Coordenadas fuera de rango");
        }

        char res = board.shoot(row, col);

        if (res != 'R') {
            attempts--;
        }

        return res;
    }

    public void printBoard(boolean revealShips) {
        board.print(revealShips);
    }

    private boolean isInRange(int r, int c) {
        return r >= 0 && r < board.getSize() && c >= 0 && c < board.getSize();
    }
}