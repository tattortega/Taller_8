/**
 * Archivo donde se encuentran las rutas del API
 *
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @version 1.0.0
 * @since 10/03/2022
 *
 */


/**
 * Modulos de dependencias
 */
const {Router} = require('express');
const router = Router();
const UserCtrl= require('../controller/user.controller');

/**
 * Rutas del CRUD
 */
router.get('/', UserCtrl.index);
router.post('/user', UserCtrl.create);
router.post('/login', UserCtrl.login);
router.get('/users', UserCtrl.list);
router.get('/user/:_id', UserCtrl.listId);
router.get('/user/name/:name', UserCtrl.searchName);
router.get('/user/lastname/:lastname', UserCtrl.searchLastname);
router.get('/user/email/:email', UserCtrl.searchEmail);
router.get('/users/user/:user', UserCtrl.searchUser);
router.put('/user/:id', UserCtrl.update);
router.delete('/user/:id',UserCtrl.delete);


module.exports = router;