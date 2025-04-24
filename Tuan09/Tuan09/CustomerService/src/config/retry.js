const axios = require('axios');
const retry = require('async-retry');

async function fetchOrdersWithRetry(customerId) {
  return await retry(async (bail, attempt) => {
    try {
      console.log(`[Retry] Attempt ${attempt} for customer ID: ${customerId}`);
      const res = await axios.get(`http://order-service:3002/order/customer/${customerId}`);
      return res.data;
    } catch (err) {
      if (err.response && err.response.status === 404) {
        // Nếu lỗi 404 thì không nên retry nữa
        bail(new Error('Order not found, do not retry.'));
        return;
      }
      throw err; // Các lỗi khác sẽ tự retry
    }
  }, {
    retries: 3,           // Thử lại tối đa 3 lần
    minTimeout: 1000,     // Thời gian delay lần 1
    maxTimeout: 3000,     // Thời gian delay tối đa giữa các lần retry
    factor: 2             // Tăng dần thời gian delay (1s -> 2s -> 4s)
  });
}

exports.fetchOrdersWithRetry = fetchOrdersWithRetry;
exports.retry = retry;

// 1 lần đầu + 3 lần retry = 4 lần tổng cộng