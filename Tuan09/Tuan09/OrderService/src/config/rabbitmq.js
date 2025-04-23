const amqp = require('amqplib');

let channel;
let connection;

async function connectRabbitMQ() {
  try {
    // Kết nối tới RabbitMQ (tên service là rabbitmq trong Docker)
    connection = await amqp.connect('amqp://rabbitmq');
    channel = await connection.createChannel();

    const queue = 'customer_created';
    await channel.assertQueue(queue, { durable: true });

    console.log(`👂 Waiting for messages in queue: ${queue}`);
    
    channel.consume(queue, (msg) => {
      if (msg !== null) {
        const data = JSON.parse(msg.content.toString());
        console.log('📥 Received from customer_created:', data);
        // xử lý logic ở đây

        // Xác nhận đã xử lý thông điệp
        channel.ack(msg);
      }
    });

    // Xử lý khi kết nối hoặc kênh bị mất
    connection.on('close', () => {
      console.log('❌ RabbitMQ connection closed');
      process.exit(1); // Thoát chương trình hoặc bạn có thể thử lại kết nối
    });

    // Nếu có lỗi trong kênh
    channel.on('error', (err) => {
      console.error('❌ Channel error:', err);
    });

  } catch (error) {
    console.error('❌ Error connecting to RabbitMQ:', error);
    // Tự động thử lại sau 5 giây nếu gặp lỗi
    setTimeout(connectRabbitMQ, 5000);
  }
}

module.exports = { connectRabbitMQ };
