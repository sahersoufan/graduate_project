

import Vue from 'vue/dist/vue.js';
import VueRouter from'vue-router'
import { routes } from './routes';
import axios from 'axios'


// Sweet Alert start
import Swal from 'sweetalert2'
window.Swal = Swal;
import VueGoodTablePlugin from 'vue-good-table';

// import the styles
import 'vue-good-table/dist/vue-good-table.css'

Vue.use(VueGoodTablePlugin);
Vue.use(VueRouter);

const Toast = Swal.mixin({
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  onOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
});

//window.Toast = Toast;

const router = new VueRouter({
  routes,
  mode: 'history' ,

})
Vue.prototype.$Toast = Toast
Vue.prototype.$axios = axios



/* eslint-disable */
const app=new Vue({
  el: '#app1',
  router,

})
/* eslint-disable */