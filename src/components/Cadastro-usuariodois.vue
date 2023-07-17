<template>
  <div>
  <div class="hello">
    <h1>Cadastro de Usuário</h1>
    <form>
      <divvertical class="boxvertical">
        <divpessoal class="sessaopessoal">
          <adiv>
            <label for="Nome">Nome:</label>
            <input 
              type="text"
              id="nome"
              v-model="name"
              pattern="[a-z]"
            /><br />
            <p>{{ name }}</p>
          </adiv>

          <adiv>
            <label for="Nome">CPF:</label>
            <input 
              type="text"
              id="cpf"
              v-model="cpf"
              pattern="[0-9]"
            /><br />
            <p>{{ cpf }}</p>
          </adiv>

          <adiv>
            <label for="estcivil">Estado civil:</label>
            <select id="estcivil" v-model="estadocivil">
              <option >Solteiro(a)</option>
              <option >Casado(a)</option>
              <option >Viuvo(a)</option>
              <option >Separado(a)</option>
              <option >Divorciado(a)</option></select
            ><br />
               <p>{{ estadocivil }}</p>
          </adiv>

          <adiv>
            <label for="Nacionalidade">Nacionalidade:</label>
            <input
              type="text"
              id="nome"
              name="fname"
              v-model="nacionalidade"
              pattern="[a-z]"
            /><br />
            <p>{{ nacionalidade }}</p>
          </adiv>

          <adiv>
            <label for="Sexo">Sexo:</label>
            <select id="sexo" v-model="sexo" name="sexo">
              <option >Masculino</option>
              <option >Feminino</option></select
            ><br />
            <p>{{ sexo }}</p>
          </adiv>

          <adiv>
            <label for="nasc">Data de nascimento:</label>
            <input
              type="date"
              id="nasc"
              name="trip-start"
              v-model="nasc"
              min="1900-01-01"
              max="2023-12-31"
            />
            <p>{{ nasc }}</p>
          </adiv>

          <adiv>
            <label for="Ocupacao">Ocupaçao:</label>
            <input
              type="text"
              id="nome"
              name="fname"
              v-model="ocupacao"
              pattern="[a-z]"
            /><br />
            <p>{{ ocupacao }}</p>
          </adiv>
        </divpessoal>

        <divendereco class="sessaoendereco">
          <adiv>
            <label for="Rua">Rua:</label>
            <input
              type="text"
              id="nome"
              name="fname"
              v-model="rua"
              pattern="[a-z]"
            /><br />
            <p>{{  rua }}</p>
          </adiv>

          <adiv>
            <label for="Numero">Número:</label>
            <input
              type="text"
              id="nome"
              name="fname"
              v-model="numero"
              pattern="[0-9]"
            /><br />
            <p>{{ numero }}</p>
          </adiv>

          <adiv>
            <label for="Complemento">Complemento:</label>
            <input
              type="text"
              id="nome"
              name="fname"
             v-model="complemento"
              pattern="[0-9]"
            /><br />
            <p>{{ complemento}}</p>
        </adiv>

          <adiv>
            <label for="Bairro">Bairro:</label>
            <input
              type="text"
              id="nome"
              name="fname"
              v-model="bairro"
              pattern="[a-z]"
            /><br />
            <p>{{ bairro }}</p>
          </adiv>

          <adiv>
            <label for="Cidade">Cidade:</label>
            <input
              type="cidade"
              id="cidade"
              name="cidade"
              v-model="cidade"
              pattern="[a-z]"
            /><br />
            <p>{{ cidade }}</p>
          </adiv>

          <adiv>
            <label for="Estado">Estado:</label>
            <select id="Estado" v-model="estado" name="estado">
              <option >AC</option>
              <option >AL</option>
              <option >AP</option>
              <option >AM</option>
              <option >BA</option>
              <option >CE</option>
              <option >ES</option>
              <option >GO</option>
              <option >MA</option>
              <option >MT</option>
              <option >MS</option>
              <option >MG</option>
              <option >PA</option>
              <option >PB</option>
              <option >PR</option>
              <option >PE</option>
              <option >PI</option>
              <option >RJ</option>
              <option >RN</option>
              <option >RS</option>
              <option >RO</option>
              <option >RR</option>
              <option >SP</option>
              <option >SE</option>
              <option >TO</option>
              <option >DF</option></select
            ><br />
            <p>{{ estado }}</p>
          </adiv>

          <adiv>
            <label for="CEP">CEP:</label>
            <input
              type="CEP"
              id="nome"
              name="fname"
              v-model="cep"
              pattern="[0-9]{6,}$-[0-9]{2,}$"
            /><br />
            <p>{{ cep }}</p>
          </adiv>
        </divendereco>

        <divcontato class="sessaocontato">
          <adiv>
            <label for="Email">Email:</label>
            <input
              type="email"
              id="email"
              name="email"
              v-model="email"
              pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
            />
            <p>{{ email}}</p>
          </adiv>

          <adiv>
            <label for="Telefone">Telefone:</label>
            <input type="text" id="nome" v-model="telefone" name="fname" 
              
            /><br />
            <p>{{ telefone}}</p>
          </adiv>
        </divcontato>
      </divvertical>
    </form>
  </div>

    <div class="boxbotoes">
            <button class="cancelbutton"  @click="cancelar()" >Cancelar</button>
            <button class="savebutton"   @click="salvar()" >salvar </button>
    </div>
</div>
</template>

<script>
export default {
         
  data() {
      return {
        name: "",
        estadocivil:'',
        nacionalidade:"",
        sexo:'',
        nasc:'',
        ocupacao:"",
        rua:"",
        numero:"",
        complemento:"",
        bairro:"",
        cidade:"",
        estado:'',
        cep: "",
        email:"",
        telefone:"",
        cpf:"",
        arraylist:[],
      }
    },
        
    methods: {

     salvar(){
        this.arraylist['nome'] = this.name
        this.arraylist['estadocivil']= this.estadocivil
        this.arraylist['bairro'] = this.bairro
        this.arraylist['nacionalidade']= this.nacionalidade 
        this.arraylist['sexo'] = this.sexo
        this.arraylist['nasc']= this.nasc 
        this.arraylist['ocupacao'] = this.ocupacao 
        this.arraylist['rua']= this.rua
        this.arraylist['numero']= this.numero
        this.arraylist['complemento'] = this.complemento
        this.arraylist['cidade'] = this.cidade
        this.arraylist['estado'] = this.estado
        this.arraylist['cep'] = this.cep
        this.arraylist['email'] = this.email
        this.arraylist['telefone'] =  this.telefone
        this.arraylist['cpf'] =  this.cpf
       
        this.arraylist['retorno']= "true"

        this.$emit('cadastrofeito', this.arraylist)// manda de volta  um arraylist com as informações do user
      },
       
      cancelar(){
        this.arraylist['retorno']= "false"
        this.$emit('cadastrofeito',this.arraylist)
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

.cancelbutton {
  margin-top: 10px;
  margin-left: 10px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  background-color: lightcoral;
}
.savebutton {
  margin-top: 10px;
  margin-left: 10px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  background-color: lightskyblue;
}
.boxbotoes {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
</style>
