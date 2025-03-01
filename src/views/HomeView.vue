<script setup lang="ts">

import NavLink from "@/components/NavLink.vue";
import TextBlock from "@/components/TextBlock.vue";
</script>

<template>

  <div class="container">
    <TextBlock class="introduction">
      <h1>Welcome !</h1>
      <p>
        This website is currently under <span class="colored-text">development</span> and might look ugly as fuck
        bla bla bla I'm just writting things nobody will read to fill the space and see how it looks.
      </p>
      <p>
        Yes I know i could have use
        a Lorem Ipsum but it seems more natural with words everyone can understand
      </p>
      </TextBlock>

      <div class="actions-group">
        <h1>Meet up <span class="colored-text">now</span> !</h1>
        <NavLink path="/create" description="Create"></NavLink>
        <NavLink path="/join" description="Join"></NavLink>
    </div>
  </div>

</template>


<style scoped>

.container, .actions-group {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  padding: 0 1vw 0 1vw;
}

.container {
  width: 80%;
  gap: 10vw;
}

.introduction p
{
  width: 80%;
  text-align: justify;
}

.actions-group {
  flex-direction: column;
  padding: 30px;
  min-width: 250px;
}

.actions-group {
  justify-content: center;
  gap: 4vh;
  height: fit-content;
  border-radius: var(--radius);
  filter: drop-shadow(0px 0px 0px rgba(0, 0, 0, 0.0));
  margin-bottom: 5vh;
}

.actions-group h1
{
  margin-top: 0;
}

.actions-group::before,
.actions-group::after {
  content: "";
  position: absolute;
  width: 5%;
  height: 15%;
  border: 4px solid black;
}

.actions-group::before {
  top: 0;
  left: 0;
  border-radius: var(--radius);
  border-right: none;
  border-bottom: none;
}

.actions-group::after {
  bottom: 0;
  right: 0;
  border-radius: var(--radius);
  border-left: none;
  border-top: none;
}

/* MEDIA QUERIES */
@media screen and (min-width: 1500px) {
  .container {
    flex-direction: row;
  }

  .introduction {
    width: 50%;
    min-height: 40vh;
  }

  .actions-group {
    width: 25%;
    min-height: 35vh;
  }

  .introduction h1
  {
    font-size: 4rem;
  }
}

@media screen and (max-width: 1501px) {
  .container {
    flex-direction: column;
  }

  .introduction, .actions-group {
    width: 95%;
  }

  .introduction {
    min-height: 25vh;
  }

  .actions-group {
    min-height: 40vh;
  }

  .introduction h1
  {
    font-size: 3rem;
  }
}

</style>
