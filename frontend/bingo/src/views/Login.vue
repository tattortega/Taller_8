<template>
  <div>
    <NavLogin />
    <main class="login">
      <div id="description">
        <div>
          Para entrar al bingo inicie sesion con su usuario y contraseña. Si no
          tiene una cuenta, registrese.
        </div>
      </div>
      <section id="form_login">
        <FormulateForm action="/" class="login-form" v-model="formValues">
          <div>
            <h2>INICIAR SESIÓN</h2>
          </div>
          <hr />
          <div class="camp">
            <FormulateInput
              type="text"
              size="30"
              id="player"
              name="usuario"
              placeholder="Usuario"
              class="input"
              validation="required"
              v-on:input="player = $event.target.value"
            />
          </div>
          <div class="camp">
            <FormulateInput
              type="password"
              size="30"
              id="password"
              name="contraseña"
              placeholder="Contraseña"
              class="input"
              validation="required"
              v-on:input="password = $event.target.value"
            />
          </div>
          <div class="ubicar">
            <button id="button" @click="login"><b>Ingresar</b></button>
            <a id="button2" href="#modal"><label>Regístrate </label></a>
          </div>
        </FormulateForm>
      </section>

      <!--Formulario de Registro-->
      <aside id="modal" class="modal">
        <div class="container">
          <header class="header">
            <a href="#" class="close-modal">X</a>
            <h1>REGISTRATE</h1>
          </header>
          <hr />
          <div>
            <p>
              <strong>Ingrese los siguientes datos para registrarse</strong>
            </p>
          </div>
          <section>
            <FormulateForm action="/" class="login-form" v-model="formValues">
              <div class="formulario">
                <div class="camp">
                  <FormulateInput
                    type="text"
                    size="30"
                    id="name"
                    name="nombre"
                    placeholder="Digite su nombre"
                    class="input"
                    validation="required"
                  />
                </div>
                <div class="camp">
                  <FormulateInput
                    type="text"
                    size="30"
                    id="lastname"
                    name="apellido"
                    placeholder="Digite su apellido"
                    class="input"
                    validation="required"
                  />
                </div>
                <div class="camp">
                  <FormulateInput
                    type="email"
                    size="30"
                    id="email"
                    name="correo electrónico"
                    placeholder="Digite su email"
                    class="input"
                    validation="required|email"
                  />
                </div>
                <div class="camp">
                  <FormulateInput
                    type="text"
                    size="30"
                    id="user2"
                    name="usuario "
                    placeholder="Digite su usuario"
                    class="input"
                    validation="required"
                  />
                </div>
                <div class="camp">
                  <FormulateInput
                    type="password"
                    size="30"
                    id="password2"
                    name="contraseña "
                    placeholder="Digite su contraseña"
                    class="input"
                    validation="required"
                  />
                </div>
                <div class="camp">
                  <input
                    type="submit"
                    id="boton-cuenta"
                    @click="create"
                    value="Crear cuenta"
                  />
                </div>
              </div>
            </FormulateForm>
          </section>
        </div>
      </aside>
    </main>
  </div>
</template>

<script>
import api from "@/logic/api.js";
import NavLogin from "../components/Login";

export default {
  name: "Login",
  components: {
    NavLogin,
  },
  data: function () {
    return {
      formValues: {},
      player: "",
      password: "",
    };
  },
  methods: {
    //API
    async create() {
      const name = document.getElementById("name").value;
      const lastname = document.getElementById("lastname").value;
      const email = document.getElementById("email").value;
      const player = document.getElementById("user2").value;
      const password = document.getElementById("password2").value;
      const emailRegex =
        /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

      if (
        name === "" ||
        lastname === "" ||
        email === "" ||
        player === "" ||
        password === ""
      ) {
        alert("Completa todos los campos para registrarse");
      }
      const emailRepetead = await api.getEmail(email);
      console.log(emailRepetead);

      const userRepetead = await api.getUser(player);
      console.log(userRepetead);

      let message = "Diligencie los siguientes datos:\n";

      if (name.length < 3) {
        alert(
          (message = message + "-Los nombres deben tener minimo 3 caracteres\n")
        );
      } else if (lastname.length < 3) {
        alert(
          (message =
            message + "-Los apellidos debe tener minimo 3 caracteres\n")
        );
      } else if (
        emailRepetead.data[0] != undefined &&
        emailRepetead.data[0].email == email
      ) {
        alert((message = message + "-Este correo ya ha sido registrado\n"));
      } else if (!emailRegex.test(email)) {
        alert("Por favor introduzca un correo electrónico válido.");
      } else if (player.length < 5) {
        alert(
          (message = message + "-El usuario debe tener minimo 5 caracteres\n")
        );
      } else if (
        userRepetead.data[0] != undefined &&
        userRepetead.data[0].player == player
      ) {
        alert((message = message + "-Este usuario ya ha sido registrado\n"));
      } else if (password.length < 5) {
        alert(
          (message =
            message + "-La contraseña debe tener minimo 5 caracteres\n")
        );
      } else {
        await api.create("player", {
          name: name,
          lastname: lastname,
          email: email,
          player: player,
          password: password,
        });
        alert("Registro exitoso");
        window.location = "http://localhost:3000/";
      }
    },
    async login() {
      const player = document.getElementById("player").value;
      const password = document.getElementById("password").value;
      let message = "Diligencie los siguientes datos:\n";
      if (player === "" || password === "") {
        alert("Completa todos los campos para iniciar sesion");
      } else {
        try {
          const userValidate = await api.getLogin({
            player: player,
            password: password,
          });
          console.log(userValidate);
          if (userValidate.data.message) {
            alert(
              (message = message + "-El usuario no se encuentra registrado\n")
            );
          } else if (userValidate.data.message2) {
            alert((message = message + "-La contraseña es incorrecta\n"));
          } else {
            alert("Bienvenido a El Gran Buda");
            window.location = "http://localhost:3000/Lobby";
          }
        } catch (error) {
          console.log(error);
        }
      }
    },
  },
};
</script>

<style>
body {
  background-image: url("../assets/bingo3.webp");
  background-repeat: no-repeat;
  background-size: cover;
}

hr {
  margin: 0.4em;
}
.login {
  display: flex;
  flex-direction: column; /*Mostrar el diseño sin esto*/
  align-items: center;
  padding: 1em;
  padding-bottom: 5em;
}

#description {
  border-radius: 6px;
  border: black solid;
  padding: 1em;
  margin: 1em;
  background-color: rgb(23 110 110);
}

#form_login {
  border-radius: 6px;
  border: black solid;
  padding: 1em;
  margin: 1em;
  text-align: center;
  background-color: rgb(23 110 110);
}

.input {
  padding: 8px;
  font-size: 0.8em;
  font-weight: 500;
  padding-right: 2em;
  color: indigo;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
.input {
  padding: 0.1em;
  margin-top: 0.4em;
  font-size: 1em;
  size: 30;
  color: indigo;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

#br a:hover {
  color: rgb(226, 238, 55);
}

.descripcion {
  text-align: justify;
}

#button {
  background-color: #28b85182;
  border: none;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  margin: 4px 30px;
  cursor: pointer;
  border-radius: 1em;
  width: 150px;
}

#button2 {
  background-color: rgb(130 210 151 / 86%);
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 1em;
}

#button b {
  color: black;
}

#button2 label {
  color: black;
  font-weight: bold;
  cursor: pointer;
}

.ubicar {
  text-align: center;
  margin-top: 40px;
}

.formulate-input-label {
  font-size: 0.6em;
}

.formulate-input-group-item {
  border: 1px solid rgba(0, 0, 0, 0.1);
  border-radius: 0.5em;
  padding: 0.5em;
  position: relative;
  display: block;
  padding-left: 20px;
  margin-bottom: 5px;
  cursor: pointer;
  font-size: 11px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  color: indigo;
  -webkit-player-select: none;
  -moz-player-select: none;
  -ms-player-select: none;
  player-select: none;
}

#button2 {
  transition: all 0.15s linear;
}

.modal {
  position: fixed;
  top: -100vh;
  left: 0;
  z-index: 99999999;
  background: rgba(0, 0, 0, 0.9);
  width: 900vw;
  height: 100vh;
  opacity: 0;
}

.modal .container {
  position: fixed;
  transition: top 0.35x ease;
  margin-left: 450px;
  background-color: rgb(23 110 110);
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  border-radius: 6px;
  padding: 1.2em;
  padding-bottom: 0;
  text-align: center;
}

.close-modal {
  color: black;
  position: absolute;
  top: 0.1em;
  right: 0.375em;
  margin: 0;
  padding: 5px;
  font-weight: bold;
  font-size: 1em;
  text-decoration: none;
  border-radius: 6px;
}

.header a:hover {
  background-color: rgba(35, 0, 130, 0.452);
}

.modal:target {
  opacity: 1;
  top: 0;
}

.modal .btn-close-modal {
  position: absolute;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 99999991;
}

.modal:target .container {
  top: 5px;
  transition: top 0.35s ease;
}

h1 {
  color: black;
  font-size: 1.5em;
  margin: 0;
}

p {
  color: indigo;
  margin-bottom: 0.5em;
  margin-top: 0;
}

.formulario {
  text-align: left;
  padding: 10px;
}

.formulate-input-error {
  font-size: 0.8em;
}

.camp {
  padding-top: 0.1em;
  text-align: center;
}

#boton-cuenta {
  background-color: #28b85182;
  border: none;
  border-radius: 0.8em;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
  font-weight: bold;
}

.formulate-input-errors {
  padding: 0;
  margin: 0;
}
</style>
