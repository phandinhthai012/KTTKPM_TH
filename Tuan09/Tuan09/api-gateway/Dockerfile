# 1. Chọn image chính để build app — ở đây dùng Node.js phiên bản 18
FROM node:18

# 2. Tạo thư mục làm việc trong container
WORKDIR /app

# 3. Copy 2 file package.json và package-lock.json để cài đặt dependencies trước
COPY package*.json ./

# 4. Cài đặt toàn bộ dependencies (node_modules) trong container
RUN npm install

# 5. Copy toàn bộ mã nguồn từ máy vào container (bao gồm index.js, .env, v.v.)
COPY . .

# 6. Mở port 8080 ra để máy host có thể truy cập vào service
EXPOSE 8080

# 7. Câu lệnh để chạy ứng dụng — ở đây là node index.js
CMD ["node", "index.js"]