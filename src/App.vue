<template>
  <div class="boxvertical">
    
    
    <div>
      <button @click="criararray()"> Import BD</button>  
      <Topopagina :users = "this.lista" :tam = "this.tam"/>
    </div>
    
   <!-- <div>
        <p>opa opa </p>
       
        <p>{{ this.telefoneobjetoemlista.telefone}}</p>
        <p>{{ this.lista}}</p>
    </div>-->
</div>

</template>

<script>
import Topopagina from './components/Topo-pagina.vue';
import users from './Service/users';
import axios from 'axios'

export default {
 
  components:{
      Topopagina,  
   },

   data() {
    return {
      posts: [],
      lista:[],
      listaindex:[],
      user: [],
      tam: 0 ,
      bufferendereco:[],
      numtelefones:0,
      buffertelefone:[],
      telefoneobjetoemlista:[],
      arrayuser:[],
      elementouser:[],
      arraydeusers:[],
    }
  },
  
   mounted(){
        users.listar().then(resposta => {
        console.log(resposta)
        }),
        
        axios
        .get('http://localhost:8080/CRUD/restapi/users')
        .then((response) => {this.posts = response.data})
    },

   methods: {
    
    criararray(){
       
        this.tam =  Object.keys(this.posts).length
        this.lista = Object.values(this.posts)
        this.user = this.lista[0]
        this.bufferendereco = Object.values(this.user.endereco)
        
        this.numtelefones = Object.keys(this.user.telefonesarray).length
        this.buffertelefone = Object.values(this.user.telefonesarray)
        this.telefoneobjetoemlista = this.buffertelefone[0]
       // this.telefoneobjetoemlista.telefone  para acessar

       /* 
        for (let i = 0; i < this.tam; i++){
        
        this.user = this.lista[i]
        this.bufferendereco = Object.values(this.user.endereco)
       
       
       
        this.arrayuser['nome'] = this.name
        this.arrayuser['estadocivil']= this.estadocivil
        this.arrayuser['nacionalidade']= this.nacionalidade 
        this.arrayuser['sexo'] = this.sexo
        this.arrayuser['nasc']= this.nasc 
        this.arrayuser['ocupacao'] = this.ocupacao 
        this.arrayuser['email'] = this.email
        this.arrayuser['cpf'] =  this.cpf

        this.arrayuser['bairro'] = this.bufferendereco[1]
        this.arrayuser['rua']= this.bufferendereco[2]
        this.arrayuser['numero']= this.bufferendereco[3]
        this.arrayuser['complemento'] = this.bufferendereco[4]
        this.arrayuser['cidade'] = this.bufferendereco[5]
        this.arrayuser['estado'] = this.bufferendereco[6]
        this.arrayuser['cep'] = this.bufferendereco[7]
        
        
        aqui vai precisar de um loop
              this.arrayuser['telefone'] =  this.telefone
       


        this.elementouser['id'] = this.user.id
        this.elementouser['user'] = this.arrayuser
        
        this.arraydeusers[i] = this.elementouser


        }
            
      */
      console.log("o tipo da variavel é " + typeof(this.buffertelefone)  )
      console.log("o o tamanho do array de index é :" + this.tam )
      console.log("o o tamanho do array de telefones é :" + this.numtelefones )
    },

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
