

import Vue from 'vue'
import VueRouter from'vue-router'
import { routes } from './routes';
import axios from 'axios'
import App from './components/auth/signup.vue'

// Sweet Alert start
import Swal from 'sweetalert2'
window.Swal = Swal;



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
Vue.prototype.$router = router



new Vue({
  
  router,
  render: h => h(App)
}).$mount('#app')

