package com.example.demo.form;

import javax.validation.constraints.NotEmpty;

public class LoginForm {
    @NotEmpty
    private String id;
    @NotEmpty
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
