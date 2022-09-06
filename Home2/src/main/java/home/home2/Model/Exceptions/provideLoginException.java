package home.home2.Model.Exceptions;

public class provideLoginException extends Exception {

    public  provideLoginException() {
        super();
    }

    public provideLoginException(String message){
        super(message);
    }

    public provideLoginException(Throwable cause){
        super (cause);
    }

    public provideLoginException(String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }
}
