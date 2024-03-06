package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CodeAlreadyExistsException extends ResponseStatusException {
    public CodeAlreadyExistsException() { super(HttpStatus.BAD_REQUEST, "CODE_ALREADY_EXISTS"); }
}
