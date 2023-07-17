<template>
  <div class="boxvertical">
    <button @click="sincronizar()" class="bsinc"> Sincronizar</button>  
    <button @click="teste()" class="bsinc"> teste</button>  
    <div class="boxteste">
       
        <p class="maisteste">Contador de usuários : {{ this.contadordeusers }} </p>
        <!--pode ser removido o bloco todo, mas a ideia do contador é legal-->
        <p class="maisteste"> tamdoarray : {{ this.tamarraydeusers }} </p>
      </div>
    
      
    <div class="boxhorizontal">
   
      <button class="cadasbutton" @click="chamarcadastro()">Cadastrar</button>
      <CadastroUsuariodois v-if="mostrarcadastro()" @cadastrofeito="saircadastro($event)" />
      <Sucessocadastrodois v-if="mostrarsucesso()" @mensagemvolta="voltar($event)" />
      <TabelaUsuariosdois v-if="mostrartabela()" :arraydeusers="this.arraydeusers" :tam="this.tamarraydeusers" @queroesseuser="temuser($event)" />
      <PaginaUsuario v-if="mostraruser()" :userparaver="this.userparaver"></PaginaUsuario>
         <div class="boxbotoes" v-if="mostraruser()">
               <button class="editbutton" @click="editar()">Editar</button>
              <button class="deletebutton" @click=" excluir(this.iddouser)">Excluir</button>
        </div>
      <UsuarioRemovido v-if="mostrardelete()" @back="voltar($event)"></UsuarioRemovido>
      <Edicaousuario v-if="mostraredit()" :userparaver="this.userparaver" @edicaofeita="sairedit($event)" />
      <Sucessoedicao v-if="mostrarsucessoedit()" @voltaredit="voltaredit($event)" />

    </div>

        <p> {{ this.users }}</p>
        <br>
        <br>
        <p> {{ this.users[0] }}</p>
        
        <br>
        <p>o tamanho recebido é : {{ this.tam }}</p>



  </div>
</template>
    
<script>
import CadastroUsuariodois from './Cadastro-usuariodois';
import TabelaUsuariosdois from './Tabela-usuariosdois';
import PaginaUsuario from './Pagina-de-usuario2';
import UsuarioRemovido from './Usuario-removido2';
import Sucessocadastrodois from './Sucesso-cadastro';
import Sucessoedicao from './Sucesso-edicao';
import Edicaousuario from './Edicao-usuario.vue';
//import users from '@/Service/users';


export default {

    props: ['users','tam'], //variáveis vindas do componente pai , App.// users = usuários vindo do BD e  tam = quantidade de usuários vindos do BD

  components: {
    CadastroUsuariodois,
    TabelaUsuariosdois,
    PaginaUsuario,
    UsuarioRemovido,
    Sucessocadastrodois,
    Sucessoedicao,
    Edicaousuario,
  },

  data() {
    return {
     ///////////////////////////////////////////////////////////////// Variáveis de manutenção do array
      contadordeusers: 0, 
      tamarraydeusers: 0,
      arraydeusers: [],  // array de elementos user // elementouser = ['id', 'user']////////////////// user = 
     //////////////////////////////////////////////////////////////// Variáveis de renderização
      rendercada: "false", 
      rendertabela: "true",
      renderuser: "false",
      renderdelete: "false",
      renderedit: "false",
      rendersucesso: "false",
      rendersucessoedit: "false",
      /////////////////////////////////////////////////////////////// 
      variavelretorno: '',
      userparaver: [],
      iddouser: " ",

      //////////////////////////////////////////////////////////// Varíaveis extras para sincronização com o banco
           
     
      bufferarraytelefones:[],
      arraytelefones:[],
      qtdtelefones:0,
      elementotelefone:[],// elemento telefone => posição [0] = quantidade de telefones no array ; posição [1] = array com todos os telefones
      elementouser:[],
      elementouser2:[],
     
    }
  },


  methods: {
   
    sincronizar(){
      this.contadordeusers=this.tam
      this.tamarraydeusers=this.tam


          for (let i = 0; i < this.tam; i++){

               // this.users[i] objeto  do usuário no formato do Backend

          //      this.arraydeusers[i][0] = this.users[i].id
                this.arraydeusers[i][1]['nome'] = this.users[i].name // Trecho responsável pela conversão do formato do Back para o formato do Front 
                this.arraydeusers[i][1]['estadocivil']= this.users[i].estadoCivil
                this.arraydeusers[i][1]['bairro'] = this.users[i].endereco.bairro
                this.arraydeusers[i][1]['nacionalidade']= this.users[i].nacionalidade 
                this.arraydeusers[i][1]['sexo'] = this.users[i].sexo
                this.arraydeusers[i][1]['nasc']= this.users[i].nasc
                this.arraydeusers[i][1]['ocupacao'] = this.users[i].ocupacao 
                this.arraydeusers[i][1]['rua']= this.users[i].endereco.rua
                this.arraydeusers[i][1]['numero']= this.users[i].endereco.numero
                this.arraydeusers[i][1]['complemento'] = this.users[i].endereco.complemento
                this.arraydeusers[i][1]['cidade'] = this.users[i].endereco.cidade
                this.arraydeusers[i][1]['estado'] = this.users[i].endereco.estado
                this.arraydeusers[i][1]['cep'] = this.users[i].endereco.cep
                this.arraydeusers[i][1]['email'] = this.users[i].email
                this.arraydeusers[i][1]['cpf'] =  this.users[i].cpf
                this.arraydeusers[i][1]['cadastradoem']= this.users[i].cadastradoem
                this.arraydeusers[i][1]['modificadoem']= this.users[i].modificadoem
/*
                console.log("/////////////////////////////////////////////////////////////////////////////")

                console.log("o ID do usuário é : " + this.usersinc.id)
                console.log("nome:" + this.usersinc.name)
                console.log("estadocivil:" + this.usersinc.estadoCivil)
                console.log("bairro:" + this.usersinc.endereco.bairro)
                console.log("nacionalidade:" + this.usersinc.nacionalidade)
                console.log("sexo:" + this.usersinc.sexo)
                console.log("nasc:" + this.usersinc.ocupacao)
                console.log("rua:" + this.usersinc.endereco.rua)
                console.log("numero:" + this.usersinc.endereco.numero)
                console.log("complemento:" + this.usersinc.endereco.complemento)
                console.log("cidade:" + this.usersinc.endereco.cidade)
                console.log("estado:" + this.usersinc.endereco.estado)
                console.log("cep:" + this.usersinc.endereco.cep)
                console.log("email:" + this.usersinc.email)
                console.log("cpf:" + this.usersinc.cpf)
                console.log("cadastradoem:" + this.usersinc.cadastradoem)
                console.log("modificadoem:" + this.usersinc.modificadoem)
 */              
                
                this.qtdtelefones = Object.keys(this.usersinc.telefonesarray).length
                this.arraytelefones= Object.values(this.usersinc.telefonesarray)
                
                for (let j = 0; j < this.qtdtelefones; j++){
                 
                  this.arraydeusers[i][1]['telefone'][j] = this.arraytelefones[j].telefone   

                }   
                
               
    //            console.log("elementouser atribuido à posição:" + i)


                
 //               console.log("arraydeusers:" + this.arraydeusers)
 //               console.log("/////////////////////////////////////////////////////////////////////////////")
                
/*
                this.elementouser2 = this.arraydeusers[i]
                this.userbuffer2 = this.elementouser2[1]



         console.log("chegacagem do elemento no array/////////////////////////////////////////////////////////////////////////////")

              console.log("o ID do usuário é : " + this.elementouser2[0])
              console.log("nome:" + this.userbuffer2['nome'])
              console.log("estadocivil:" + this.userbuffer2['estadocivil'])
              console.log("bairro:" + this.userbuffer2['bairro'])
              console.log("nacionalidade:" + this.userbuffer2['nacionalidade'])
              console.log("sexo:" + this.userbuffer2['sexo'])
              console.log("nasc:" + this.userbuffer2['nasc'])
              console.log("rua:" +this.userbuffer2['rua'])
              console.log("numero:" + this.userbuffer2['numero'])
              console.log("complemento:" + this.userbuffer2['complemento'])
              console.log("cidade:" + this.userbuffer2['cidade'])
              console.log("estado:" +this.userbuffer2['estado'])
              console.log("cep:" + this.userbuffer2['cep'])
              console.log("email:" +this.userbuffer2['email'])
              console.log("cpf:" + this.userbuffer2['cpf'])
              console.log("cadastradoem:" + this.userbuffer2['cadastradoem'])
              console.log("modificadoem:" + this.userbuffer2['modificadoem'])

*/
          }


         
          /////////////////////////////////////////////////////////////teste//////////////////////////////////////////////////////////////////////////////////////////
          for(let z = 0;z < this.tam; z ++){
                     
            console.log("o id do elemento na posição " + z + " é :" +  this.arraydeusers[z][0])

          }




          /////////////////////////////////////////////////////////////teste//////////////////////////////////////////////////////////////////////////////////////////


    },


    teste(){
      
      this.elementouser3 = this.arraydeusers[1]
      this.userbuffer3 = this.elementouser3[1]
     
     
      console.log("chegacagem do elemento /////////////////////////////////////////////////////////////////////////////")

      console.log("o ID do usuário é : " + this.elementouser3[0])
      console.log("nome:" + this.arraydeusers[0][1]['nome'])
      console.log("estadocivil:" + this.userbuffer3['estadocivil'])
      console.log("bairro:" + this.userbuffer3['bairro'])
      console.log("nacionalidade:" + this.userbuffer3['nacionalidade'])
      console.log("sexo:" + this.userbuffer3['sexo'])
      console.log("nasc:" + this.userbuffer3['nasc'])
      console.log("rua:" +this.userbuffer3['rua'])
      console.log("numero:" + this.userbuffer3['numero'])
      console.log("complemento:" + this.userbuffer3['complemento'])
      console.log("cidade:" + this.userbuffer3['cidade'])
      console.log("estado:" +this.userbuffer3['estado'])
      console.log("cep:" + this.userbuffer3['cep'])
      console.log("email:" +this.userbuffer3['email'])
      console.log("cpf:" + this.userbuffer3['cpf'])
      console.log("cadastradoem:" + this.userbuffer3['cadastradoem'])
      console.log("modificadoem:" + this.userbuffer3['modificadoem'])

      this.elementotelefone = this.userbuffer['telefone']
      this.qtdtelefones= this.elementotelefone[0]
      this.bufferarraytelefones = this.elementotelefone[1]
      
      console.log("Este usuário possui"+ this.qtdtelefones + "telefone(s). Sendo ele(s):")
      
      for (let j = 0; j < this.qtdtelefones; j++){
          console.log(  (j+1) + ": " + this.arraytelefones[j].telefone)
      }

    },



    mostrartabela() {
      if (this.rendertabela == "true") {
        return true;
      }
      return false
    },

    chamarcadastro() {
      this.rendercada = "true"
      this.rendertabela = "false"
      this.renderuser = "false"
      this.renderdelete = "false"
      this.renderedit = "false"
      this.rendersucesso = "false"
      this.rendersucessoedit = "false"
    },

    mostrarcadastro() {
      if (this.rendercada == "true") {
        return true;
      }
      return false
    },

    saircadastro(retorno) {// o argumento é um array com as informações de um user
      var inseriu = "aindan"
      var elementouser = []
      this.variavelretorno = retorno['retorno'] // retira a variavel retorno para dar continuidade do fluxo de componentes

      if (this.variavelretorno == "true") {

        if ((this.tamarraydeusers != 0) /*|| ((this.tamarraydeusers - this.contadordeusers > 0))*/) {
          for (let i = 1; ((i <= this.tamarraydeusers) && (inseriu == "aindan")); i++) { /*loop responsavel por procurar um id vazio no caso
                                                                                         de um user ter sido exluido previamente*/
            if (this.arraydeusers[i]['user'] == null) {
              this.arraydeusers[i]['user'] = retorno
              inseriu = "sim"
              this.contadordeusers = this.contadordeusers + 1
            }

          }
        }

        if (inseriu == "aindan") { /* se ele entrar aqui é pq ele percorreu o array todo e não existia uma posição vaga/nula 
                                      para inserir e sera preciso criar uma nova vaga (a qual equivale a este trecho de código) */

          this.contadordeusers = this.contadordeusers + 1 // incrementa a contagem de usuários cadastrados
          this.tamarraydeusers = this.tamarraydeusers + 1
          elementouser['id'] = this.tamarraydeusers //acrescentar o id do usuário ao array que simboliza um user na ultima posição do array 
          elementouser['user'] = retorno // acrescenta o user ao array de arrays de users      
          this.arraydeusers[this.tamarraydeusers] = elementouser
        }

        this.x = this.arraydeusers[this.contadordeusers]['user']['nome']//so pra teste,pode ser apagado


        this.rendercada = "false"  // trecho responsavel por renderizar a tela de sucesso no cadastro
        this.rendertabela = "false"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.renderedit = "false"
        this.rendersucesso = "true"
        this.rendersucessoedit = "false"
      }

      else { // trecho responsavel por voltar a renderização da tabela caso o usuário deisista de cadastrar

        this.rendercada = "false"
        this.rendertabela = "true"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.renderedit = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "false"
      }
    },

    temuser(retorno) {//o argumento nesta função é um array que contem apenas o boolean e um id do user solicitado

      if (retorno['retorno'] == "true") {
        this.rendercada = "false"
        this.rendertabela = "false"
        this.renderuser = "true"
        this.renderdelete = "false"
        this.renderedit = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "false"

        for (let i = 1; i <= this.tamarraydeusers; i++) {

          if (this.arraydeusers[i]['id'] == retorno['iddouser']) {
            this.userparaver = this.arraydeusers[i]['user']
            this.iddouser = this.arraydeusers[i]['id']
            i = this.tamarraydeusers + 1
          }

        }

      }
    },


    mostraruser() {//no futuro tera as informaçoes do usuario para busca como um argumento
      if (this.renderuser == "true") {
        return true;
      }
      return false
    },


    editar() {

      this.rendercada = "false"
      this.rendertabela = "false"
      this.renderuser = "false"
      this.renderdelete = "false"
      this.renderedit = "true"
      this.rendersucesso = "false"
      this.rendersucessoedit = "false"
    },

    mostraredit() {
      if (this.renderedit == "true") {

        return true;
      }
      return false

    },


    excluir(excluirid) {

      for (let i = 1; i <= this.tamarraydeusers; i++) {
        this.teste = this.arraydeusers[i]['id']
        this.y = i
        if (this.arraydeusers[i]['id'] == excluirid) {
          this.arraydeusers[i]['user'] = null
          i = this.tamarraydeusers + 1
        }

      }

      this.contadordeusers = this.contadordeusers - 1

      this.rendercada = "false"
      this.rendertabela = "false"
      this.renderuser = "false"
      this.renderdelete = "true"
      this.renderedit = "false"
      this.rendersucesso = "false"
      this.rendersucessoedit = "false"
    },

    mostrardelete() {
      if (this.renderdelete == "true") {
        return true;
      }
      return false
    },

    voltar(retorno) {
      if (retorno == "true") {
        this.rendercada = "false"
        this.rendertabela = "true"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "false"

      }
    },

    mostrarsucesso() {
      if (this.rendersucesso == "true") {

        return true;
      }
      return false
    },

    mostrarsucessoedit() {
      if (this.rendersucessoedit == "true") {

        return true;
      }
      return false
    },

    voltaredit(retorno) {
      if (retorno == "true") {
        this.rendercada = "false"
        this.rendertabela = "true"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "false"
      }

    },

    sairedit(retorno) { /* argumento dessa função contem um retorno para dar continuidade ao fluxo +
                              um array com o usuário editado*/

      for (let i = 1; i <= this.tamarraydeusers; i++) {

        if (this.arraydeusers[i]['id'] == this.iddouser) {
          this.arraydeusers[i]['user'] = retorno['usereditado']
          i = this.tamarraydeusers + 1
        }
      }

      if (retorno['retorno'] == "true") {
        this.rendercada = "false"
        this.rendertabela = "false"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.renderedit = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "true"
      }

      else {
        this.mensagem = "entrou no else"
        this.rendercada = "false"
        this.rendertabela = "true"
        this.renderuser = "false"
        this.renderdelete = "false"
        this.renderedit = "false"
        this.rendersucesso = "false"
        this.rendersucessoedit = "false"
      }
    },
  }
}
</script>
   
<style scoped>
#app {
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
  height: 1900px;
  background-color: lightslategray;

}

.boxhorizontal {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
  width: 1905px;
  height: auto;
  margin-top: 50px;

}

.cadasbutton {
  margin-left: 1200px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  background-color: gray;
}

input[type=text] {
  width: 200px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  background-color: white;
  background-position: 10px 10px;
  background-repeat: no-repeat;
  padding: 12px 20px 12px 40px;
  transition: width 0.4s ease-in-out;
}

.editbutton {
  margin-top: 10px;
  margin-left: 10px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  background-color: lightskyblue;
}

.deletebutton {
  margin-top: 10px;
  margin-left: 10px;
  border-radius: 12px;
  height: 50px;
  width: 80px;
  background-color: lightcoral;

}

.boxbotoes {
  display: flex;
  flex-direction: row;
  justify-content: center;

}

.boxteste {
  width: 450px;
  display: flex;
  flex-direction: row;
  justify-content: center;

  border: 4px solid black;
}

.maisteste {
  margin-left: 20px;
}

.bsinc{
  width: 77px;
}
</style>
  