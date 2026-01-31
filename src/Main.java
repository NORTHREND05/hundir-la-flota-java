public class Main {
    public static void main(String[] args) {



        // Parámetros del juego (pueden ajustarse)
        int size = 5;
        int ships = 5;
        int attempts = 10;

        Game game = new Game(size, ships, attempts);
        ConsoleUI ui = new ConsoleUI();

        ui.mostrarMensaje("Bienvenido a nuestro juego Hundir la Flota");

        while (!game.isGameOver()) {

            ui.mostrarMensaje("Barcos restantes: " + game.getShipsRemaining());
            ui.mostrarMensaje("\nIntentos restantes: " + game.getAttempts());

            // El tablero lo imprime la lógica (Game/Board)
            game.printBoard(false);

            int columna = ui.pedirColumna();
            int fila = ui.pedirFila();

            try {
                char resultado = game.shoot(fila, columna);

                switch (resultado) {
                    case 'X':
                        ui.mostrarMensaje("¡Tocadooooo!");
                        break;
                    case 'O':
                        ui.mostrarMensaje("Aguaaaaa...");
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
