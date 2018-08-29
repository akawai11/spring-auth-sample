package com.example.demo.controller;

import com.example.demo.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @ModelAttribute
    public LoginForm getForm() {
        return new LoginForm();
    }

    @GetMapping
    public String index() {
        return "login/index";
    }
    @PostMapping("doLogin")
    public String doLogin(@Validated LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            return "login/index";
        }
        return "redirect:complete";
    }

    @GetMapping("complete")
    public String complete() {
        return "login/complete";
    }
}
