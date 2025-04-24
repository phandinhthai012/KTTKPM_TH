// npm install opossum axios

const CircuitBreaker = require('opossum');
const axios = require('axios');

// Hàm gọi API
async function fetchOrders(id) {
  const response = await axios.get(`http://order-service:3002/order/customer/${id}`);
  return response.data;
}

// Cấu hình circuit breaker
const options = {
  timeout: 5000, // 5 giây timeout
  errorThresholdPercentage: 50, // Nếu 50% request lỗi thì mở mạch
  resetTimeout: 30000 // Sau 30s sẽ thử lại
};

const breaker = new CircuitBreaker(fetchOrders, options);

// fallback khi breaker mở hoặc gọi lỗi
breaker.fallback((id) => {
  console.warn('[CircuitBreaker] Fallback triggered for customer ID:', id);
  return {
    message: 'Order service unavailable. Please try again later.',
    orders: []
  };
});

// Log sự kiện
breaker.on('open', () => {
  console.warn('[CircuitBreaker] Circuit breaker opened!');
});

breaker.on('close', () => {
  console.log('[CircuitBreaker] Circuit breaker closed!');
});

module.exports = { breaker };
