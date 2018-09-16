package game.dice.com.dicegameapp.utilities;

public class ExceptionGameNull extends RuntimeException {

    public ExceptionGameNull(String msg) {
        super("El jugador no tiene juegos");
    }

    public ExceptionGameNull() {
        super();
    }
}
