package org.zloebok.financialbudget.exception.details;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String message;
    private String exceptionName;
    private HttpStatus httpStatus;
    private LocalDateTime time;
}
