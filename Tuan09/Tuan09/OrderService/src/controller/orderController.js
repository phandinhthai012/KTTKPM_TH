const Order = require("../model/orderModel");
const { route, use } = require("../router/orderRouter");
const axios = require('axios');

const createOrder = async (req, res) => {
    try {
        const { productId, quantity, customerId, totalPrice, status } = req.body;
        console.log("Request body:", req.body);
        const newOrder = new Order({ productId, quantity, customerId, totalPrice, status });
        await newOrder.save();
        res.status(201).json({ message: "Order created successfully", newOrder });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const getAllOrders = async (req, res) => {
    try {
        const orders = await Order.find();
        console.log("All orders:", orders);
        res.status(200).json({ message: "Get all orders successfully", orders });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}


const getOrderById = async (req, res) => {
    try {
        const order = await Order.findById(req.params.id);
        if (!order) {
            return res.status(404).json({ message: "Order not found" });
        }
        res.status(200).json({ message: "Get order successfully", order });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const getOrdersByCustomerId = async (req, res) => {
    try {
        const { customerId } = req.params;
        const orders = await Order.find({ customerId: customerId });

        if (!orders || orders.length === 0) {
            return res.status(404).json({ message: "Orders not found" });
        }
        res.status(200).json({
            message: "Get orders successfully",
            orders: orders
        });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const updateOrders = async (req, res) => {
    try {
        const { productId, quantity, customerId, totalPrice, status } = req.body;
        const updatedOrder = await Order.findByIdAndUpdate(
            req.params.id,
            { productId, quantity, customerId, totalPrice, status },
            { new: true }
        );

        if (!updatedOrder) {
            return res.status(404).json({ message: "Order not found" });
        }
        res.status(200).json({ message: "Order updated successfully", updatedOrder });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

const getUserInfo = async (req, res) => {
    try {
        const { userId } = req.params;
        customRespone = await axios.get(`http://customer-service:3001/customer/${userId}`);
        console.log("User info:", customRespone.data);
        const order = await Order.find({customerId: userId});
        if (!order) {
            return res.status(404).json({ message: "Order not found" });
        }
        res.status(200).json({ message: "Get order successfully", userInfo: customRespone.data, order });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
}

module.exports = {
    createOrder,
    getAllOrders,
    getOrderById,
    getOrdersByCustomerId,
    updateOrders,
    getUserInfo
};