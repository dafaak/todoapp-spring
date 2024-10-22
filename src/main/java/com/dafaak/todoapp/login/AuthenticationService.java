package com.dafaak.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticateUser(String userName, String password) {
        boolean isValidUser = userName.equals("Israel");
        boolean isValidPass = password.equals("12345");
        return isValidUser && isValidPass;
    }
}
