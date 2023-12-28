package org.zloebok.financialbudget.exception.user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zloebok.financialbudget.exception.user.UserConstraintException;
import org.zloebok.financialbudget.user.dto.UserDto;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserConstraintException.class)
    public String handleUserConstraintException(UserConstraintException exception, Model model) {
        String exceptionMessage = extractErrorMessage(exception);

        model.addAttribute("exceptionMessage", exceptionMessage);
        model.addAttribute("user", new UserDto());

        return "registration";
    }

    private String extractErrorMessage(UserConstraintException exception) {
        String rawMessage = exception.getCause().getMessage();

        String message;
        if (rawMessage.contains("uk_eamk4l51hm6yqb8xw37i23kb5")) {
            message = "This email is already taken.";
        } else if (rawMessage.contains("uk_en3wad7p8qfu8pcmh62gvef6v")) {
            message = "This username is already taken.";
        } else {
            message = "An error occurred with user constraints.";
        }

        return message;
    }
}
