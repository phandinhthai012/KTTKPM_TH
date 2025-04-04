# Sử dụng node:18 làm base image
FROM node:18

# Tạo thư mục làm việc trong container
WORKDIR /app

# Sao chép file package.json vào container
COPY package.json .
# Cài đặt các package cần thiết
RUN npm install
# Sao chép toàn bộ mã nguồn vào container
COPY . .
# Mở cổng 3000
EXPOSE 3000
# Chạy ứng dụng
CMD ["npm", "start"]