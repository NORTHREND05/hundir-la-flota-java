public class Main {
    public static void main(String[] args) {

        // Parámetros del juego (pueden ajustarse)
        int size = 5;
        int ships = 5;
        int attempts = 10;

        Game game = new Game(size, ships, attempts);
        ConsoleUI ui = new ConsoleUI();

        ui.mostrarMensaje("Bienvenido a Hundir la Flota");

        while (!game.isGameOver()) {

            ui.mostrarMensaje("\nIntentos restantes: " + game.getAttempts());
            ui.mostrarMensaje("Barcos restantes: " + game.getShipsRemaining());

            // El tablero lo imprime la lógica (Game/Board)
            game.printBoard(false);

            int fila = ui.pedirFila();
            int columna = ui.pedirColumna();

            try {
                char resultado = game.shoot(fila, columna);

                switch (resultado) {
                    case 'X':
                        ui.mostrarMensaje("¡Tocado!");
                        break;
                    case 'O':
                        ui.mostrarMensaje("Agua...");
                        break;
                    case 'R':
                        ui.mostrarMensaje("Disparo repetido, no pierdes intento.");
                        break;
                }

            } catch (IllegalArgumentException e) {
                ui.mostrarMensaje("Coordenadas fuera de rango. Inténtalo de nuevo.");
            }
        }

        // Fin del juego
        if (game.hasWon()) {
            ui.mostrarMensaje("¡Has ganado! Has hundido todos los barcos.");
        } else {
            ui.mostrarMensaje("Has perdido. Te quedaste sin intentos.");
        }

        ui.mostrarMensaje("\nTablero final:");
        game.printBoard(true);
    }
}
