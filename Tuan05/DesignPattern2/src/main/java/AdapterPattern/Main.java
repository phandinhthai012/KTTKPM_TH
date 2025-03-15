package AdapterPattern;
/**
 * Main class
 * target là interface yêu cầu dữ liệu là json
 * adaptee là lớp cũ (hiện tại) chỉ hỗ trọ dữ liệu xml
 * adapter là lớp chuyển đổi dữ liệu từ xml sang json
 * client sử dụng adapter để chuyển đổi dữ liệu từ xml sang json
 */
public class Main {
    public static void main(String[] args) {
        JSONAdapter adapter = new JSONAdapter(new XMLService());
        String json = "{name: 'John', age: 30}";
        String xml = adapter.processJSON(json);
        System.out.println("Main: " + xml);


    }
}
