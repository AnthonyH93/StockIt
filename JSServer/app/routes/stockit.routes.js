module.exports = (app) => {
	const stockits = require('../controllers/stockit.controller.js');
	
	app.post('/stockits', stockits.addaisle);
	app.get('/stockits', stockits.retrieve);
	app.get('/stockits/:aislenum', stockits.checkStatus);
	app.post('/stockits/:aislenum', stockits.update);
	app.delete('/stockits/:aislenum', stockits.delete);
}