/**
 * Archivo donde se encuentra el esquema de la base de datos
 *
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @version 1.0.0
 * @since 10/03/2022
 *
 */


/**
 * Modulos de dependencias
 */
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/**
 * Esquema de la coleccion usuario
 *
 */
const UserSchema = new Schema({
    name: {type: String, required: [true, 'Campo obligatorio']},
    lastname: {type: String, required: [true, 'Campo obligatorio']},
    email: {type: String, required: [true, 'Campo obligatorio']},
    user: {type: String, required: [true, 'Campo obligatorio']},
    password: {type: String, required: [true, 'Campo obligatorio']},
    created_at: {type: Date, default: Date.now}
});


/**
 * Conversion del esquema al modelo en mongoose
 * @type {Model<any>}
 */
module.exports = mongoose.model('user', UserSchema);
