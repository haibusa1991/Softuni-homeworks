package com.examprep1.battleships.controllers;
import com.examprep1.battleships.binding.LoginForm;
import com.examprep1.battleships.binding.RegisterForm;
import com.examprep1.battleships.services.user.UserServiceImpl;
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
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @ModelAttribute("registerForm")
    public RegisterForm getRegisterFormDto() {
        return new RegisterForm();
    }

    @ModelAttribute("loginForm")
    public LoginForm getLoginFormDto() {
        return new LoginForm();
    }

    @ModelAttribute("badCredentials")
    public boolean getCredentials() {
        return false;
    }


    @GetMapping("/login")
    public String getLogin() {
        if(this.userService.hasLoggedUsed()){
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginForm loginForm,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginForm", loginForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", bindingResult);
            return "redirect:login";
        }

        this.userService.loginUser(loginForm);

        if(!this.userService.hasLoggedUsed()) {
            redirectAttributes.addFlashAttribute("loginForm", loginForm);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:login";
        }

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String getRegister() {
        if(this.userService.hasLoggedUsed()){
            return "redirect:/home";
        }
        return "register";
    }

    @GetMapping("/logout")
    public String logoutUser() {
        this.userService.logout();
        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegisterForm registerForm,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        boolean doPasswordsMatch = registerForm.password.equals(registerForm.rePassword);

        if (bindingResult.hasErrors() || !doPasswordsMatch) {
            redirectAttributes.addFlashAttribute("registerForm", registerForm);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerForm", bindingResult);
            return "redirect:register";
        }

        this.userService.registerUser(registerForm);
        return "redirect:login";
    }
}
