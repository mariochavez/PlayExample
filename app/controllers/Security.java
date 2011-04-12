package controllers;

import models.*;
import play.Logger;

public class Security extends Secure.Security {
    static boolean authenticate(String username, String password) {
        //return User.findByUsernameAndPassword(username, password) != null;
        return username.equals("test") & password.equals("password");
    }

    static boolean check(String profile) {
        return "admin".equals(profile);
    }
}
