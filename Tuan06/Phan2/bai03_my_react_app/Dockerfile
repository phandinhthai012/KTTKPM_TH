# Bước 1: Build Stage
FROM node:18-alpine AS build

# Thiết lập thư mục làm việc
WORKDIR /usr/src/app

# Copy file package.json và package-lock.json để cài đặt dependencies
COPY package*.json ./

# Cài đặt dependencies
RUN npm install

# Copy toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng React
RUN npm run build

# Bước 2: Run Stage
FROM node:18-alpine

# Thiết lập thư mục làm việc
WORKDIR /usr/src/app

# Cài đặt serve để phục vụ ứng dụng React
RUN npm install -g serve

# Copy build từ build stage
COPY --from=build /usr/src/app/build /usr/src/app/build

# Mở cổng 3000
EXPOSE 3000

# Chạy ứng dụng với serve
CMD ["serve", "-s", "build", "-l", "3000"]
