<template>
  <nav class="MenuWrap">
    <div class="menu-item" v-if="logueado" @click="cerrarsesion">
      <router-link class="ListItem" to="/">Cerrar sesión</router-link>
    </div>
  </nav>
</template>

<script>
export default {
  name:"Game",
}
</script>

<style>

.MenuWrap {
  background-color: indigo;
  font-family: 'Oswald', sans-serif;
  font-size: 1rem;
  display: flex;
  flex-direction: row-reverse;
  align-items: center;
}

.menu-item{
  border-left: #ebebeb solid;
  padding: 0.5em;
}

.ListItem,
.LastItem {
  color: #ebebeb;
  text-decoration: none;
}
.ListItem {
  margin-right: 1rem;
}
.LastItem {
  margin-right: auto;
}

/*Sombrear de amarillo las opciones de nav (barra de menús)*/
a:hover{
  color: rgb(226, 238, 55);
}
</style>