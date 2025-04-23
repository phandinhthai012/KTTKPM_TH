const amqp = require('amqplib');

let channel;
let connection;
let retryCount = 0;
const MAX_RETRIES = 10; // Giới hạn số lần thử lại

async function connectRabbitMQ() {
  try {
    connection = await amqp.connect('amqp://rabbitmq');  // rabbitmq là tên service trong docker-compose
    channel = await connection.createChannel();
    console.log('✅ Connected to RabbitMQ');
    retryCount = 0;  // Đặt lại retryCount khi kết nối thành công
  } catch (error) {
    console.error('❌ Error connecting to RabbitMQ:', error);
    
    // Tăng retryCount và thử lại nếu chưa đạt số lần tối đa
    if (retryCount < MAX_RETRIES) {
      retryCount++;
      console.log(`Retrying to connect to RabbitMQ... Attempt ${retryCount}/${MAX_RETRIES}`);
      setTimeout(connectRabbitMQ, 5000);  // Thử lại sau 5 giây
    } else {
      console.error('❌ Max retry attempts reached. Could not connect to RabbitMQ.');
    }
  }
}

function sendToQueue(queue, message) {
  if (!channel) {
    console.error('❌ RabbitMQ not connected');
    return;
  }
  channel.assertQueue(queue, { durable: true });
  channel.sendToQueue(queue, Buffer.from(JSON.stringify(message)));
  console.log(`📨 Sent to queue [${queue}]:`, message);
}

module.exports = { connectRabbitMQ, sendToQueue };
