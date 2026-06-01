public class AuthService {

    public boolean register(User user) {
        Database.users.add(user);
        return true;
    }

    public User login(String email, String password) {
        for (User u : Database.users) {
            if (u.email.equals(email) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}