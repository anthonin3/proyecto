public class Tablero {
    private char[][] tablero;   // Tablero 10x10 con los estados de las casillas
    private Barco[] barcos;     // Lista de barcos

    public Tablero() {
        this.tablero = new char[10][10];
        this.barcos = new Barco[5];  // Supongamos que cada jugador tiene 5 barcos
        inicializarTablero();
    }

    // Inicializa el tablero con agua (~)
    public void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '~';  // ~ representa agua
            }
        }
    }

    // Coloca un barco en el tablero
    public void colocarBarco(Barco barco, int fila, int columna, boolean esHorizontal) {
        barco.colocarBarco(fila, columna, esHorizontal);
        barcos[barcos.length - 1] = barco;

        // Marca las casillas ocupadas por el barco en el tablero
        for (int i = 0; i < barco.getLongitud(); i++) {
            if (esHorizontal) {
                tablero[fila][columna + i] = 'B'; // B indica barco
            } else {
                tablero[fila + i][columna] = 'B'; // B indica barco
            }
        }
    }

    // Realiza un disparo y devuelve true si se ha impactado un barco
    public boolean disparar(int fila, int columna) {
        if (tablero[fila][columna] == 'B') {
            tablero[fila][columna] = 'X'; // Marca un impacto (X)
            return true;
        }
        tablero[fila][columna] = 'O'; // Marca agua (O)
        return false;
    }

    // Muestra el tablero (conocido por el jugador)
    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Verifica si todos los barcos han sido hundidos
    public boolean todosBarcosHundidos() {
        for (Barco barco : barcos) {
            for (int i = 0; i < barco.getLongitud(); i++) {
                for (int j = 0; j < barco.getPosicion().length; j++) {
                    if (barco.getPosicion()[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

