package src;

import java.util.regex.*;

public class Person {

    public boolean checkUser(String username) {
        if (username == null) return false;
        return username.length() >= 8 && username.matches("^[a-zA-Z0-9]+$");
    }

    public boolean checkPassword(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*[0-9].*")) return false;
        if (!password.matches(".*[^a-zA-Z0-9].*")) return false;
        return true;
    }
}
