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
          <thead>
            <tr>
              <th></th>
              <th>LISTA DE JUGADORES</th>
            </tr>
          </thead>
          <hr />
          <tbody>
            <tr v-for="player in players" v-bind:key="player">
              <td>*</td>
              <td>{{ player.playerName }}</td>
              <button v-if="render" @click="enter(player)">INGRESAR</button>
            </tr>
          </tbody>
        </div>
        <hr />
        <div class="contador">
          <p>El juego comienza en:</p>
          <div class="cont-temporizador">
            <countdown :time="5 * 1000" @progress="startGame">
              <template slot-scope="props">
                <div class="bloque">
                  <div class="minutos" id="minutos">
                    {{ props.minutes }} minutos
                  </div>
                  <div class="segundos" id="segundos">
                    {{ props.seconds }} segundos
                  </div>
                </div></template
              >
            </countdown>
          </div>
        </div>
      </section>
    </div>
  </main>
</template>

<script>
import api from "../logic/api";
import NavLobby from "../components/Lobby";

export default {
  name: "Lobby",
  components: {
    NavLobby,
  },
  data: function () {
    return {
      players: [],
      render: false,
    };
  },
  methods: {
    startGame(data) {
      if (data.minutes === 0 && data.seconds === 1) {
        this.render = true;
      }
    },
    async enter(player) {
      await api.updatePlayer(`player/${player.playerId}`, {
        playerName: player.playerName,
        playerStatus: true,
        gameId: 1,
        cardId: 1,
      });
      await api.createGame("game", {
        gameId: 1,
        gameStatus: true,
        created_at: Date.now(),
      });
      window.location.href = "/Game/id?id=" + player.playerId;
    },
    async getPlayers() {
      const data = await api.getPlayers("players");
      this.players = data.data.data;
    },
  },
  mounted() {
    this.getPlayers();
  },
};
</script>

<style scoped>
body {
  background: linear-gradient(to bottom right, #4f0d828a, #fffffd8c);
}

#description {
  border-radius: 6px;
  border: black solid;
  padding: 1em;
  margin: 2em;
  margin-bottom: 3em;
  margin-left: 1em;
  margin-right: 17.5em;
  background-color: rgb(23 110 110);
}
#formulario_iniciar_sesion {
  border-radius: 6px;
  border: black solid;
  padding: 1em;
  margin: 1em;
  display: flex;
  text-align: center;
  background-color: rgb(23 110 110);
}

.jugadores {
  margin-right: 15em;
}
.contador {
  margin-left: 7em;
}

h3 {
  margin-bottom: 1em;
}

hr {
  border-color: black;
  margin-top: 5px;
  margin-bottom: 5px;
}

* {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
}

body {
  background-color: rgb(36, 36, 36);
}

.cont-temporizador {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.cont-temporizador .bloque {
  margin: 0px 4px;
  display: flex;
  align-items: center;
}

.cont-temporizador .bloque div {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(80, 80, 80);
  box-shadow: 0px 0px 6px 2px #727272 inset;
  color: #ffffff;
  font-weight: bold;
  width: 100px;
  height: 70px;
  margin-bottom: 10px;
  margin-right: 5px;
  border-radius: 5px;
}

.cont-temporizador .bloque p {
  font-size: 11px;
  font-weight: bold;
  color: #d6d6d6;
}

button {
  background-color: #28b85182;
  border: none;
  border-radius: 5px;
  padding: 5px;
  margin-bottom: 5px;
  margin-left: 5px;
  font-size: 20px;
  cursor: pointer;
}
</style>
