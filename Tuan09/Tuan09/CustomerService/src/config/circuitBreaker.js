// npm install opossum async-retry timeout-as-promised bottleneck

const CircuitBreaker = require('opossum');

// Hàm thực hiện hành động, ví dụ gọi API
async function someService() {
  return "Service Response"; // Giả lập hành động
}

// Cấu hình Circuit Breaker
const options = {
  timeout: 5000, // Thời gian tối đa để chờ phản hồi
  errorThresholdPercentage: 50, // Tỷ lệ lỗi trước khi Circuit Breaker mở
  resetTimeout: 30000, // Thời gian chờ trước khi thử lại
};

const breaker = new CircuitBreaker(someService, options);

module.exports = { breaker };
