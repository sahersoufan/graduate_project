<template>
<div>
    <!-- header area start -->

   
    <!-- header area end -->
    <!-- header area start -->
 
    <!-- header area end -->
 
    <main>

        <div class="main-wrapper">
            <!-- profile banner area start -->
            <div class="profile-banner-large bg-img" @click="$refs.file1.click()" alt="Select File" title="Select File" :style="{backgroundImage:`url(${require('../../../../../user-profile/' + form.profilepath)})`}">
            
            
                 <input type="file" ref="file1" @change="onChange1" style="display: none">

            </div>
            <!-- profile banner area end -->

            <!-- profile menu area start -->
            <div class="profile-menu-area secondary-navigation-style bg-white">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-3">
                            <div class="profile-picture-box">
                                <figure class="profile-picture">

                                    <img  @click="$refs.file.click()" alt="Select File" title="Select File" width="270" height="270" :src="require('../../../../../user-photos/'+form.imagepath)"  style="cursor: pointer" />
                                    <br />
                                
                                    <input type="file" ref="file" @change="onChange" style="display: none">

 
                                   
                                    
                                </figure>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 offset-lg-1">
                            <div class="profile-menu-wrapper">
                                <div class="main-menu-inner header-top-navigation">
                                    <nav>
                                        <ul class="main-menu">
                                             <li v-on:click="call('services')"><router-link to="" >Services</router-link></li>
                                            <li><a href="">Work</a></li>
                                            
                                            <li v-on:click="call('friends')"><router-link to="" >Friends</router-link></li>
                                           
                                             <li v-on:click="call('setting')"><router-link to="" >Setting</router-link></li>
                                            <!-- <li class="d-inline-block d-md-none"><a href="profile.html">edit profile</a></li> -->
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                      
                    </div>
                </div>
            </div>
            <!-- profile menu area end -->

            <!-- sendary menu start -->
            <div class="menu-secondary">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="secondary-menu-wrapper bg-white">
                                <div class="page-title-inner">
                                    <h4 class="page-title">Contact</h4>
                                </div>
                                <div class="main-menu-inner header-top-navigation">
                                    <nav>
                                        <ul class="main-menu">
                                            <li><a href="#"><span>facebook</span> <i class="flaticon-facebook"></i></a></li>
                                            <li><a href="#"><span>twitter</span> <i class="flaticon-twitter-logo-silhouette"></i></a></li>
                                            <li><a href="#"><span>google</span> <i class="flaticon-google-plus"></i></a></li>
                                            <li><a href="#"><span>Linkedin</span> <i class="flaticon-pinterest"></i></a></li>
                                            <!-- <li class="d-inline-block d-md-none"><a href="profile.html">edit profile</a></li> -->
                                        </ul>
                                    </nav>
                                </div>
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- sendary menu end -->

            <!-- about author details start -->
            <div class="about-author-details">
                <router-view></router-view>
              <Setting v-if="message === 'setting'"></Setting>
               <Services v-if="message === 'services'"></Services>
               <Friends v-if="message === 'friends'"></Friends>
            </div>
            <!-- about author details start -->
        
        </div>

    </main>

    <!-- Scroll to top start -->
 
    <!-- footer area end -->
</div>
</template>


<script>




import Setting from './setting.vue';

 import Cookies from 'js-cookie'
import Services from './services.vue';
import Friends from './friends.vue';
  export default {

    data() {
      return {
              form: {
          username: null,
          imagepath:null,
          profilepath:null,
        
        },
          message:null,
       
    


      }
    },
     components: {
    Setting,
    Services,
    Friends
},created(){
     
          this.$axios.get('/api/islog')
              .then(res => {

                    console.log("islog",res)  ; 
                    if(res.data==="islog"){
                        console.log("islog",res.data)  ; 
                    
                    } else{
                        window.location.href = "/";
                    }                
           
              })
              .catch(
                
                console.log("islog errrore")
              )
                    /** ------------------------------------------------------------------- */
                var username= Cookies.get('user')
             
                this.form.username=username;

                this.$axios.post('/api/getuser',this.form)
                .then(res => {
                    console.log("ress",res)
                     if(res.data.imagepath===null){
                             this.form.imagepath='1.jpg';


                    }else{
                      this.form.imagepath= res.data.imagepath.split('\\')[res.data.imagepath.split('\\').length - 2]+'/'+
                        res.data.imagepath.split('\\')[res.data.imagepath.split('\\').length - 1];
                    }
                     if(res.data.profilepath===null){
                        
                           this.form.profilepath='1.jpg';

                    }else{
                        this.form.profilepath= res.data.profilepath.split('\\')[res.data.profilepath.split('\\').length - 2]+'/'+
                        res.data.profilepath.split('\\')[res.data.profilepath.split('\\').length - 1];
                    }
                       console.log("pathhh",res.data.imagepath)
                  
                   

                console.log("ttttttttttt",this.form,res.data)
                })
                .catch(
                    console.log("errorrrr")    
                )
  
               /** ------------------------------------------------------------------- */  
  
               
   
  },
    methods:{
        call(message){
            this.message=message;


        },  onChange(e) {
            console.log("mm")
             let img = e.target.files[0]
                let fd= new FormData()
                
                fd.append('image', img)
                
                this.$axios.post('api/uploadimage', fd)
                    .then(resp => {
                        
      


                        
                       this.form.imagepath= resp.data.split('\\')[resp.data.split('\\').length - 2]+'/'+
                        resp.data.split('\\')[resp.data.split('\\').length - 1];
                       
                   console.log(resp);
                    })
              
            },
             onChange1(e) {
            console.log("mm")
             let img = e.target.files[0]
                let fd= new FormData()
                
                fd.append('image', img)
                
                this.$axios.post('api/uploadprofile', fd)
                    .then(resp => {
                        
      


                        
                       this.form.profilepath= resp.data.split('\\')[resp.data.split('\\').length - 2]+'/'+
                        resp.data.split('\\')[resp.data.split('\\').length - 1];
                       
                   console.log(resp);
                    })
              
            }
     




            
    
  }


}
</script>