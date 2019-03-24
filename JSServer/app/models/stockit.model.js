const mongoose = require('mongoose');

const StockSchema = mongoose.Schema({
    aisle: Number,
    product: String,
	state: String
}, {
    timestamps: true
});

module.exports = mongoose.model('Stock', StockSchema);