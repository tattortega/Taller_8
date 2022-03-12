<template>
  <nav class="MenuWrap">
    <div class="menu-item">
      <div class="ListItem">Lobby</div>
    </div>
    <div>
      <div class="ListItem2"><p>B I E N V E N I D O</p></div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavLobby",
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

.ListItem2 {
  margin-right: 20em;
}

p {
  margin-top: 0.5em;
}
</style>
