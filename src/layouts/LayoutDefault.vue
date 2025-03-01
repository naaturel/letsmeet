<script setup lang="ts">

import NavLink from "@/components/NavLink.vue";
</script>

<template>
  <div class="layout">

    <nav class="nav">
      <p>Let's<br>Meet</p>
      <div class="nav-actions">
        <NavLink path="/" description="Home"></NavLink>
        <NavLink path="/login" description="Log in"></NavLink>
        <NavLink path="/about" description="About"></NavLink>
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
  min-height: 10vh;
  border: 1px solid;
  border-radius: var(--radius);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
  padding: 0 3vw 0 2vw;
  margin-bottom: 20px;
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

::v-deep(nav .button) {
  font-size: calc(var(--font-size) * 0.8);
  background-color: var(--header-color);
  border: solid 2px ;
  height: fit-content;
}

@media screen and (min-width: 951px) {

  ::v-deep(nav .button) {
    width: 5vw;

    min-width: 5vw;
    min-height: 4vh;
  }
}

@media screen and (max-width: 950px) {

  ::v-deep(nav .button) {
    width: 7vw;

    min-width: 60px;
    min-height: 3vh;
  }
}

.main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

</style>
