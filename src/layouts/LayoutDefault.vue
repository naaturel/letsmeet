<script setup lang="ts">

</script>

<template>
  <div class="layoutDefault">

    <!--<nav class="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/error">Error</router-link>
    </nav>-->

    <main class="main">
      <slot/>
    </main>

    <!--<footer class="footer">Blank footer</footer>-->

  </div>
</template>

<style scoped>

nav {
  text-decoration: none;
  height: 2vw;
  border: 1px solid;
  border-radius: var(--radius);
}

.main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
}

</style>
