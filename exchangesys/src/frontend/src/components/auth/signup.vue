<template>
  <div >
    <main>
      <div class="main-wrapper pb-0 mb-0">
        <div class="timeline-wrapper">
          <div class="timeline-header">
            <div class="container-fluid p-0">
              <div class="row no-gutters align-items-center">
                <div class="col-lg-6">
                  <div class="timeline-logo-area d-flex align-items-center">

                    <div class="timeline-tagline">
                      <h6 class="tagline">It’s helps you to exchange services with the people in your life</h6>
                    </div>
                  </div>
                </div>
                
                <div class="col-lg-6">
                  <form id="form" @submit.prevent="login">
                  <div class="login-area">
                    <div class="row align-items-center">
                     
                      <div class="col-12 col-sm">
                        <input type="text" placeholder="Email or Userame" id="username" name="username"  class="single-field" >
                      </div>
                      <div class="col-12 col-sm">
                        <input type="password" placeholder="Password" id="password" name="password" class="single-field"  >
                      </div>
                      <div class="col-12 col-sm-auto">
                        <button class="login-btn">Login</button>
                      </div>
                    
                    </div>
                  </div>
                   </form>
                </div>
                 
              </div>
            </div>
          </div>
          <div class="timeline-page-wrapper">
            <div class="container-fluid p-0">
              <div class="row no-gutters">
                <div class="col-lg-6 order-2 order-lg-1">
                  <div class="timeline-bg-content bg-img"><img src="../../assets/images/timeline/adda-timeline.jpg">
                    <h3 class="timeline-bg-title">Let’s see what’s happening to you and your world. Welcome in Adda.</h3>
                  </div>
                </div>
                <div class="col-lg-6 order-1 order-lg-2 d-flex align-items-center justify-content-center">
                  <div class="signup-form-wrapper">
                    <h1 class="create-acc text-center">Create An Account</h1>
                    <div class="signup-inner text-center">
                      <h3 class="title">Wellcome to Platform Exchange</h3>
                      <form class="signup-inner--form" method="post"  @submit.prevent="signup">
                        <div class="row">
                          <div class="col-12">
                            <input type="email" class="single-field" placeholder="Email" v-model="form.username">
                          </div>
                          <div class="col-md-6">
                            <input type="text" class="single-field" placeholder="First Name" v-model="form.firstname">
                          </div>
                          <div class="col-md-6">
                            <input type="text" class="single-field" placeholder="Last Name" v-model="form.lastname">
                          </div>
                          <div class="col-12">
                            <input type="password" class="single-field" placeholder="Password" v-model="form.password">
                          </div>
                          <div class="col-md-6">
                            <select class="nice-select" name="sortby" v-model="form.gender">
                   
                              <option v-bind:value="Male">Male</option>
                              <option v-bind:value="Female">Female</option>
                            </select>
                          </div>
                           <div class="col-md-6">
                            <input type="number" class="single-field" placeholder="Age" v-model="form.age">
                          </div>
  
                          <div class="col-12">
                            <button class="submit-btn">Create Account</button>
                          </div>
                        </div>
                        <h6 class="terms-condition">I have read & accepted the <a href="#">terms of use</a></h6>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>


<script>




import Swal from 'sweetalert2'
import Cookies from 'js-cookie'



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
  export default {

    data() {
      return {
        form: {
          username: null,
          password: null,
          firstname:null,
          lastname:null,
          age:null,
          country:null,
          gender:null
        },
     
        Male:"male",
        Female:"female",

      }
    },created(){
     
          this.$axios.get('/api/islog')
              .then(res => {

                    console.log("islog",res)  ; 
                    if(res.data==="islog"){
                        console.log("islog",res.data)  ; 
                     if(Cookies.get('name')==="user"){
                         window.location.href="user/home"


                     }
                      if(Cookies.get('name')==="admin"){
                          window.location.href="admin/home"

                     }
                    }                 
           
              })
              .catch(
                console.log("islog errrore")
              )
  
   
  },
    methods:{
      signup(){
      this.$axios.post('/api/register',this.form)
              .then(res => {

                        console.log("http://localhost:8080/login",res)
                        //  User.responseAfterLogin(res)
                          this.$Toast.fire({
                            icon: 'success',
                            title: "successfly register"
                          })                      
            window.location.href="/"
              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )
                 
    },
    login(){
    
 const _this= this;  
    const myForm = document.getElementById('form');


        const formData = new FormData(myForm);
        const myHeaders = new Headers();
        myHeaders.append('contentType','application/x-www-form-urlencoded');
        const myRequest = new Request('api/login',
            {method:'POST',
                headers:myHeaders,
                body:formData}
        )
        
        fetch(myRequest).then(function (response) {
            return response.json();
        }).then(function (json) {
            console.log("loggg",json);
            Cookies.set('access_token', json.access_token, { path: '/' })
            Cookies.set('refresh_token', json.refresh_token, { path: '/' })
            Cookies.set('name', json.auth, { path: '/' })
               Cookies.set('user', json.name, { path: '/' })
           
               Toast.fire({
                            icon: 'success',
                            title: "success login"
               })
               if(json.auth==="user"){
                   
                //   _this.$router.replace("/user/").catch(()=>{console.log("hhhhh")});
                 //  location.reload(); 
                  /// console.log( _this.$router.push({  path: '/user/'})   )
                  window.location.href="user/home"
               }else{
                  window.location.href="admin/dashboard"
               }
    
             
        }).catch(
           Toast.fire({
                        icon: 'warning',
                        title: 'Invalid Username or Passwored'
                      })

        )

    }



            
    
  }


}
</script>