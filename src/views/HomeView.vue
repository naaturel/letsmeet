<script setup lang="ts">

</script>

<template>

  <div class="container">
    <div class="introduction">
      <h1>Welcome !</h1>
      <p>This website is currently under <span class="colored-text">development</span> and might look ugly as fuck</p>
    </div>

      <div class="actions">
        <router-link to="/create"><div class="button">Create</div></router-link>
        <router-link to="/join"><div class="button">Join</div></router-link>
    </div>
  </div>

</template>

<style scoped>

.container, .introduction, .actions {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  padding: 0 1vw 0 1vw;
}

.container {
  flex-direction: row;
  width: 80%;
}

.introduction, .actions {
  flex-direction: column;
}

.introduction {
  word-break: break-word;
  width: 50%;
}

.introduction h1
{
  font-size: 4rem;
}

.introduction p
{
  width: 80%;
  text-align: center;
}

.colored-text
{
  color: var(--secondary-color);
}

.actions {
  width: 50%;
  gap: 4vh;
}

.button {
  color: var(--primary-color);
  text-align: center;
  align-content: center;
  width: 15vw;
  height: 7vh;

  min-width: 15vw;
  min-height: 7vh;
  border-radius: var(--radius);
  background-color: var(--secondary-color);
}

.button:hover
{
  transform: scale(1.1);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
}

</style>
