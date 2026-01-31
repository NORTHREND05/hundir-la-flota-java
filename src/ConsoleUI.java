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
}
