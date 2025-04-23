const Bottleneck = require("bottleneck");

// Tạo một instance của Bottleneck
const limiter = new Bottleneck({
  maxConcurrent: 1,  // Số lượng yêu cầu đồng thời tối đa
  minTime: 500       // Thời gian tối thiểu giữa các yêu cầu
});

// Hàm thực hiện hành động
async function someService() {
  console.log("Service called");
  return "Success";
}

// Áp dụng Rate Limiter
module.exports = async () => {
  await limiter.schedule(() => someService())
    .then(response => console.log(response))
    .catch(error => console.log('Error:', error));
};
