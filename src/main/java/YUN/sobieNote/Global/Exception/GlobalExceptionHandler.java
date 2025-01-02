package YUN.sobieNote.Global.Exception;
import YUN.sobieNote.Member.Exception.NotValidatedValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    // todo 나중에 데이터베이스 생기면 데이터베이스에서 조회했을 때 없을 경우 에러
    @ExceptionHandler(NotValidatedValueException.class)
    public ResponseEntity<ErrorResponse> handleNotValidatedException(NotValidatedValueException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                "NotValidatedValueException",
                "리퀘스트 값이 잘못되었습니다"
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    // 아이디랑 이메일이 비어있을 때
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBlankLoginFieldException(MethodArgumentNotValidException ex){

        ErrorResponse errorResponse = new ErrorResponse(
                "NotValidatedValueException",
                "리퀘스트 값이 잘못되었습니다"
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }






}
