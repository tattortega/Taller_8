/**
 * Archivo donde se encuentra el controlador para los diferentes metodos
 *
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @version 1.0.0
 * @since 10/03/2022
 *
 */


/**
 * Modulos de dependencias
 */
const userCtrl = {};
const User = require('../model/user.model');
const bcrypt = require('bcryptjs');

/**
 * Ruta index
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.index = async (req, res) => {
    res.json({
        API: "Jugadores de Bingo"
    });
};


/**
 * Metodo para crear usuarios
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.create = async (req, res) => {
    try {
        const {name, lastname, email, user, password} = req.body
        const NewUser = new User({
            name,
            lastname,
            email,
            user,
            password,
        });
        const nameUser = await User.findOne({user: user});
        if (nameUser) {
            res.json({
                message: 'El usuario ya existe'
            })
        } else {
            NewUser.password = await bcrypt.hash(password, 10)
            await NewUser.save()
            res.json({
                message: 'Bienvenid@',
                id: NewUser._id,
                user: NewUser.user,
            });
        }
        ;
    } catch (error) {
        res.json({
            message: 'Error al crear el usuario'
        });
    }
    ;
};

/**
 * Metodo para validar usuarios
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.login = async (req, res) => {
    try {
        const {user, password} = req.body;
        const validateUser = await User.findOne({user: user});
        if (!validateUser) {
            return res.json({
                message: 'Usuario incorrecto'
            })
        }
        ;
        const match = await bcrypt.compare(password, validateUser.password);
        if (match) {
            res.json({
                user: validateUser.user,
                password: validateUser.password,
            });
        } else {
            res.json({
                message2: 'Contraseña incorrecta'
            })
        }
        console.log(validateUser);

    } catch (error) {
        res.json({
            message: 'Error al iniciar sesion'
        });
    }
    ;
};

/**
 * Metodo para listar todos los usuarios
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.list = async (req, res) => {
    try {
        const response = await User.find();
        res.json(response);
    } catch (error) {
        res.json({
            message: 'No se encuentran usuarios en la base de datos'
        });
    }
    ;
};

/**
 * Metodo para buscar un usuario por ID
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.listId = async (req, res) => {
    try {
        const id = req.params._id;
        const response = await User.findById({_id: id});
        res.json(response);
    } catch (error) {
        res.json({
            message: 'No se encuentra el usuario en la base de datos'
        });
    }
    ;
};

/**
 * Metodo para eliminar usuarios
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.delete = async (req, res) => {
    try {
        const id = req.params.id
        const response = await User.findByIdAndRemove({_id: id})
        if (response == null) {
            res.json({
                message: 'El usuario no se encuentra en la base de datos'
            })
        } else {
            res.json({
                message: 'Usuario eliminado'
            })
        }
        ;
    } catch (error) {
        res.json({
            message: 'El usuario no se encuentra en la base de datos'
        });
    }
    ;
};

/**
 * Metodo para actualizar usuarios
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.update = async (req, res) => {
    try {
        const userUpdated = {
            id: req.body._id,
            name: req.body.name,
            lastname: req.body.lastname,
            email: req.body.email,
            user: req.body.user,
            password: await bcrypt.hash(req.body.password, 10),
        }
        await User.findByIdAndUpdate({_id: req.params.id}, userUpdated)
        res.json({
            message: 'Usuario actualizado'
        })
    } catch (error) {
        res.json({
            mensaje: 'El usuario no se encuentra en la base de datos'
        })
    }
    ;
};


/**
 * Metodo para buscar por nombre
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.searchName = async (req, res) => {
    const name = req.params.name;
    try {
        const response = await User.find({name: name})
        if (response === '') {
            res.json({
                message: 'La busqueda no se encuentra en la base de datos'
            })
        } else {
            res.json(response)
        }
    } catch (error) {
        return res.status(400).json({
            message: 'Ocurrió un error',
            error
        })
    }
    ;
    ;
}

/**
 * Metodo para buscar por apellido
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.searchLastname = async (req, res) => {
    const lastname = req.params.lastname;
    try {
        const response = await User.find({lastname: lastname})
        if (response === '') {
            res.json({
                message: 'La busqueda no se encuentra en la base de datos'
            })
        } else {
            res.json(response)
        }
    } catch (error) {
        return res.status(400).json({
            message: 'Ocurrió un error',
            error
        })
    }
    ;
};

/**
 * Metodo para buscar por email
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.searchEmail = async (req, res) => {
    const email = req.params.email;
    try {
        const response = await User.find({email: email})
        if (response === '') {
            res.json({
                message: 'La busqueda no se encuentra en la base de datos'
            })
        } else {
            res.json(response)
        }
    } catch (error) {
        return res.status(400).json({
            message: 'Ocurrió un error',
            error
        })
    }
    ;
};

/**
 * Metodo para buscar por nombre del usuario
 * @param req Peticion
 * @param res Respuesta
 * @returns {Promise<void>}
 */
userCtrl.searchUser = async (req, res) => {
    const user = req.params.user;
    try {
        const response = await User.find({user: user})
        if (response === '') {
            res.json({
                message: 'La busqueda no se encuentra en la base de datos'
            })
        } else {
            res.json(response)
        }
    } catch (error) {
        return res.status(400).json({
            message: 'Ocurrió un error',
            error
        })
    }
    ;
};


module.exports = userCtrl;
