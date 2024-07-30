import Vue from 'vue'
import MyMainPage from "./MyMainPage.vue";

import './vue-origin/assets/main.css'

import router from './router/index'

new Vue({
    render: (h) => h(MyMainPage),
    router,
}).$mount('#app')
