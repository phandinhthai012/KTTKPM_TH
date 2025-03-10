package FactoryPattern.Example;

public abstract class User {
    protected String userName;
    protected String email;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public abstract String getRole();
}
