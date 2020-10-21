import Vue from 'vue'
import 'api/resource.js'
import '@babel/polyfill'
import App from 'pages/App.vue'
import Vuetify from "vuetify"
import 'vuetify/dist/vuetify.min.css'

Vue.use(Vuetify)


new Vue({
    el: '#app',
    render: a => a(App)
})


