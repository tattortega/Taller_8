<template>
  <nav class="MenuWrap">
    <div class="menu-item">
      <div class="ListItem">Inicio</div>
    </div>
    <div>
      <div class="ListItem3">
        <p>La empresa El Gran Buda es una casa de juegos de apuestas y azar.</p>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavLogin",
};
</script>

<style>
.MenuWrap {
  background-color: #a68dc5;
  border: solid;
  font-family: "Oswald", sans-serif;
  font-size: 1rem;
  display: flex;
  flex-direction: row-reverse;
  align-items: center;
}

.menu-item {
  border-left: solid;
  padding: 0.5em;
}

.ListItem {
  text-decoration: none;
  margin-right: 1rem;
}

.ListItem3 {
  margin-right: 10em;
}

p {
  margin-top: 0.5em;
}
</style>
