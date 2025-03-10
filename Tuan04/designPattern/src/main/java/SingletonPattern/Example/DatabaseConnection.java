package SingletonPattern.Example;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection(){
        System.out.println("kết nối đến CSDL");
    }
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public void connect() {
        System.out.println("Đang kết nối đến cơ sở dữ liệu...");
    }

    public static void main(String[] args) {
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.connect();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        if(connection == connection2){
            System.out.println("Cùng một kết nối");
        } else {
            System.out.println("Khác kết nối");
        }
    }
}
