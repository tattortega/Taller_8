import axios from "axios";

const API = "http://localhost:4000";

export default {
  //Metodo registrarse
  create(subdir, object) {
    const ax = `${API}/${subdir}`;
    return axios.post(ax, object);
  },

  //Metodo validar login
  getUser(subdir) {
    const ax = `${API}/users/user/${subdir}`;
    return axios.get(ax);
  },

  getLogin(data) {
    const ax = `${API}/login/`;
    return axios.post(ax, data);
  },

  getEmail(subdir) {
    const ax = `${API}/user/email/${subdir}`;
    return axios.get(ax);
  },

  //Metodo ingresar registros soporte
  login(subdir, object) {
    const ax1 = `${API}/${subdir}`;
    return axios.post(ax1, object);
  },

  //Metodo consultar datos biologicos
  getAll(subdir) {
    const ax = `${API}/${subdir}`;
    return axios.get(ax);
  },
};
