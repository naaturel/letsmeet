<script setup lang="ts">

</script>

<template>
  <div class="layout">

    <nav class="nav">
      <p>Let's<br>Meet</p>
      <router-link to="/about"><div>About</div></router-link>
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
  justify-content: space-between;
  min-height: 4vw;
  border: 1px solid;
  border-radius: var(--radius);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
  padding: 0 1vw 0 1vw;
}

nav p {
  font-size: calc(var(--font-size) * 1.1);
  margin: 4px 0 4px 0;
}

.main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

</style>
