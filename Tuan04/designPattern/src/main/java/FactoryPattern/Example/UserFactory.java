package FactoryPattern.Example;

public class UserFactory {
    public  static User getUser(String role, String userName, String email) {
        switch (role) {
            case "Admin":
                return new Admin(userName, email);
            case "Member":
                return new Member(userName, email);
            case "Guest":
                return new Guest(userName, email);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        User admin = UserFactory.getUser("Admin", "admin01", "admin01@example.com");
        User guest = UserFactory.getUser("Guest", "guest01", "guest01@example.com");
        User member = UserFactory.getUser("Member", "member01", "member01@gmail.com");

        System.out.println(admin.userName+"-role: "+admin.getRole());
        System.out.println(guest.userName+"-role: "+guest.getRole());
        System.out.println(member.userName+"-role: "+member.getRole());
    }
}
