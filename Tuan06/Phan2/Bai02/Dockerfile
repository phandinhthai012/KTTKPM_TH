# Sử dụng python 3.9 làm base image
FROM python:3.9

# Tạo thư mục làm việc trong container
WORKDIR /app

# Sao chép file requirements.txt vào container
COPY requirements.txt .

# Cài đặt các thư viện cần thiết
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Mở cổng 5000
EXPOSE 5000

# Lệnh chạy ứng dụng Flask
CMD ["python", "app.py"]
