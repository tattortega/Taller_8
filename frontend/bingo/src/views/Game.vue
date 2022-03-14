<template>
  <div>
    <div>
      <section id="formulario_iniciar_sesion">
        <div class="jugadores">
          <h3>TABLERO DE BINGO</h3>
          <table>
            <tbody>
              <tr>
                <td>B</td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
                <td>6</td>
                <td>7</td>
                <td>8</td>
                <td>9</td>
                <td>10</td>
                <td>11</td>
                <td>12</td>
                <td>13</td>
                <td>14</td>
                <td>15</td>
              </tr>

              <tr>
                <td>I</td>
                <td>16</td>
                <td>17</td>
                <td>18</td>
                <td>19</td>
                <td>20</td>
                <td>21</td>
                <td>22</td>
                <td>23</td>
                <td>24</td>
                <td>25</td>
                <td>26</td>
                <td>27</td>
                <td>28</td>
                <td>29</td>
                <td>30</td>
              </tr>

              <tr>
                <td>N</td>
                <td>31</td>
                <td>32</td>
                <td>33</td>
                <td>34</td>
                <td>35</td>
                <td>36</td>
                <td>37</td>
                <td>38</td>
                <td>39</td>
                <td>40</td>
                <td>41</td>
                <td>42</td>
                <td>43</td>
                <td>44</td>
                <td>45</td>
              </tr>

              <tr>
                <td>G</td>
                <td>46</td>
                <td>47</td>
                <td>48</td>
                <td>49</td>
                <td>50</td>
                <td>51</td>
                <td>52</td>
                <td>53</td>
                <td>54</td>
                <td>55</td>
                <td>56</td>
                <td>57</td>
                <td>58</td>
                <td>59</td>
                <td>60</td>
              </tr>

              <tr>
                <td>O</td>
                <td>61</td>
                <td>62</td>
                <td>63</td>
                <td>64</td>
                <td>65</td>
                <td>66</td>
                <td>67</td>
                <td>68</td>
                <td>69</td>
                <td>70</td>
                <td>71</td>
                <td>72</td>
                <td>73</td>
                <td>74</td>
                <td>75</td>
              </tr>
            </tbody>
          </table>
          <button>Número elegido</button>
        </div>
        <hr />
        <div class="jugadores">
          <h3>LISTA DE JUGADORES</h3>
          <thead>
            <tr>
              Usuario
            </tr>
          </thead>
          <tbody>
            <tr v-for="player in players" v-bind:key="player">
              {{
                player.playerName
              }}
            </tr>
          </tbody>
        </div>
        <hr />
        <div class="jugadores">
          <h3>TARJETA DE BINGO</h3>
          <table>
            <tbody>
              <tr>
                <td>B</td>
                <td>I</td>
                <td>N</td>
                <td>G</td>
                <td>O</td>
              </tr>

              <tr>
                <td>4</td>
                <td>8</td>
                <td>17</td>
                <td>10</td>
                <td>13</td>
              </tr>

              <tr>
                <td>18</td>
                <td>29</td>
                <td>24</td>
                <td>19</td>
                <td>22</td>
              </tr>

              <tr>
                <td>33</td>
                <td>44</td>
                <td>40</td>
                <td>38</td>
                <td>36</td>
              </tr>

              <tr>
                <td>48</td>
                <td>52</td>
                <td>55</td>
                <td>60</td>
                <td>53</td>
              </tr>

              <tr>
                <td>63</td>
                <td>68</td>
                <td>72</td>
                <td>70</td>
                <td>66</td>
              </tr>
            </tbody>
          </table>
          <button>GANÉ</button>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import api from "@/logic/api";
//
// function getIdPlayer() {
//   const urlSearchParams = new URLSearchParams(window.location.search);
//   const id = urlSearchParams.get("id");
//   console.log(id);
//   return id;
// }

export default {
  name: "Game",
  data: () => ({
    players: {
      playerName: "",
    },
  }),
  methods: {
    async mounted() {
      await this.getPlayers();
    },
    async getPlayers() {
      try {
        const result = await api.getPlayer("player/:31");
        const player = result.data;
        console.log(player);
        this.players = {
          playerName: player.playerName,
        };
      } catch (err) {
        console.log(err);
      }
    },
  },
};
</script>

<style scoped>
body {
  background: linear-gradient(to bottom right, #4f0d828a, #fffffd8c);
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
  margin-right: 1.5em;
  margin-left: 1.5em;
}

h3 {
  margin-bottom: 1em;
}

hr {
  border-color: black;
}
table {
  margin: 50px auto;
  font-size: 24px;
}

table,
tr,
td,
th {
  border: 3px solid black;
  border-collapse: collapse;
  empty-cell: hide;
  caption-side: bottom;
}

td {
  padding: 5px;
}
* {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
}

body {
  background-color: rgb(36, 36, 36);
}

button {
  background-color: #28b85182;
  border: none;
  border-radius: 15px;
  padding: 5px;
  margin-bottom: 5px;
  margin-left: 5px;
  font-size: 30px;
  cursor: pointer;
}
</style>
