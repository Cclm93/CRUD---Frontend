<template>
  <div class="boxvertical">
    
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



export default {

   

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
  