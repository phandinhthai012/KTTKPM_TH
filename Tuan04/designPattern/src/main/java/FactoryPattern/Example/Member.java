package FactoryPattern.Example;

public class Member extends User{
    public Member(String userName, String email) {
        super(userName, email);
    }

    @Override
    public String getRole() {
        return "Member";
    }
}
