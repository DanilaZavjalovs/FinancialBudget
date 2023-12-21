package org.zloebok.financialbudget.exception.user;

public class UserConstraintValidationException extends RuntimeException{
    public UserConstraintValidationException(String message) {
        super(message);
    }

    public UserConstraintValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
