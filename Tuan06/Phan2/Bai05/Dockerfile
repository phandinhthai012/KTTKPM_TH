# Giai đoạn 1: Build ứng dụng Go
FROM golang:1.21 AS builder

# Tạo thư mục làm việc trong container
WORKDIR /app

# Sao chép các file vào container
COPY go.mod ./
COPY go.sum ./
RUN go mod download

COPY . .

# Biên dịch ứng dụng Go (sinh ra file thực thi nhỏ hơn, chạy nhanh hơn)
RUN go build -o main .

# Giai đoạn 2: Tạo image nhẹ để chạy app
FROM alpine:latest

# Cài đặt thư viện cần thiết
RUN apk --no-cache add ca-certificates

# Tạo thư mục app
WORKDIR /root/

# Copy binary từ builder stage sang
COPY --from=builder /app/main .

# Mở cổng 8080
EXPOSE 8080

# Chạy ứng dụng
CMD ["./main"]
