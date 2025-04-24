const Customer = require('../model/customerModel')
const { breaker } = require('../config/circuitBreaker');
const { sendToQueue } = require('../config/rabbitmq');
const { fetchOrdersWithRetry } = require('../config/retry');
const { fetchOrdersWithTimeout } = require('../config/timeout');
const createCustomer = async (req, res) => {
    try {
        const { name, email, phone, address } = req.body;
        console.log("Request body:", req.body);
        const newCustomer = new Customer({ name, email, phone, address });
        await newCustomer.save();
        res.status(201).json(newCustomer);
        // Gửi thông báo đến RabbitMQ
        const message = {
            event: 'customer_created',
            data: newCustomer
        };
        sendToQueue('customer_queue', message);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}
const getAllCustomers = async (req, res) => {
    try {
        const customers = await Customer.find({});
        console.log("All customers:", customers);
        res.status(200).json({message: "Get all customers successfully", customers});
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}
const getCustomerById = async (req, res) => {
    try {
        const customer = await Customer.findById(req.params.id);
        if (!customer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.status(200).json({message: "Get customer successfully", customer});
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const updateCustomer = async (req, res) => {
    try {
        const { name, email, phone, address } = req.body;
        const customer = await Customer.findByIdAndUpdate(req.params.id, { name, email, phone, address }, { new: true });
        if (!customer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.status(200).json({message: "Update customer successfully", customer});
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}
const deleteCustomer = async (req, res) => {
    try {
        const customer = await Customer.findByIdAndDelete(req.params.id);
        if (!customer) {
            return res.status(404).json({ message: "Customer not found" });
        }
        res.status(204).json({ message: "Customer deleted successfully" });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const getOderByCustomerId = async (req, res) => {
    try {
        const { customerId } = req.params;
        const respone = await breaker.fire(customerId);
        if (!respone || respone.length === 0) {
            return res.status(404).json({ message: "Orders not found" });
        }
        res.status(200).json({
            message: "Get orders successfully",
            orders: respone
        });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const getCustomerOrdersRetry = async (req, res) => {
    const customerId = req.params.id;
  
    try {
      const orders = await fetchOrdersWithRetry(customerId);
      res.status(200).json({ customerId, orders });
    } catch (err) {
      res.status(500).json({ message: 'Failed to fetch orders with retry.', error: err.message });
    }
  };
  
const getCustomerOrdersTimeLimiter = async (req, res) => {
    const customerId = req.params.id;
  
    try {
      const orders = await fetchOrdersWithTimeout(customerId, 3000); // 3 giây timeout
      res.status(200).json({ customerId, orders });
    } catch (err) {
      res.status(500).json({ message: 'Failed to fetch orders with timeout.', error: err.message });
    }
  }

const customerController = {
    createCustomer,
    getAllCustomers,
    getCustomerById,
    updateCustomer,
    deleteCustomer,
    getOderByCustomerId,
    getCustomerOrdersRetry,
    getCustomerOrdersTimeLimiter
}
module.exports = customerController;