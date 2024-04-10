package AlexSpring.ApiRest.Services;

public class NotAutoreException extends RuntimeException {

    public NotAutoreException(){
        super("Non è possibile creare un blog. nessun Autore inserito");
    }
}
