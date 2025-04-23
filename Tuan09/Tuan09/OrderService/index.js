const express = require('express');
const app = express();
const { connectRabbitMQ } = require('./src/config/rabbitmq');
require('dotenv').config();
const PORT = process.env.PORT || 3002;

console.log('Database Name:', process.env.MONGODB_DB);
console.log('Database Port:', process.env.PORT);

// Kết nối cơ sở dữ liệu MongoDB
const connectDB = require('./src/config/db');

connectDB()
  .then(() => {
    console.log('✅ Connected to MongoDB successfully!');

    // Sau khi kết nối MongoDB thành công, chúng ta mới khởi động server
    app.listen(PORT, () => {
      console.log(`Server is running on port ${PORT}`);
    });

    // Kết nối RabbitMQ sau khi MongoDB đã sẵn sàng
    connectRabbitMQ()
      .then(() => {
        console.log('✅ Connected to RabbitMQ successfully!');
      })
      .catch((error) => {
        console.error('❌ Error connecting to RabbitMQ:', error);
      });

  })
  .catch((error) => {
    console.error('❌ Error connecting to MongoDB:', error);
  });

// Middleware
app.use(express.json());

// Routes
const router = require('./src/router/orderRouter');
app.use('/order', router);

// Khởi động máy chủ
app.get('/', (req, res) => {
  res.send('Order Service is running...');
});
