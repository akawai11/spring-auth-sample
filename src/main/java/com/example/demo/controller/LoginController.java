package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.UserRepository;
import com.example.demo.session.LoginSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginSession loginSession;

    @ModelAttribute
    public LoginForm getForm() {
        return new LoginForm();
    }

    @GetMapping
    public String index() {
        if (loginSession.enabled()) {
            return "redirect:complete";
        }
        return "login/index";
    }

    @PostMapping("doLogin")
    public String doLogin(@Validated LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            return "login/index";
        }
        User user = userRepository.getUser(loginForm.getId());
        if (!user.getPassword().equals(loginForm.getPassword())) {
            return "login/index";
        }
        loginSession.setId(user.getId());
        loginSession.setName(user.getName());
        return "redirect:complete";
    }

    @GetMapping("complete")
    public String complete() {
        return "login/complete";
    }
}
