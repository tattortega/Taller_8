import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login.vue";
import Lobby from "../views/Lobby";
import Game from "../views/Game.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/Lobby",
    name: "Lobby",
    component: Lobby,
  },

  {
    path: "/Game",
    name: "Game",
    component: Game,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
