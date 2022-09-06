package home.home2.Model.Exceptions;

public class loginFailedException extends Exception{

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
