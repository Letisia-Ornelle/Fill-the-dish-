package home.home2.Model.Exceptions;

public class duplicateIngredientException extends Exception{

    private static final long serialVersionID = 1L;

    public duplicateIngredientException(){
        super();
    }

    public duplicateIngredientException(String message){
        super(message);
    }

    public duplicateIngredientException(Throwable cause){
        super(cause);
    }

    public duplicateIngredientException (String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }

}
