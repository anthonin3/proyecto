public class Main {
    public static void main(String[] args) {

                Jugador jugador1 = new Jugador("Jugador 1");
                Jugador jugador2 = new Jugador("Jugador 2");

                // Los jugadores colocan sus barcos
                jugador1.colocarBarcos();
                jugador2.colocarBarcos();

                boolean juegoEnCurso = true;
                while (juegoEnCurso) {
                    // Turno de jugador 1
                    System.out.println("\nTurno de " + jugador1.getNombre());
                    boolean acierto1 = jugador1.dispararAlOponente(jugador2);

                    // Verificar si jugador 2 ha perdido
                    if (verificarVictoria(jugador2)) {
                        System.out.println(jugador1.getNombre() + " ¡Ha ganado!");
                        break;
                    }

                    // Turno de jugador 2
                    System.out.println("\nTurno de " + jugador2.getNombre());
                    boolean acierto2 = jugador2.dispararAlOponente(jugador1);

                    // Verificar si jugador 1 ha perdido
                    if (verificarVictoria(jugador1)) {
                        System.out.println(jugador2.getNombre() + " ¡Ha ganado!");
                        break;
                    }
                }
            }

            // Verifica si todos los barcos de un jugador han sido hundidos
            public static boolean verificarVictoria(Jugador jugador) {
                return jugador.getTablero().todosBarcosHundidos();
            }
        }
