import axios from "axios";

const apiUsers = "http://localhost:4000";
const apiBingo = "http://localhost:4001";

export default {
  createUser(subdir, object) {
    const ax = `${apiUsers}/${subdir}`;
    return axios.post(ax, object);
  },

  getUser(subdir) {
    const ax = `${apiUsers}/users/user/${subdir}`;
    return axios.get(ax);
  },

  getUsers(subdir) {
    const ax = `${apiUsers}/${subdir}`;
    return axios.get(ax);
  },

  getLogin(data) {
    const ax = `${apiUsers}/login/`;
    return axios.post(ax, data);
  },

  getEmail(subdir) {
    const ax = `${apiUsers}/user/email/${subdir}`;
    return axios.get(ax);
  },

  createPlayer(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.post(ax, object);
  },

  getPlayer(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  getPlayers(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  updatePlayer(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.put(ax, object);
  },

  deletePlayer(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.delete(ax);
  },

  createGame(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.post(ax, object);
  },

  getGame(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  getGames(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  updateGame(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.put(ax, object);
  },

  deleteGame(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.delete(ax);
  },

  createCard(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.post(ax, object);
  },

  getCard(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  getCards(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.get(ax);
  },

  updateCard(subdir, object) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.put(ax, object);
  },

  deleteCard(subdir) {
    const ax = `${apiBingo}/${subdir}`;
    return axios.delete(ax);
  },
};
