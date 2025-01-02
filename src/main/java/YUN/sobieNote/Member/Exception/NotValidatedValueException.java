package YUN.sobieNote.Member.Exception;

public class NotValidatedValueException extends RuntimeException{

    public NotValidatedValueException(String message){
        super(message);
    }

    public NotValidatedValueException(){
        super();
    }

}
