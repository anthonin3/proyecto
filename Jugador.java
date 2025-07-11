import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Tablero tablero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tablero = new Tablero();
    }

    public String getNombre() {
        return nombre;
    }

    public Tablero getTablero() {
        return tablero;
    }

    // Coloca los barcos en el tablero (manual o aleatorio)
    public void colocarBarcos() {
        Scanner scanner = new Scanner(System.in);

        // Supongamos que el jugador coloca manualmente los barcos
        for (int i = 0; i < 3; i++) {
            System.out.println("Jugador " + nombre + ", coloca tu barco " + (i + 1) + ":");
            System.out.print("Fila: ");
            int fila = scanner.nextInt();
            System.out.print("Columna: ");
            int columna = scanner.nextInt();
            System.out.print("¿Es horizontal? (true/false): ");
            boolean esHorizontal = scanner.nextBoolean();

            Barco barco = new Barco("Barco " + (i + 1), 3);
            tablero.colocarBarco(barco, fila, columna, esHorizontal);
        }
    }

    // Dispara al oponente
    public boolean dispararAlOponente(Jugador oponente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(nombre + ", ingresa las coordenadas para disparar (fila, columna): ");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();

        return oponente.getTablero().disparar(fila, columna);
    }
}

