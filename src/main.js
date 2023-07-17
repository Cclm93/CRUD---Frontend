import { createApp } from 'vue' //importando a função que cria componente principal
import App from './App.vue' // importando componente principal

createApp(App).mount('#app') //.use(router)  cria a aplicação utilizando o app importado como o componente principal
// e monta ele em cima de uma div com o id "app"

