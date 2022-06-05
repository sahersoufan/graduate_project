

import Vue from 'vue/dist/vue.js';
import VueRouter from'vue-router'
import { routes } from './routes';
import axios from 'axios'
import VueUploadMultipleImage from 'vue-upload-multiple-image'
import JwPagination from 'jw-vue-pagination';
import Carousel3d from 'vue-carousel-3d';
import '@morioh/v-lightbox/dist/lightbox.css';
import App from './components/user/mainhome.vue'

import Lightbox from '@morioh/v-lightbox'
// import firebaseMessaging from './firebase'

// Vue.prototype.$messaging = firebaseMessaging








// global register
Vue.use(Lightbox);
Vue.use(Carousel3d);

Vue.component('jw-pagination', JwPagination);

// Sweet Alert start
import Swal from 'sweetalert2'
window.Swal = Swal;

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
  linkActiveClass: "active",
  linkExactActiveClass: "exact-active",
  mode: 'history' ,

})
Vue.prototype.$Toast = Toast
Vue.prototype.$axios = axios



/* eslint-disable */
const app=new Vue({
  el: '#app1',
  router,
  components: {
    VueUploadMultipleImage,
  },
  render: h => h(App)

})
/* eslint-disable */