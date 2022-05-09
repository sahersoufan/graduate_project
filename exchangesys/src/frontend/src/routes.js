
let signup = require('./components/auth/signup.vue').default;
let home = require('./components/user/home.vue').default;
let logout = require('./components/auth/logout.vue').default;
let user = require('./components/user/home.vue').default;
let setting = require('./components/user/setting.vue').default;
let services = require('./components/user/services.vue').default;
let complaints=require('./components/admin/complaints.vue').default;

export const routes = [
    { path: '/signup', component: signup, name:'/signup'},
    { path: '/home', component: home, name:'home'},
    { path: '/logout', component: logout, name:'/logout'},
    { path: '/user', component: user, name:'/user'},
    { path: '/setting', component: setting, name:'/setting'},
    { path: '/services', component: services, name:'/services'},




    { path: '/complaints', component: complaints, name:'/complaints'},

]