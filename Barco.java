public class Barco {
    private String nombre;
    private int longitud;
    private boolean[][] posicion;  // La posición se guarda en una matriz 2D (fila, columna)

    public Barco(String nombre, int longitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.posicion = new boolean[10][10];  // El tablero es de 10x10
    }

    public String getNombre() {
        return nombre;
    }

    public int getLongitud() {
        return longitud;
    }

    public boolean[][] getPosicion() {
        return posicion;
    }

    // Coloca el barco en el tablero (horizontal o vertical)
    public void colocarBarco(int fila, int columna, boolean esHorizontal) {
        for (int i = 0; i < longitud; i++) {
            if (esHorizontal) {
                posicion[fila][columna + i] = true;
            } else {
                posicion[fila + i][columna] = true;
            }
        }
    }

    // Verifica si un disparo impactó en el barco
    public boolean recibirImpacto(int fila, int columna) {
        return posicion[fila][columna];
    }
}


