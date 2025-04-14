const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');
const cors = require('cors');
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 8080;

app.use(cors());

// Proxy đến Customer Service
app.use('/api/customers', createProxyMiddleware({
  target: process.env.CUSTOMER_SERVICE_URL,
  changeOrigin: true,
}));

app.get('/', (req, res) => {
  res.send('API Gateway is running...');
});

app.listen(PORT, () => {
  console.log(`API Gateway listening on port ${PORT}`);
});
