/**
 * Archivo donde se encuentran la raiz de la aplicacion
 *
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @version 1.0.0
 * @since 10/03/2022
 *
 */


/**
 * Modulos de dependencias
 */
const express = require('express');
const app = express();
const morgan = require('morgan');
const cors = require('cors');
const bodyparser = require('body-parser');
require('./database');

/**
 * Uso del cors
 */
app.use(cors({origen: '*'}));

/**
 * Middlewares
 */
app.use(morgan('dev'));
app.use(bodyparser.urlencoded({extended: true}));
app.use(bodyparser.json());

/**
 * Ruta
 */
app.use(require('./route/user.route'));

/**
 * Puerto del servidor
 */
app.set('Port', 4000);
app.listen(app.get('Port'), () => {
    console.log('Servidor corriendo y escuchando por el puerto', app.get('Port'));
});