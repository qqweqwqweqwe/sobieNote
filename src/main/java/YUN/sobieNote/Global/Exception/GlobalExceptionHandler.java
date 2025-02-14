package YUN.sobieNote.Global.Exception;
import YUN.sobieNote.Global.DTO.ApiResponse;
import YUN.sobieNote.Member.Exception.NotValidatedValueException;
import jakarta.persistence.EntityNotFoundException;
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

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotValidatedException(EntityNotFoundException ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>("FAIL", ex.getMessage(),null));
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
