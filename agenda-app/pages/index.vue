<template>
  <div class="container" style="padding: 10px">
    <form>
      <div class="row">
        <div class="col">
          <input
            type="text"
            class="form-control"
            v-model="form.nombre"
            placeholder="Nombre"
          />
        </div>
        <div class="col">
          <input
            type="text"
            class="form-control"
            v-model="form.numero"
            placeholder="Numero"
          />
        </div>
        <button class="btn btn-primary" v-on:click="submit()">Agregar</button>
      </div>
    </form>

    <h1>Agenda Telefonica</h1>
    <table name="tabla" class="table table-striped table-hover">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Telefono</th>
          <th>Borrar</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in contactos" :key="index">
          <td>{{ item.id }}</td>
          <td>{{ item.nombre }}</td>
          <td>{{ item.numero }}</td>
          <td>
            <button
              class="btn btn-primary"
              @click="borrar(item.id, index)"
            >
              Borrrar
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      form: {
        nombre: '',
        numero: ''
      }
    }
  },
  async asyncData ({ app }) {
    const contactos = await app.$axios.$get('http://localhost:8085/api/contactos')
    return { contactos }
  },
  methods: {
    submit () {
      axios.post('http://localhost:8085/api/contactos', this.form)
      this.$router.go()
    },

    borrar (id, index) {
      axios.delete('http://localhost:8085/api/contactos/' + id)
      this.$router.go()
    }
  }

}
</script>
