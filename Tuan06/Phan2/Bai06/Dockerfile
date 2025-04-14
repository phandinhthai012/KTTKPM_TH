# Stage 1: Build Stage
FROM node:18 AS builder

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

# Nếu không cần build (ví dụ như Express backend) thì không cần RUN build
# RUN npm run build

# Stage 2: Run Stage
FROM node:18-alpine AS runner

WORKDIR /app

COPY --from=builder /app .

EXPOSE 3000

CMD ["npm", "start"]
