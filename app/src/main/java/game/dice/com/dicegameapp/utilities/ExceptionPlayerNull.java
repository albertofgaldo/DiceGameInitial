package game.dice.com.dicegameapp.utilities;


public class ExceptionPlayerNull extends RuntimeException {

        public ExceptionPlayerNull(String msg) {
            super("No se ha encontrado el jugador");
        }

        public ExceptionPlayerNull() {
            super();
        }


}
