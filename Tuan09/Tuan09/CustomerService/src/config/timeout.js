const axios = require('axios');


function timeoutPromise(promise, ms) {
  const timeout = new Promise((_, reject) =>
    setTimeout(() => reject(new Error(`Timeout after ${ms}ms`)), ms)
  );

  return Promise.race([promise, timeout]);
}

async function fetchOrdersWithTimeout(customerId, ms = 3000) {
  const request = axios.get(`http://order-service:3002/order/customer/${customerId}`);
  return await timeoutPromise(request, ms);
}

exports.fetchOrdersWithTimeout = fetchOrdersWithTimeout;
exports.timeoutPromise = timeoutPromise;