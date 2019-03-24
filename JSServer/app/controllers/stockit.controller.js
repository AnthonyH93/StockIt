const Stockit = require('../models/stockit.model.js');

exports.addaisle = (req, res) => {
    if(!req.body.product || !req.body.aisle || !req.body.state) {
        return res.status(400).send({
            message: "Entry can not have empty columns"
        });
    }

    const stockit = new Stockit({
		aisle: req.body.aisle,
		product: req.body.product,
		state: req.body.state
    });

    stockit.save()
    .then(data => {
        res.send(data);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while creating this entry."
        });
    });
};

exports.retrieve = (req, res) => {
	Stockit.find()
    .then(stocks => {
        res.send(stocks);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while retrieving entries."
        });
    });
};

exports.checkStatus = (req, res) => {
	Stockit.findByIdAndUpdate(req.params.aislenum, {
        aisle: req.body.aisle,
		product: req.body.product,
		state: req.body.state
    }, {new: true})
    .then(stockit => {
        if(!stockit) {
            return res.status(404).send({
                message: "Entry not found with id number " + req.params.aislenum
            });            
        }
        res.send(stockit);
    }).catch(err => {
        if(err.kind === 'ObjectId') {
            return res.status(404).send({
                message: "Entry not found with id number " + req.params.aislenum
            });                
        }
        return res.status(500).send({
            message: "Error retrieving entry with id number " + req.params.aislenum
        });
    });
};

exports.update = (req, res) => {
    if(!req.body.product || !req.body.aisle || !req.body.state) {
        return res.status(400).send({
            message: "Entry can not have empty columns"
        });
    }
		
    Stockit.findByIdAndUpdate(req.params.aislenum, {
        aisle: req.body.aisle,
		product: req.body.product,
		state: req.body.state
    }, {new: true})
    .then(stockit => {
        if(!stockit) {
            return res.status(404).send({
                message: "Entry not found with id number " + req.params.aislenum
            });
        }
        res.send(stockit);
    }).catch(err => {
        if(err.kind === 'ObjectId') {
            return res.status(404).send({
                message: "Entry not found with id number" + req.params.aislenum
            });                
        }
        return res.status(500).send({
            message: "Error updating entry with id number " + req.params.aislenum
        });
    });
};

exports.delete = (req, res) => {
	Stockit.findByIdAndRemove(req.params.aislenum)
    .then(stockit => {
        if(!stockit) {
            return res.status(404).send({
                message: "Entry not found with id number " + req.params.aislenum
            });
        }
        res.send({message: "Entry deleted successfully!"});
    }).catch(err => {
        if(err.kind === 'ObjectId' || err.name === 'NotFound') {
            return res.status(404).send({
                message: "Entry not found with id number " + req.params.aislenum
            });                
        }
        return res.status(500).send({
            message: "Could not delete entry with id number " + req.params.aislenum
        });
    });
};