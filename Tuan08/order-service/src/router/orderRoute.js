const express = require('express');
const router = express.Router();

const orderController = require('../controller/orderController');

router.post('/', orderController.createOrder);
router.get('/getAllOrders', orderController.getAllOrders);
router.get('/:id', orderController.getOrderById);
router.put('/:id', orderController.updateOrder);
router.delete('/:id', orderController.deleteOrder);

module.exports = router;