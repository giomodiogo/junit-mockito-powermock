package com.giomodiogo.business;

import com.giomodiogo.exception.InvalidPasswordException;

import java.util.List;

public class LoginService {

    private boolean logged = false;

    public void login(){
        this.logged = true;
    }
    public void logout(){
        this.logged = false;
    }

    public boolean isLogged(){
        return this.logged;
    }

    public void validatesPassword(String password) throws InvalidPasswordException {
        if(password != null && password.trim().length() < 6){
            throw new InvalidPasswordException();
        }
    }
}
