package home.home2.Model.Exceptions;

public class duplicateIngredientException extends Exception{

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
