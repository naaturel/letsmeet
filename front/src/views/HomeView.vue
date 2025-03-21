<script setup lang="ts">

import NavLink from "@/components/NavLink.vue";
import TextBlock from "@/components/TextBlock.vue";
</script>

<template>

  <div class="container">
    <TextBlock class="text-block">
      <h1>Welcome !</h1>
      <p>
        This website is currently under <span class="colored-text">development</span> and might look ugly as fuck
        bla bla bla I'm just writing things nobody will read to fill the space and see how it looks.
      </p>
      <p>
        Yes I know i could have use
        a Lorem Ipsum but it seems more natural with words everyone can understand
      </p>
      </TextBlock>

      <div class="actions-group">
        <h1>Meet up <span class="colored-text">now</span> !</h1>
        <NavLink name="create" description="Create"></NavLink>
        <NavLink name="join" description="Join"></NavLink>
    </div>
  </div>

</template>

<style scoped>

.text-block, .actions-group {
  min-width: 300px;
  min-height: 250px;
}

.text-block p
{
  text-align: justify;
}

.actions-group h1
{
  margin-top: 0;
}

.actions-group {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 4vh;
  height: fit-content;
  border-radius: var(--radius);
  filter: drop-shadow(0px 0px 0px rgba(0, 0, 0, 0.0));
}

.actions-group::before,
.actions-group::after {
  content: "";
  position: absolute;
  width: 50px;
  height: 50px;
  border: 4px solid black;
}

.actions-group::before {
  top: -20px;
  left: 0;
  border-radius: var(--radius);
  border-right: none;
  border-bottom: none;
}

.actions-group::after {
  bottom: -20px;
  right: 0;
  border-radius: var(--radius);
  border-left: none;
  border-top: none;
}

.nav-link {
  height: 70px;
  min-height: 70px;
}

/* MEDIA QUERIES */
@media screen and (min-width: 1001px) {

  .actions-group {
    width: 35%;
  }

  .text-block p
  {
    width: 90%;
    margin-bottom: 0;
  }

  .text-block h1
  {
    font-size: 4rem;
    margin: 0 5px 5px 5px;
  }

  .nav-link
  {
    width: 50%;
  }

}

@media screen and (max-width: 1000px) {

  .text-block, .actions-group {
    width: 100%;
  }

  .actions-group {
    height: 40%;
  }

  .text-block p
  {
    width: 95%;
    margin-bottom: 0;
  }

  .text-block h1
  {
    font-size: 2rem;
    margin: 0 5px 5px 5px;
  }

  .nav-link
  {
    width: 70%;
  }
}

</style>
