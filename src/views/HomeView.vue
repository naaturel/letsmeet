<script setup lang="ts">

</script>

<template>

  <div class="container">
    <div class="introduction">
      <h1>Welcome !</h1>
      <p>This website is currently under development and might look ugly as fuck</p>
    </div>

    <div class="actions">
      <router-link to="/create"><div class="button">Create an event</div></router-link>
      <router-link to="/join"><div class="button">Join an event</div></router-link>
    </div>
  </div>

</template>

<style scoped>

.container {
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  height: 100%;
}

.introduction {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 75%;
  height: 100%;
}

.actions {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 4vh;
  height: 100%;
  width: 25%;
  border-left: var(--radius);
  background-color: var(--bruh-color);
  box-shadow: -3px 0 3px var(--tertiary-color);
}

.button {
  text-align: center;
  align-content: center;
  min-width: 10vw;
  min-height: 5vh;
  border-radius: var(--radius);
  background-color: var(--secondary-color);
}

.button:hover
{
  background-color: rgba(255, 255, 255, 0.8);
}

</style>
