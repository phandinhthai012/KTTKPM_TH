package FactoryPattern.Example;

public class Guest extends User{
    public Guest(String userName, String email) {
        super(userName, email);
    }

    @Override
    public String getRole() {
        return "Guest";
    }
}
