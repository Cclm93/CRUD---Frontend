<template>
    <div class="box">
      <div class="boxdereaduser">
          
         <label for="busca">Insira o ID do usuário que deseja vizualizar: </label>
         <input id="busca" class = "input" type="number" v-model="iduser" v-on:click="checar()" min= 1/>
            <button  v-if="mostrarbotao()" class="cadasbutton" @click="ver(this.iduser)">Ver</button><br>
            <p v-if="mostrartexto()">Este usuário não existe</p><br>
      </div>
      <button class ="teste" @click="criartabela()"> Atualizar Tabela</button>
      <div id="inserirtabela"></div>
    </div>
  </template>
  
  <script>
  export default {
   
     props : ['arraydeusers','tam'], //tam => tamanho do array de users, e não mais a quantidade de users
    
      data(){
        return{
           nome:"",
           array:[],
           tabela:"" ,
           id:"",
           arrayretorno:[],
           x:"",
           iduser:"1", //id do user que no qual se quer ver a página
          renderver: "false",
          rendermsg:"false",
          teste: "",
          teste1: "",
          teste2: "",
          teste3: "",
          teste4: "",
          }
      },
    
    methods: {
         solicitaruser(){
          this.$emit('queroesseuser', "true")
         },

         testar(){
          this.array = this.arraydeusers[1]['user']
          this.nome = this.array[ 'nome']
         },

         criartabela(){
              
           var newTable = "<table border='1' width='100%'>  <tr> <th>ID</th><th>Nome</th> <th>CPF</th> <th>Cidade</th>"
                       
           for(var j = 1; j <= this.tam; j++) { 
              this.array = this.arraydeusers[j]['user']
             if(this.array != null){
              this.id= this.arraydeusers[j]['id']
              this.nome = this.array['nome']
              this.cpf = this.array[ 'cpf']
              this.cidade = this.array[ 'cidade']
             
              newTable += "<tr><td align='center'>" +this.id+ "</td><td align='center'>" + this.nome + "</td>" +  "<td align='center'>" + this.cpf + "</td>" +  "<td align='center'>" + this.cidade + "</td> "                /* +   <td>  <button class=\"cadasbutton\" @click=\"ver("+ this.id + ")\">Ver</button>   </td><tr> " */                                                                                             
              }
              }
           

          newTable += "</table>";
          document.getElementById("inserirtabela").innerHTML = newTable;
          },

          ver(iddouser){
            this.arrayretorno['retorno'] = "true"
            this.arrayretorno['iddouser'] = iddouser


            this.$emit('queroesseuser', this.arrayretorno)
            },

          checar(){
              
              if((this.iduser > this.tam) ||( this.iduser<= 0) ){ //caso o id seja maior ou menor do que o numero do array  , o botao some (prevenindo o clique) e a mensagem aparece
                
                this.renderver = "false"
                this.rendermsg = "true"
               
                }
                else{// caso o o id seja menor o botao aparece e a mensagem some 
                 
                  
                     var array = this.arraydeusers[this.iduser]['user']
                        if(array == null){
                        
                          this.renderver = "false"
                          this.rendermsg = "true"            
                        }
                 
                        else{
                         
                          this.renderver = "true"
                          this.rendermsg = "false"
                        }
                  }
                

            },

            mostrartexto(){
             
              if(this.rendermsg == "true"){
              
              return true;
           }
            return false

           },

            mostrarbotao(){
              
            if(this.renderver == "true"){
              
              return true;
           }
            return false

           },
            
            
            mostrarmensagem(){
              if( this.renderbotaover != "true"){
                if(this.iduser != "0" ){
                     return true;
                }
               }
              return false;
            },
            
            
            
            idexiste(){

              this.renderbotaover = "false"
              for (let i = 0; i <= this.tam; i++){
              
                if(this.arraydeusers[i]['id'] == this.iduser ) {
                this.renderbotaover = "true"
                }
              } 
             
            },


      },


         
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
 
 
  table, th, td {
  width: auto;
  border: 1px solid;
  border-collapse: collapse;
  background-color: lightseagreen;

}

td{
  text-align: center;
}

.cadasbutton {
    margin-left: 1200px;
    border-radius: 12px;
    height: 50px;
    width: 80px;
    background-color: gray;
  }

.box{
  display:flex;
  flex-direction: column;
  justify-content: center;
  width: 80%;
}

.boxdereaduser{
  display:flex;
  flex-direction: column;
}



input{
      width: 30px;
}

.teste{
  width: 120px;
}

  </style>
  