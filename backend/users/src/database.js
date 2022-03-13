/**
 * Archivo donde se encuentran la configuracion a la base de datos MongoDB
 *
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @version 1.0.0
 * @since 10/03/2022
 *
 */

const mongoose = require('mongoose');
URI = ('mongodb://localhost:27017/bingo');

/**
 * Conexion por medio de mongoose
 */
mongoose.connect(URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(db => console.log('Estoy conectado a la bd:', db.connection.name))
    .catch(error => console.log(error))


module.exports = mongoose;
