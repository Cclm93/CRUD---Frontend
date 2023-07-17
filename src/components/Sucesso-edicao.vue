<template>
    <div class="box">
        <div class="boxmensagem">
           <h1>Usuário editado com sucesso</h1>
        </div>
         <div class="boxbotao">
            <button class="backbutton" @click="back()">Voltar </button>
         </div>
   </div>
</template>
  
  <script>
  export default {

    methods:{
      back(){
        this.$emit('voltaredit', "true")
      }
    }
  }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  .box{
    display:flex;
    flex-direction: column;
    height: 400px;
    width: 1905px;
    justify-content: center;
  }
  .boxmensagem{
    display:flex;
    height: 300px;
    width: 1500px;
    margin-top: 100px;
    margin-left: 202px ;
    background-color: lightskyblue;
    justify-content: center;
  }

  h1{
    margin-top: 100px;
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  .boxbotao{
    display: flex;
    justify-content: center;
  }
  .backbutton {
  margin-left: 10px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  margin-top: 10px;
  background-color:lightsalmon;
}
</style>
  