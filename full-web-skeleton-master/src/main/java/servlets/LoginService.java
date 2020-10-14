package servlets;

public class LoginService {

    public boolean validateUser(String user, String pass) {
        return user.equalsIgnoreCase("admin") && pass.equals("Gruppe3");

    }
}

