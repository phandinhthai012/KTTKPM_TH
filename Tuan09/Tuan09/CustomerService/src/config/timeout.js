const timeout = require('promise-timeout');

// Hàm config timeout
async function withTimeout(promise, ms) {
  try {
    const result = await timeout(promise, ms);
    return result;
  } catch (error) {
    console.log('Timeout error:', error);
    throw error;  // Bạn có thể ném lại lỗi để xử lý ở nơi khác
  }
}

// Xuất hàm config timeout
module.exports = {
  withTimeout
};




// const { breaker } = require('../config/circuitBreaker');
// const retry = require('../config/retry');
// const timeout = require('../config/timeout');
// const rateLimiter = require('../config/rateLimiter');

// // Hàm thực hiện các hành động với các cơ chế đã cấu hình
// async function handleServiceRequest() {
//   try {
//     // Áp dụng Retry
//     await retry();

//     // Áp dụng Time Limiter
//     await timeout();

//     // Áp dụng Rate Limiter
//     await rateLimiter();

//     // Áp dụng Circuit Breaker
//     await breaker.fire()
//       .then(response => console.log(response))
//       .catch(error => console.log('Circuit Breaker failed:', error));

//   } catch (error) {
//     console.error('Error during service request:', error);
//   }
// }

// module.exports = { handleServiceRequest };
