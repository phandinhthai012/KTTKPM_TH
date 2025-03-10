package FactoryPattern.Example;

public class Admin extends User{
    public Admin(String userName, String email) {
        super(userName, email);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
