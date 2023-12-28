package org.zloebok.financialbudget.exception.user;

public class UserConstraintException extends RuntimeException {
    public UserConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
