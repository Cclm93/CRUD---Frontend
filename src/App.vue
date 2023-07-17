<template>
      <Topopagina/>
</template>

<script>
import Topopagina from './components/Topo-pagina.vue';

export default {
 
  components:{
      Topopagina,  
   },

  }
</script>

<style scoped>

.boxvertical {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  width: 1905px;
  height: 1900px;
  background-color: lightslategray;
}
</style>
