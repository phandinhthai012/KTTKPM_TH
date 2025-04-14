const statusCodes = require('http-status-codes');
const Order = require('../model/order');

const createOrder = async (req, res) => {
    try{
        const { productId, quantity, customerId, status, totalPrice } = req.body;
        console.log("Request body:", req.body);
        const newOrder = new Order({ productId, quantity, customerId, status, totalPrice });
        await newOrder.save();
        res.status(statusCodes.CREATED).json({message: "Create order successfully", order: newOrder});
    }catch(error){
        res.status(statusCodes.INTERNAL_SERVER_ERROR).json({message: error.message});
    }
}
const getAllOrders = async (req, res) => {
    try{
        const orders = await Order.find({});
        console.log("All orders:", orders);
        res.status(statusCodes.OK).json({message: "Get all orders successfully", orders});
    }catch(error){
        res.status(statusCodes.INTERNAL_SERVER_ERROR).json({message: error.message});
    }
}
const getOrderById = async (req, res) => {
    try{
        const order = await Order.findById(req.params.id);
        if(!order){
            return res.status(statusCodes.NOT_FOUND).json({message: "Order not found"});
        }
        res.status(statusCodes.OK).json({message: "Get order successfully", order});
    }catch(error){
        res.status(statusCodes.INTERNAL_SERVER_ERROR).json({message: error.message});
    }
}

const updateOrder = async (req, res) => {
    try{
        const { productId, quantity, customerId, status, totalPrice } = req.body;
        const order = await Order.findByIdAndUpdate(req.params.id, { productId, quantity, customerId, status, totalPrice }, { new: true });
        if(!order){
            return res.status(statusCodes.NOT_FOUND).json({message: "Order not found"});
        }
        res.status(statusCodes.OK).json({message: "Update order successfully", order});
    }catch(error){
        res.status(statusCodes.INTERNAL_SERVER_ERROR).json({message: error.message});
    }
}
const deleteOrder = async (req, res) => {
    try{
        const order = await Order.findByIdAndDelete(req.params.id);
        if(!order){
            return res.status(statusCodes.NOT_FOUND).json({message: "Order not found"});
        }
        res.status(statusCodes.NO_CONTENT).json({message: "Order deleted successfully"});
    }catch(error){
        res.status(statusCodes.INTERNAL_SERVER_ERROR).json({message: error.message});
    }
}

const orderController = {
    createOrder,
    getAllOrders,
    getOrderById,
    updateOrder,
    deleteOrder
}
module.exports = orderController;