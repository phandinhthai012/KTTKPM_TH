# Sử dụng Node.js image từ Docker Hub
FROM node:16

# Đặt thư mục làm việc
WORKDIR /usr/src/app

# Sao chép các tệp package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các dependency
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Mở cổng 3000
EXPOSE 3000

# Chạy ứng dụng
CMD ["node", "app.js"]
