import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/my-views/Home.vue'
import MyMainPage from "../MyMainPage.vue";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: MyMainPage,
        children: [
            {
                path: '/vue',
                name: 'Vue',
                component: () => import('../vue-origin/App.vue')
            },
            {
                path: '/home',
                name: 'Home',
                component: Home
            },
            {
                path: '/about',
                name: 'About',
                // route level code-splitting
                // this generates a separate chunk (about.[hash].js) fthis route
                // which is lazy-loadedthe route is visited.
                component: () => import(/* webpackChunkName: "about" */ '../views/my-views/About.vue')
            }
        ],
    },

]

const router = new VueRouter({
    mode: 'history',
    // base: process.env.BASE_URL,
    routes
})

export default router
