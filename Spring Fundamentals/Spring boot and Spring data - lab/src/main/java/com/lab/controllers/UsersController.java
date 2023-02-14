package com.lab.controllers;

import com.lab.models.RegistrationForm;
import com.lab.services.interfaces.UserRegistrationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UsersController {
    private final String FORM_DATA = "formData";
    private final String ERROR_DATA = "formErrors";



    private final UserRegistrationService userRegistrationService;
    private final RegistrationForm registrationForm;

    @Autowired
    public UsersController(UserRegistrationService userRegistrationService,
                           RegistrationForm registrationForm) {
        this.userRegistrationService = userRegistrationService;
        this.registrationForm = registrationForm;


    }

    @GetMapping("/register")
    public String getRegister(Model model, HttpSession httpSession) {
        httpSession.setAttribute(FORM_DATA, this.registrationForm);
        this.registrationForm.setRoles(this.userRegistrationService.getUserRoles());

        model.addAttribute(FORM_DATA, httpSession.getAttribute(FORM_DATA));
        model.addAttribute(ERROR_DATA, httpSession.getAttribute(ERROR_DATA));
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegistrationForm registrationForm,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
//        this.userRegistrationService.registerUser(registrationForm);

//        if (bindingResult.hasErrors()) {
//            httpSession.setAttribute(ERROR_DATA, bindingResult);
//            return "auth-register";
//        }

        return "auth-login";
    }

}
