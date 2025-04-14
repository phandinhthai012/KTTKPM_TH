package main // Gói chính, bắt buộc để chạy chương trình

import (
	"fmt"       // Gói dùng để in dữ liệu ra output (ví dụ: in chuỗi)
	"net/http"  // Gói để xây dựng web server và xử lý các request HTTP
)

// Định nghĩa một hàm handler để xử lý các yêu cầu HTTP đến server
func handler(w http.ResponseWriter, r *http.Request) {
	// Ghi một chuỗi phản hồi về cho client (trình duyệt)
	fmt.Fprintf(w, "Hello from Go in Docker!")
}

// Hàm main là nơi chương trình bắt đầu chạy
func main() {
	// Gắn (route) đường dẫn "/" với hàm handler bên trên
	http.HandleFunc("/", handler)

	// Khởi động web server, lắng nghe ở cổng 8080
	// nil nghĩa là dùng DefaultServeMux (bộ định tuyến mặc định)
	http.ListenAndServe(":8080", nil)
}
// http://localhost:8080