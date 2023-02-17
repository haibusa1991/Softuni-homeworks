package com.likebook.controllers;

import com.likebook.binding.BadCredentials;
import com.likebook.binding.LoginForm;
import com.likebook.binding.PasswordMismatch;
import com.likebook.binding.RegistrationForm;
import com.likebook.entities.User;
import com.likebook.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registrationForm")
    public RegistrationForm getRegistrationFromBinding() {
        return new RegistrationForm();
    }

    @ModelAttribute("passwordMismatch")
    public PasswordMismatch getPasswordMismatch() {
        return new PasswordMismatch();
    }

    @ModelAttribute("loginForm")
    public LoginForm getLoginForm() {
        return new LoginForm();
    }

    @ModelAttribute("badCredentials")
    public BadCredentials getBadCredentials() {
        return new BadCredentials();
    }

    @GetMapping("/login")
    public String getLogin() {
        if (this.userService.hasUser()) {
            return "redirect:/home";
        }

        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        if (this.userService.hasUser()) {
            return "redirect:/home";
        }

        return "register";
    }

    @GetMapping("/logout")
    public String logout() {
        if (this.userService.hasUser()) {
            this.userService.logoutUser();
        }
        return "redirect:/";
    }


    @PostMapping("/register")
    public String registerUser(@Valid RegistrationForm registrationForm,
                               BindingResult bindingResult,
                               PasswordMismatch passwordMismatch,
                               RedirectAttributes redirectAttributes) {

        String password = registrationForm.getPassword();
        String rePass = registrationForm.getRePass();

        boolean isRepassCorrect = password.equals(rePass);

        if (!isRepassCorrect) {
            passwordMismatch.setPasswordMismatch(true);
        }

        if (bindingResult.hasErrors() || !isRepassCorrect) {
            redirectAttributes.addFlashAttribute("registrationForm", registrationForm);
            redirectAttributes.addFlashAttribute("passwordMismatch", passwordMismatch);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationForm", bindingResult);
            return "redirect:register";
        }

        this.userService.registerUser(registrationForm);

        return "redirect:login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginForm loginForm,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            BadCredentials badCredentials) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginForm", loginForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", bindingResult);

            return "redirect:login";
        }

        this.userService.loginUser(loginForm);

        if(!this.userService.hasUser()){
            badCredentials.setBadCredentials(true);

            redirectAttributes.addFlashAttribute("loginForm", loginForm);
            redirectAttributes.addFlashAttribute("badCredentials", badCredentials);

            return "redirect:login";
        }

        return "redirect:/";
    }

}
