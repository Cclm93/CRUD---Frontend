<template>
    
  <div>
    <button @click="save()">salvar</button>
    <p>o id que chegou foi :{{ this.iddouser }}</p>
    <h1>Perfil de {{ this.nome }}</h1>
    
      <divvertical class="boxvertical">
        <divpessoal class="sessaopessoal">
          
          <adiv>
            <label for="Nome">Nome:</label>
            <p>{{ this.userparaver['nome'] }}</p>
           
          </adiv>

          <adiv>
            <label for="estcivil">Estado civil:</label>
            <p>{{this.userparaver['estadocivil']}}</p>
          </adiv>

          <adiv>
            <label for="Nacionalidade">Nacionalidade:</label>
            <p>{{ this.userparaver['nacionalidade']}}</p>
          </adiv>

          <adiv>
            <label for="Sexo">Sexo:</label>
            <p>{{ this.userparaver['sexo']}}</p>
          </adiv>

          <adiv>
            <label for="nasc">Data de nascimento:</label>
            <p>{{this.userparaver['nasc'] }}</p>
          </adiv>

          <adiv>
            <label for="Ocupacao">Ocupaçao:</label>
            <p>{{ this.userparaver['ocupacao']}}</p>
          </adiv>
        </divpessoal>

        <divendereco class="sessaoendereco">
          <adiv>
            <label for="Rua">Rua:</label>
            <p>{{ this.userparaver['rua'] }}</p>
          </adiv>

          <adiv>
            <label for="Numero">Número:</label>
            <p>{{this.userparaver['numero'] }}</p>
          </adiv>

          <adiv>
            <label for="Complemento">Complemento:</label>
            <p>{{  this.userparaver['complemento'] }}</p>
          </adiv>

          <adiv>
            <label for="Bairro">Bairro:</label>
            <p>{{ this.userparaver['bairro'] }}</p>
          </adiv>

          <adiv>
            <label for="Cidade">Cidade:</label>
            <p>{{ this.userparaver['cidade'] }}</p>
          </adiv>

          <adiv>
            <label for="Estado">Estado:</label>
            <p>{{ this.userparaver['estado'] }}</p>
          </adiv>

          <adiv>
            <label for="CEP">CEP:</label>
            <p>{{ this.userparaver['cep'] }}</p>
          </adiv>
        </divendereco>

        <divcontato class="sessaocontato">
          <adiv>
            <label for="Email">Email:</label>
            <p>{{ this.userparaver['email'] }}</p>
          </adiv>

          <adiv>
            <label for="Telefone">Telefone:</label>
            <p>{{ this.userparaver['telefone']}}</p>
          </adiv>
        
        </divcontato>
    </divvertical>
   
  </div>

</template>
  
<script>

//import UsuarioRemovido from 'C:/Users/caio.monte/Documents/GitHub/CRUD/src/components/Usuario-removido2';
export default {

  props : ['userparaver'], 
 
  methods: {

    voltadelete(retorno){
      if(retorno == "true"){
        this.$emit('voltapageuser', 'true')
      }
    },
  }
}

</script>   
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h1{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.boxvertical {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  width: 1905px;
  height: auto;
  background-color: black;
}
.sessaopessoal {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin-bottom: 1px;
  height: 80px;
  width: 1905px;
  background-color: lightblue;
}
.sessaoendereco {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin-bottom: 1px;
  height: 130px;
  width: 1905px;
  background-color: lightsalmon;
}
.sessaocontato {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin-bottom: 0px;
  height: 60px;
  width: 1905px;
  background-color: lightgreen;
}
</style>
  