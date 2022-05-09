
let signup = require('./components/auth/signup.vue').default;
let home = require('./components/user/home.vue').default;
let logout = require('./components/auth/logout.vue').default;
export const routes = [
    { path: '/signup', component: signup, name:'signup'},
    { path: '/home', component: home, name:'home'},
    { path: '/logout', component: logout, name:'/logout'},

]