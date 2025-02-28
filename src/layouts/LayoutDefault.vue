<script setup lang="ts">

</script>

<template>
  <div class="layout">

    <nav class="nav">
      <p>Let's<br>Meet</p>
      <div class="nav-actions">
        <router-link to="/login"><div class="button">Login</div></router-link>
        <router-link to="/about"><div class="button">About</div></router-link>
      </div>
    </nav>

    <main class="main">
      <slot/>
    </main>

    <!--<footer class="footer">Blank footer</footer>-->

  </div>
</template>

<style scoped>

.layout
{
  display: flex;
  flex-direction: column;
}

nav {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  min-height: 5vw;
  border: 1px solid;
  border-radius: var(--radius);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
  padding: 0 3vw 0 2vw;
}

nav p {
  font-size: calc(var(--font-size) * 1.1);
  margin: 4px 0 4px 0;
}

.nav-actions {
  display: flex;
  flex-direction: row;
  gap: 1vw;
}


.main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

.button {
  color: var(--primary-color);
  text-align: center;
  align-content: center;
  width: 5vw;
  height: fit-content;

  min-width: 5vw;
  min-height: 4vh;
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


</style>
