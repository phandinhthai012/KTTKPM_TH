# Sử dụng image Python chính thức
FROM python:3.9

# Tạo thư mục làm việc trong container
WORKDIR /app

# Copy file vào container
COPY . .

# Cài đặt thư viện cần thiết
RUN pip install -r requirements.txt

# Chạy ứng dụng
CMD ["python", "app.py"]
