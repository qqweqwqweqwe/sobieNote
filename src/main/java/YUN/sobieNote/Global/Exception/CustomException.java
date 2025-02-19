package YUN.sobieNote.Global.Exception;

public class CustomException{



    public static class ExternalAPIException extends RuntimeException{

        public ExternalAPIException(String message){
            super(message);
        }

    }
}
