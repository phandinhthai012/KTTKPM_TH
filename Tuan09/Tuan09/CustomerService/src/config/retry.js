const retry = require('async-retry');

// Hàm thực hiện hành động
async function someService() {
  throw new Error("Temporary error"); // Giả lập lỗi tạm thời
}

// Cấu hình Retry
module.exports = async () => {
  await retry(async () => {
    return await someService();
  }, {
    retries: 3,  // Số lần thử lại
    minTimeout: 1000,  // Thời gian chờ giữa các lần thử
    maxTimeout: 5000,  // Thời gian tối đa
  });
};
