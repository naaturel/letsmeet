<script setup lang="ts">

</script>

<template>

  <div class="container">
    <div class="introduction">
      <h1>Welcome !</h1>
      <p>This website is currently under development and might look ugly as fuck</p>
    </div>

    <div class="actions">
      <div class="button"><router-link to="/create">Create an event</router-link></div>
      <div class="button"><router-link to="/join">Join an event</router-link></div>
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
  width: 70%;
  height: 100%;
  border: solid 1px;
}

.actions {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 4vh;
  height: 100%;
  width: 30%;
  border: solid 1px;
}

.button {
  text-align: center;
  align-content: center;
  min-width: 10vw;
  min-height: 5vh;
  border-radius: var(--radius);
  background-color: var(--secondary-color);
  box-shadow: 2px 2px 5px;
  border: solid 1px;

}

</style>
