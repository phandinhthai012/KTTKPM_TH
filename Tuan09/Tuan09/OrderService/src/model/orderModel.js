
const mongoose = require('mongoose');

const orderSchema = new mongoose.Schema({
    productId: {
        type:String,
        required: true,
    },
    quantity: {
        type: Number,
        required: true,
    },
    customerId: {
        type:String,
        required: true,
    },
    status: {
        type: String,
        enum: ['pending', 'shipped', 'delivered', 'cancelled'],
        default: 'pending',
    },
    totalPrice: {
        type: Number,
        required: true,
    },
}, { timestamps: true });

const Order = mongoose.model('Order', orderSchema);

module.exports = Order;
