const express = require('express');
const router = express.Router();
const orderController = require("../controller/orderController")

// Route cho việc tạo đơn hàng
router.post('/', orderController.createOrder);

// Route lấy tất cả đơn hàng
router.get('/all', orderController.getAllOrders);

// Route lấy đơn hàng theo ID
router.get('/:id', orderController.getOrderById);

// Route lấy đơn hàng của một khách hàng theo customerId
router.get('/customer/:customerId', orderController.getOrdersByCustomerId);

// Route cập nhật đơn hàng
router.put('/:id', orderController.updateOrders);

//lấy userInfo và dơn hàn
router.get('/user/:userId', orderController.getUserInfo);

module.exports = router;