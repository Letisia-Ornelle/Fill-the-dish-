package home.home2.Model.Exceptions;

public class duplicateRecipeException extends Exception{

    public duplicateRecipeException(){
        super();
    }

    public duplicateRecipeException(String message){
        super(message);
    }

    public duplicateRecipeException(Throwable cause){
        super(cause);
    }

    public duplicateRecipeException (String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }
}
