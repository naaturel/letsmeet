<script setup lang="ts">

</script>

<template>

  <div class="container">
    <div class="introduction">
      <h1>Welcome !</h1>
      <p>This website is currently under <span class="colored-text">development</span> and might look ugly as fuck</p>
    </div>

      <div class="actions">
        <h1>Meet up now !</h1>
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
  gap: 10vw;
}

.introduction, .actions {
  flex-direction: column;
}

.introduction {
  word-break: break-word;
  width: 50%;
  min-height: 40vh;
  height: fit-content;

  border-radius: var(--radius);
  border-left: solid 4px;
  background: rgb(239, 239, 239);
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
  justify-content: start;
  width: 25%;
  gap: 4vh;
  min-height: 40vh;
  height: fit-content;
  border-radius: var(--radius);
  filter: drop-shadow(0px 0px 0px rgba(0, 0, 0, 0.0));
}

.button {
  color: var(--primary-color);
  text-align: center;
  align-content: center;
  width: 15vw;
  height: fit-content;

  min-width: 15vw;
  min-height: 7vh;
  border-radius: var(--radius);
  background-color: var(--secondary-color);
  word-break: break-word;
}

.button:hover
{
  transform: scale(1.1);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
}


.actions::before,
.actions::after {
  content: "";
  position: absolute;
  width: 5%;
  height: 15%;
  border: 4px solid black;
}

.actions::before {
  top: 0;
  left: 0;
  border-radius: var(--radius);
  border-right: none;
  border-bottom: none;
}

.actions::after {
  bottom: 0;
  right: 0;
  border-radius: var(--radius);
  border-left: none;
  border-top: none;
}

</style>
