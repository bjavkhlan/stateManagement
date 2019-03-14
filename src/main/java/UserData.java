public class UserData {
    private User[] users;
    public UserData() {
        final int NUM_USER = 3;
        users = new User[NUM_USER];
        users[0] = new User("jagaa", "1234");
        users[1] = new User("admin", "admin");
        users[2] = new User("test", "test");
    }

    public User getUser(String username) {
        for (User user: users)
            if (user.getUsername().equals(username)) return user;

        return null;
    }
}
