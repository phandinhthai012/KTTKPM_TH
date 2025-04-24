const express = require('express');
const router = express.Router();
const customerController = require("../controller/customerContronller")

router.post('/', customerController.createCustomer);
router.get('/getAllCustomers', customerController.getAllCustomers);
router.get('/:id', customerController.getCustomerById);
router.put('/:id', customerController.updateCustomer);
router.delete('/:id', customerController.deleteCustomer);
router.get('/order/:customerId', customerController.getOderByCustomerId);
router.get('/retry/:id', customerController.getCustomerOrdersRetry);
router.get('/timeout/:id', customerController.getCustomerOrdersTimeLimiter);

module.exports = router;