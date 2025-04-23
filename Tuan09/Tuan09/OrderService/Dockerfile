FROM node:18

WORKDIR /app

COPY package*.json ./

# Cài nodemon toàn cục nếu cần dùng (chỉ cho dev)
RUN npm install -g nodemon && npm install

COPY . .

EXPOSE 3002

# Chạy chế độ dev với nodemon
CMD ["npm", "run", "dev"]


# CMD ["npm", "start"]  // npm start sẽ gọi "node index.js"