package org.zloebok.financialbudget.api.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zloebok.financialbudget.api.user.service.UserService;
import org.zloebok.financialbudget.user.dto.UserDto;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> getUserByUsername(@RequestHeader String username) {
        UserDto user = userService.getUserByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserDto user) {
        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
