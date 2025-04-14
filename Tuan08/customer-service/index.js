const express = require('express');
const app = express();
require('dotenv').config();
const PORT = process.env.DB_PORT || 5001;

console.log('Database Name:', process.env.MONGODB_DB);
console.log('Database Port:', process.env.DB_PORT);
// kêt nối cơ sở dữ liệu MongoDB

const connectDB = require('./src/config/db');
connectDB()
  .then(() => {
    console.log('Connected to MongoDB successfully!');
  })
  .catch((error) => {
    console.error('Error connecting to MongoDB:', error);
  });

// Middleware
app.use(express.json());

// Routes
const router = require('./src/router/customerRoute');
app.use('/api/customers', router);
// Khởi động máy chủ
app.get('/', (req, res) => {
  res.send('Customer Service API is running...');
});
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});