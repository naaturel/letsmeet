<script setup lang="ts">

let value;
const emit = defineEmits(['update:value']);

const props = defineProps({
  placeholder: {
    type: [String],
    required: false
  }
});

const updateValue = (event : any) => {
  emit('update:value', event.target.value);
};

</script>

<template>
    <input :placeholder="placeholder" class="input-field" :value="value" @input="updateValue" />
</template>

<style scoped>

input
{
  line-height: 100%;
  text-align: center;
  border: solid 2px black;
  border-radius: var(--radius);
}

input:focus{
  transform: scale(1.05);

}

</style>
