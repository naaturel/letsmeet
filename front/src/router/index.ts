import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import CreateView from "../views/CreateView.vue";
import JoinView from "../views/JoinView.vue";
import ErrorView from '../views/ErrorView.vue';
import EventView from "@/views/EventView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/',               name: 'home',   component: HomeView},
    { path: '/about',          name: 'about',  component: AboutView},
    { path: '/create',         name: 'create', component: CreateView},
    { path: '/join',           name: 'join',   component: JoinView},
    { path: '/event/:token',   name: 'event',  component: EventView},
    { path: '/error',          name: 'error',  component: ErrorView},
    { path: '/:pathMatch(.*)*',                component: ErrorView }
  ]
})

export default router
