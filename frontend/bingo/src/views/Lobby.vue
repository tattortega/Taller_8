<template>
  <main>
    <NavLobby />
    <div id="description">
      <div>
        A continuacion se encuentran los jugadores en lista de espera para
        iniciar el bingo
      </div>
    </div>

    <div>
      <section id="formulario_iniciar_sesion">
        <div class="jugadores">
          <h3>LISTA DE JUGADORES</h3>
          <thead>
            <tr>
              <th>Usuario</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="contact in contacts" v-bind:key="contact">
              <td>{{ contact.id }}</td>
            </tr>
          </tbody>
        </div>
        <hr />
        <div class="contador">
          <p>El juego comienza en:</p>
          <p>
            <span id="minutes"></span> minutos /
            <span id="seconds"></span> segundos
          </p>
        </div>
      </section>
    </div>
  </main>
</template>

<script>
// import api from "../logic/api";
import NavLobby from "@/components/Lobby";

export default {
  name: "Lobby",
  components: {
    NavLobby,
  },

  data: function () {
    return {
      info: [],
      render: false,
    };
  },
  methods: {},
};
</script>

<style scoped>
body {
  background: linear-gradient(to bottom right, #4f0d828a, #fffffd8c);
}

#description {
  border-radius: 6px;
  border: rgba(35, 0, 130, 0.452) solid;
  border-color: indigo;
  padding: 1em;
  margin: 2em;
  margin-bottom: 3em;
  margin-left: 1em;
  margin-right: 17.5em;
  background-color: rgb(166 141 197);
}
#formulario_iniciar_sesion {
  border-radius: 6px;
  border: rgba(35, 0, 130, 0.452) solid;
  border-color: indigo;
  padding: 1em;
  margin: 1em;
  display: flex;
  text-align: center;
  background-color: rgb(166 141 197);
}

.jugadores {
  margin-right: 15em;
}
.contador {
  margin-left: 10em;
}
</style>
