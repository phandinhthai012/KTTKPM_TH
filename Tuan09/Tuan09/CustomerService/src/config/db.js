const mongoose = require('mongoose');
const dotenv = require('dotenv');
dotenv.config();

const connectDB = async () => {
    try {
        const dbURI = process.env.MONGODB_URI || 'mongodb://localhost:27017/Customerdb';
        await mongoose.connect(dbURI);
        console.log('MongoDB connected successfully');
    } catch (error) {
        console.error('MongoDB connection failed', error.message);
        process.exit(1);
    }
};

module.exports = connectDB;