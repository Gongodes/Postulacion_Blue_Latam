<template>
  <div class="container">
    <ul>
    <li v-for="(item , index) in contactos" :key="index">
      {{contactos}}
    </li>
    </ul>
  </div>
</template>

<script>
  export default {
    async asyncData({ $axios }) {

      const contactos = await $axios.$get('http://localhost:8085/api/contactos');
      return { contactos }
    }
  }
</script>
