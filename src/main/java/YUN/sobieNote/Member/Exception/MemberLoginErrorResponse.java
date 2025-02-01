package YUN.sobieNote.Member.Exception;

public class MemberLoginErrorResponse {

    private String code;
    private String message;


    public MemberLoginErrorResponse(String code, String message ){
        this.code  = code;
        this.message = message;
    }

}
