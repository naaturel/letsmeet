<script setup lang="ts">

import TextBlock from "@/components/TextBlock.vue";
import Button from "@/components/Button.vue";
import InputField from "@/components/InputField.vue";
</script>

<template>

  <div class="container">
    <TextBlock>
      <h1>Join an <span class="colored-text">event</span></h1>
    </TextBlock>

    <div class="actions-group">
      <h1>Event <span class="colored-text">code</span></h1>
      <InputField/>
      <Button description="Go for it !"/>
    </div>

  </div>

</template>

<style scoped>

.text-block, .actions-group {
  min-width: 300px;
}


.actions-group {
  min-height: 250px;
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

.input-field {
  letter-spacing: 10px;
  font-size: calc(0.4 * 75px);
}

.input-field, .button {
  height: 75px;
  min-height: 75px;
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

  .button, .input-field
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
    font-size: 2.5rem;
    margin: 0 5px 5px 5px;
  }

  .button, .input-field
  {
    width: 70%;
  }

}
</style>
