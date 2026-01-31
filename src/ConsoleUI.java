
import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int pedirFila() {
        System.out.print("Introduce fila: ");
        return leerNumero();
    }

    public int pedirColumna() {
        System.out.print("Introduce columna: ");
        return leerNumero();
    }

    private int leerNumero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. Introduce un número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void mostrarTablero(char[][] tablero) {
        System.out.println("\nTablero:");

        System.out.print("  ");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

}
