package home.home2.Model.Exceptions;

public class loginFailedException extends Exception{

    private final static  long serialVersion = 2L;

    public  loginFailedException() {
        super();
    }

    public loginFailedException(String message){
        super(message);
    }

    public loginFailedException(Throwable cause){
        super (cause);
    }

    public loginFailedException(String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }


}
