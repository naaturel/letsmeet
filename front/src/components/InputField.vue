<script setup lang="ts">

let value;
const emit = defineEmits(['update:value']);

// Method to handle the update
const updateValue = (event : any) => {
  emit('update:value', event.target.value);
};

</script>

<template>
    <input class="input-field" :value="value" @input="updateValue" />
</template>

<style scoped>

input
{
  line-height: 100%;
  text-align: center;
  border-radius: var(--radius);
}

input:focus{
  transform: scale(1.05);

}

</style>
