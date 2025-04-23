const express = require('express');
const app = express();

const CircuitBreaker = require('opossum');
const retry = require('async-retry');
const timeout = require('timeout-as-promised');
const Bottleneck = require('bottleneck');



require('dotenv').config();
const { connectRabbitMQ } = require('./src/config/rabbitmq');
const connectDB = require('./src/config/db');
const PORT = process.env.PORT || 3001;

console.log('Database Name:', process.env.MONGODB_DB);
console.log('Database Port:', process.env.PORT);

// Middleware
app.use(express.json());

// Routes
const router = require('./src/router/customerRouter');
app.use('/customer', router);

// Khởi động máy chủ
app.get('/', (req, res) => {
  res.send('Customer Service API is running...');
});

// Kết nối MongoDB trước khi khởi động server
connectDB()
  .then(() => {
    console.log('Connected to MongoDB successfully!');

    // Sau khi MongoDB kết nối thành công, khởi động server
    app.listen(PORT, () => {
      console.log(`Server is running on port ${PORT}`);
    });

    // Kết nối RabbitMQ sau khi MongoDB đã sẵn sàng
    connectRabbitMQ()
      .then(() => {
        console.log('Connected to RabbitMQ successfully!');
      })
      .catch((error) => {
        console.error('Error connecting to RabbitMQ:', error);
      });

  })
  .catch((error) => {
    console.error('Error connecting to MongoDB:', error);
  });
