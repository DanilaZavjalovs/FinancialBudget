package org.zloebok.financialbudget.webController.security;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zloebok.financialbudget.user.service.UserService;
import org.zloebok.financialbudget.user.dto.UserDto;
import org.zloebok.financialbudget.user.entity.Role;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;


    @GetMapping
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());

        return "registration";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UserDto user) {
        user.setRole(Role.User);
        userService.saveUser(user);

        return "redirect:/";
    }
}
