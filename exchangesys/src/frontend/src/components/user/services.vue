<template>
   <div class="container">
                   <div class="row">
                     <div class="col-lg-3">
                        <aside class="widget-area">
                            <!-- widget single item start -->
                            <div class="card widget-item">
                                <h4 class="widget-title">My Work</h4>
                                <div class="widget-body">
                                    <ul class="like-page-list-wrapper">
                                        <li class="unorder-list">
                                            <!-- profile picture end -->
                                            <div class="profile-thumb">
                                                <a href="#">
                                                    <figure class="profile-thumb-small">
                                                        <img src="assets/images/profile/profile-small-9.jpg" alt="profile picture">
                                                    </figure>
                                                </a>
                                            </div>
                                            <!-- profile picture end -->

                                            <div class="unorder-list-info">
                                                <h3 class="list-title"><a href="#">Any one can join with us if you want</a></h3>
                                                <p class="list-subtitle">5 min ago</p>
                                            </div>
                                        </li>
                                  
                                  
                                   
                                    
                                    </ul>
                                </div>
                            </div>
                            <!-- widget single item end -->

                       

                        
                        </aside>
                    </div>

                    <div class="col-lg-6">
                        <!-- share box start -->
                        <div class="card card-small">
                            <div class="share-box-inner">
                                <!-- profile picture end -->
                                <div class="profile-thumb">
                                    <a href="#">
                                        <figure class="profile-thumb-middle">
                                            <img src="assets/images/profile/profile-small-37.jpg" alt="profile picture">
                                        </figure>
                                    </a>
                                </div>
                                <!-- profile picture end -->

                                <!-- share content box start -->
                                <div class="share-content-box w-100">
                                    <form class="share-text-box">
                                        
                                        <textarea name="share" class="share-text-field" aria-disabled="true" placeholder="Say Something" data-toggle="modal" data-target="#textbox" id="email"></textarea>
                                        <button class="btn-share" type="submit">ADD</button>
                                    </form>
                                </div>
                                <!-- share content box end -->
                                <!-- Modal start -->
                                <div class="modal fade" id="textbox" aria-labelledby="textbox">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Add services</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="name service"  v-model="form.serviceName" >
                                                   <input type="text" class="single-field" placeholder="description"  v-model="form.description" >
                                            </div>
                                            <div class="modal-footer">
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="services()" >add
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal">cancel</button>
                                               
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Modal end -->
                            </div>
                        </div>
                        <!-- share box end -->


                        <!-- post status start -->
                        <div class="card"  v-for="(service,k) in allservices" :key="k">
                            <!-- post title start -->
                            <div class="post-title d-flex align-items-center">
                                <!-- profile picture end -->
                                <div class="profile-thumb">
                                    <a href="#">
                                        <figure class="profile-thumb-middle">
                                            <img :src="require('../../../../../user-photos/'+user.imagepath)" alt="profile picture">
                                        </figure>
                                    </a>
                                </div>
                                <!-- profile picture end -->
                                   <div class="posted-author">
                                    <h6 class="author"><a href="profile.html">{{user.firstname }} {{user.lastname}}</a></h6>
                                   
                                </div>


                                <div class="post-settings-bar">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                    <div class="post-settings arrow-shape">
                                        <ul>
                                        
                                            <li><button  @click="edit(service.id)" data-toggle="modal" data-target="#textbox1" >edit </button></li>
                                            <li><button  @click="Delete(service.id)">delete</button></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- post title start -->
                            <div class="post-content">

                                 <h6 class="author"  >{{service.serviceName}}</h6>
                                 <p class="post-desc pb-0" >{{service.description}} </p>


                          
                             
                            </div>
                        </div>
                         <div class="modal fade" id="textbox1" aria-labelledby="textbox">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Edit services</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="name service"  v-model="form.serviceName" >
                                                   <input type="text" class="single-field" placeholder="description"  v-model="form.description" >
                                            </div>
                                            <div class="modal-footer">
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="update()" >edit
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal">cancel</button>
                                               
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        <!-- post status end -->
                    </div>

                    <div class="col-lg-3">
                        <aside class="widget-area">
                            <!-- widget single item start -->
                            <div class="card widget-item">
                                <h4 class="widget-title">Recent Notifications</h4>
                                <div class="widget-body">
                                    <ul class="like-page-list-wrapper">
                                        <li class="unorder-list">
                                            <!-- profile picture end -->
                                            <div class="profile-thumb">
                                                <a href="#">
                                                    <figure class="profile-thumb-small">
                                                        <img src="assets/images/profile/profile-small-9.jpg" alt="profile picture">
                                                    </figure>
                                                </a>
                                            </div>
                                            <!-- profile picture end -->

                                            <div class="unorder-list-info">
                                                <h3 class="list-title"><a href="#">Any one can join with us if you want</a></h3>
                                                <p class="list-subtitle">5 min ago</p>
                                            </div>
                                        </li>
                                  
                                  
                                   
                                    
                                    </ul>
                                </div>
                            </div>
                            <!-- widget single item end -->

                       

                        
                        </aside>
                    </div>
                </div>
                </div>
</template>


<script>





 import VueUploadMultipleImage from 'vue-upload-multiple-image'
 import Cookies from 'js-cookie'
 import Swal from 'sweetalert2'
  export default {

    data() {
      return {
    
    
       allservices: [
            {
                serviceName: '',
                description:'',
                id:''
            }
        ],
        form:{
                serviceName: '',
                description:'',
            
        },
               user: {
        
          imagepath:null,
          profilepath:null,
                   username: null,
          password: null,
          firstname:null,
          lastname:null,
          age:null,
          country:null,
          gender:null,
          phone:null,
          description:null,
        
        },
       
       
      
     

      }
    },/* eslint-disable */
    components: {
	    VueUploadMultipleImage,
	  }/* eslint-disable */
      ,created(){
     
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

             this.$axios.get('/api/services/all')
              .then(res => {

                    console.log("all services",res)  ; 
                    this.allservices=res.data;
                     console.log("services",this.allservices)  ; 
                                   
           
              })
              .catch(
                
                console.log("islog errrore")
              )
              
              /** ------------------------------------------------------------------- */
                var username= Cookies.get('user')
             
                this.user.username=username;

                this.$axios.post('/api/getuser',this.user)
                .then(res => {
                    
                    this.user=res.data;
                     if(res.data.imagepath===null){
                             this.user.imagepath='1.jpg';


                    }else{
                      this.user.imagepath= res.data.imagepath.split('\\')[res.data.imagepath.split('\\').length - 2]+'/'+
                        res.data.imagepath.split('\\')[res.data.imagepath.split('\\').length - 1];
                    }

                console.log("userrr",this.form,res.data)
                })
                .catch(
                    console.log("errorrrr")    
                )
  
               /** ------------------------------------------------------------------- */   
   



   
  },
    methods:{
     

  
        services(){

               this.$axios.post('/api/services/add',this.form)
              .then(res => {

                      console.log("services",  res)
                        //  User.responseAfterLogin(res)
                        if(res.data==true){
                             this.$Toast.fire({
                            icon: 'success',
                            title: "successfly Addes"
                          }) 
                           this.$axios.get('/api/services/all')
                  .then(res => {
                  this.allservices=null;

                    console.log("all services",res)  ; 
                    this.allservices=res.data;
                     console.log("services",this.allservices)  ; 
                                   
           
              })
              .catch(
                
                console.log("islog errrore")
              ) 



                        }else{
                                this.$Toast.fire({
                                icon: 'error',
                                title: 'Sorry but something wrong'
                            })

                        }
                                          
         

              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )

                
           

        },
      update(){
             this.$axios.put('/api/services/update',this.form)
              .then(res => {

                    console.log("services",res.data)  ; 
                     if(res.data==true){
                             this.$Toast.fire({
                            icon: 'success',
                            title: "successfully update"
                          }) }
                    
                             
           
              })
              .catch(
                
                console.log("")
              )

        this.$axios.get('/api/services/all')
              .then(res => {

                    console.log("all services",res)  ; 
                    this.allservices=res.data;
                     console.log("services",this.allservices)  ; 
                                   
           
              })
              .catch(
                
                console.log("islog errrore")
              )
               this.message=null;
                var element = document.getElementById("tow");
                  element.classList.add("active");
                  element.classList.add("show");
        },       edit(id){
            
           
              this.$axios.get('/api/services/'+id)
              .then(res => {

                    console.log("services",res.data)  ; 
                    this.form=res.data;
                     console.log("services",this.form)  ; 
                                   
           
              })
              .catch(
                
                console.log("")
              )

        },
        Delete(id){
                 Swal.fire({
              title: 'Are you sure?',
              text: "You won't be able to revert this!",
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
              if (result.value) {
                  console.log("deleteee")
               this.$axios.delete('/api/services/delete/'+id)
               .then(() => {
            console.log("deleteee")
                this.allservices = this.allservices.filter(an => {
                  return an.id != id
                })
               })
               .catch(() => {
               
               })
              
                Swal.fire(
                  'Deleted!',
                  'Your file has been deleted.',
                  'success'
                )
              }
            })

        }
/* eslint-disable */



            
    
  }


}
</script>