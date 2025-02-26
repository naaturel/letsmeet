<script setup lang="ts">

</script>

<template>

  <div class="container">
    <div class="introduction">
      <h1>Welcome !</h1>
      <p>This website is currently under development and might look like ugly as fuck</p>
    </div>

    <div class="actions">
      <div>
        Join an event
      </div>

      <div>
        Create an event
      </div>
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
  justify-items: center;
  align-content: center;
  flex-grow: 10;
  height: 100%;
}

.actions {
  justify-items: center;
  flex-direction: column;
  align-content: center;
  flex-grow: 4;
  height: 100%;
  background-color: rgba(0,0,0,0.1);
}

</style>
