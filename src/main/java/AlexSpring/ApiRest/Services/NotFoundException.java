package AlexSpring.ApiRest.Services;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id){super("BLOG CON ID "+ id + " NON TROVATO");
    }
}
