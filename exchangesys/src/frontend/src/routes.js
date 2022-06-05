
let signup = require('./components/auth/signup.vue').default;
let home = require('./components/user/home.vue').default;
let logout = require('./components/auth/logout.vue').default;
let user = require('./components/user/home.vue').default;
let setting = require('./components/user/setting.vue').default;
let services = require('./components/user/services.vue').default;
let complaints=require('./components/admin/complaints.vue').default;
let friends=require('./components/user/friends.vue').default;
let work=require('./components/user/work.vue').default;
let busnies=require('./components/user/busnies.vue').default;
let mainhome = require('./components/user/mainhome.vue').default;
let homepage = require('./components/user/homepage.vue').default;
let message=require('./components/user/message.vue').default;
let friendpage=require('./components/user/friendpage.vue').default;
let friendservices=require('./components/user/friendservices.vue').default;
let friendwork=require('./components/user/friendwork.vue').default;
let contract=require('./components/user/contract.vue').default;
export const routes = [
    { path: '/signup', component: signup, name:'/signup'},
    { path: '/home', component: home, name:'home'},
    { path: '/main', component: mainhome, name:'main'},
    { path: '/logout', component: logout, name:'/logout'},
    { path: '/user', component: user, name:'/user'},
    { path: '/setting', component: setting, name:'/setting'},
    { path: '/services', component: services, name:'/services'},
    { path: '/friends', component: friends, name:'/friends'},
    { path: '/work', component: work, name:'/work'},
    { path: '/message', component: message, name:'/message'},
    { path: '/homepage', component: homepage, name:'/homepage'},
    { path: '/busnies', component: busnies, name:'/busnies'},
    { path: '/contract', component: contract, name:'/contract'},
   
   
    { path: '/friendpage/:id', component: friendpage, name:'friendpage'},
    { path: 'friendservices', component: friendservices, name:'friendservices'},
    { path: 'friendwork', component: friendwork, name:'friendwork'},




    { path: '/complaints', component: complaints, name:'/complaints'},

]