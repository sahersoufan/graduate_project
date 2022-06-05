<template>
   <div class="container">
                   <div class="row">
                     <div class="col-lg-3">
                        <aside class="widget-area">
                            <!-- widget single item start -->
                            <div class="card widget-item">
                                <h4 class="widget-title">{{user.firstname}} {{user.lastname}}</h4>
                                <div class="widget-body">
                                    <ul class="like-page-list-wrapper">
                                        <li class="unorder-list">
                                            <!-- profile picture end -->
                                         
                                            <!-- profile picture end -->

                                            <div class="unorder-list-info">
                                                <h3 class="list-title">Welcome in Exchange Platform</h3>

                                                 <h4 class="list-title" v-if="user.description!=null">about your self:</h4>
                                                  <p class="list-subtitle" v-if="user.description!=null">{{user.description}}</p>
                                                     <p class="list-subtitle"><center>you have <strong> {{count}}</strong> friends</center></p>
                                            </div>
                                        </li>
                                  
                                  
                                   
                                    
                                    </ul>
                                </div>
                            </div>  <div class="card widget-item" style='position: sticky;'>
                                <div class="about-me">
                                     <h4 class="widget-title">Last Activity</h4>
                                     <div class="col-lg-12">

                                                <h6 class="author" v-if="active.length<0 "  > you dont have any activity </h6>
                                              
                                                 
                                            </div>
                                       <div  v-for="(a,k) in active" :key="k">
                                           

                                            <div class="col-lg-12">

                                                <h6 class="author" v-if="a.name==='add' "  > you add anew services </h6>
                                                <p class="" v-if="a.name==='add'" >services: {{a.servicesname}} </p><br>

                                                 <h6 class="author" v-if="a.name==='edit' "  > you edit information services </h6>
                                                <p class="" v-if="a.name==='edit'" >services {{a.servicesname}} </p><br>
                                            
                                            </div>
                                             
                                        </div>
                                   
                         
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
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"  @click="delactive()">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="name service"  v-model="form.serviceName" >
                                                   <input type="text" class="single-field" placeholder="description"  v-model="form.description" >
                                            
                                                 <i  @click="$refs.file.click()" class="fa fa-camera" style='font-size:24px;'  ></i>
                                                             

                                                    <input type="file" ref="file" @change="uploadFile"  style="display: none"   multiple>
                                                    <div style="overflow: hidden; display: flex; justify-content:space-around;">
                                                    <div v-for="(image, key) in images" :key="key"  >
                                                        <div>
                                                            <img class="preview" v-bind:ref="'image' +parseInt( key )" width="100px" height="100px"  /> 
                                                        
                                                        </div>
                                                    </div>
                                                    </div>
                                                    </div>
                                            <div class="modal-footer">
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="services()" >add
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal"  @click="delactive()">cancel</button>
                                               
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Modal end -->
                            </div>
                        </div>
                      


                        <!-- post status start -->
                        <div class="card"  v-for="(service,k) in allservices" :key="k">
                            <!-- post title start -->
                            <div class="msg-list-item d-flex justify-content-between">
                                <!-- profile picture end -->
                                <div class="profile-thumb">
                                    <a href="#">
                                        <figure class="profile-thumb-middle">
                                            <img :src="require('../../../../../user-photos/'+user.imagepath)" alt="Avatar" style="width: 60px;height: 45px; border-radius: 50%;">
                                        </figure>
                                    </a>
                                </div>
                                <!-- profile picture end -->
                                   <div class="msg-content">
                                    <h6 class="author"><a href="profile.html">{{user.firstname }} {{user.lastname}}</a></h6>
                                     <span class="post-time">{{user.createdAt}}</span>
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
                                 <p  class="post-desc" >{{service.description}} </p>


                          
                             
                            </div>
                             <div class="post-thumb-gallery img-gallery">
                                    <div class="row no-gutters">
                                        <div class="col-12">
                                             
                                               <figure class="post-thumb" v-if="allservices[k].image.length===1"   >
                                                        <a class="gallery-selector" href="">
                                                            <img :src="require('../../../../../user-photos/'+allservices[k].image[0].imagePath)"  alt="post image">
                                                        </a>
                                                    </figure>
                                                      <carousel-3d  :width="400" :height="200"  v-if="allservices[k].image.length>1">           
                                                        <slide v-for="(img,i) in allservices[k].image" :key="i" :index="i" >
                                                            <template slot-scope="{ index, isCurrent, leftIndex, rightIndex }">
                                                                <img :data-index="index" :class="{ current: isCurrent, onLeft: (leftIndex >= 0), onRight: (rightIndex >= 0) }" :src="require('../../../../../user-photos/'+img.imagePath)">
                                                            </template>
                                                        </slide>
                                                    </carousel-3d>
                                        </div>
                                         
                                    </div>
                                </div>
                                <div class="post-meta">
                                    <!-- <button class="post-meta-like">
                                        <i class="bi bi-heart-beat"></i>
                                        <span>You and 207 people like this</span>
                                        <strong>207</strong>
                                    </button> -->
                                    <ul class="comment-share-meta">
                                        <li>
                                            <button class="post-comment">
                                                <i class="bi bi-chat-bubble"></i>
                                                <span>41</span>
                                            </button>
                                        </li>
                                      
                                    </ul>
                                </div>
                        </div>
                         <div class="modal fade" id="textbox1" aria-labelledby="textbox">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Edit services</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="delactive()">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="name service"  v-model="form.serviceName" >
                                                   <input type="text" class="single-field" placeholder="description"  v-model="form.description" >
                                                                  <i  @click="$refs.f.click()" class="fa fa-camera" style='font-size:24px;'  ></i>
                                                             

                                                    <input type="file" ref="f" @change="uploadFile1"  style="display: none"   multiple>
                                                    <div style="overflow: hidden; display: flex; justify-content:space-around;">
                                                    <div  v-if="uplod===true"  style="overflow: hidden; display: flex; justify-content:space-around;">
                                                    <div v-for="(image, key) in imagesedit" :key="key"  >
                                                        <div>
                                                            <img class="preview1" v-bind:ref="'imageedit' +parseInt( key )" width="100px" height="100px"  /> 
                                                        
                                                        </div>
                                                    </div>
                                                    </div>
                                                    <div v-if="uplod==false "  style="overflow: hidden; display: flex; justify-content:space-around;">
                                                        <div   v-for="(img,i) in form.image" :key="i" >           
                                                       
                                                             <img  :src="require('../../../../../user-photos/'+img.imagePath)">
                                                         
                                                    </div>
                                                    </div>
                                                    </div>
                                           
                                           
                                           
                                           </div>
                                            <div class="modal-footer">
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="update()" >edit
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal" @click="delactive()">cancel</button>
                                               
                                               
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
                                <h4 class="widget-title">Services Request</h4>
                                <div class="widget-body">
                                    <ul class="like-page-list-wrapper">
                                        <li class="unorder-list" v-for="(o,k) in orderconfirm" :key="k">
                                            <!-- profile picture end -->
                                            <div class="profile-thumb">
                                                <a href="#">
                                                    <figure class="profile-thumb-small">
                                                        <img :src="require('../../../../../user-photos/'+o.customer.imagepath)" alt="Avatar" style="width: 60px;height: 45px; border-radius: 50%;" >
                                                    </figure>
                                                </a>
                                            </div>
                                            <!-- profile picture end -->

                                            <div class="unorder-list-info col-lg-9">
                                                     <h6 class="author" v-if="o.customer.firstname!='' &&  o.customer.lastname!=''" >  <router-link :to="{name: 'friendpage', params:{id:o.customer.id}}"  >{{o.customer.firstname }} {{ o.customer.lastname}}</router-link></h6>  
                                      
                                                   <p class=""  >service Name:{{o.serviceModel.serviceName}} </p>
                                      
                                                <!-- <p class="list-subtitle">{{o.servicesModel.servicename}}</p> -->
                                           
                                             
                                          
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




import {Carousel3d,Slide } from 'vue-carousel-3d';

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
                id:'',
                createdAt:'',
                    image:[{
               id:null,
                imagePath:null

           }]
            }
        ],
        orderconfirm: [
            {
                id:null,
                isaccept:null,
                 servicesModel:{
                        serviceName: null,
                        description:null,
                        id:null,
                },
                customer: {
        
                        id:null,
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
                  provider: {
        
                        id:null,
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
        ],
        form:{
                serviceName: '',
                description:'',
                   id:'',
                createdAt:'',
                image:[{
               id:null,
                imagePath:null

           }]
            
        },
               user: {
        
        id:null,
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
        
        },active:[{
            id:null,
            name:null,
            servicesname:null,
        }],
        count:null,
            allimage:[
    [{

           id:null,
           imagePath:null
           }],

       ],
       files: [],
       images:[],
       imagesedit:[],
        msg: [],
              uplod:null,
          
       
       
      
     

      }
    },/* eslint-disable */
    components: {
    Carousel3d,
    Slide
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

              this.getallservices();
                       
              
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
     this.getrequsetorder();   
               /** ------------------------------------------------------------------- */   
this.activity();
// /    ------------------------------------------

   this.$axios.get('/api/friends/count')
              .then(res => {

                  
                    this.count=res.data;
                     console.log("countt",this.count)  ; 
                                   
           
              })
              .catch(
                
                console.log("count errrore")
              )

   
  },
    methods:{
        delactive(){
             this.imagesedit=[];
              this.images=[];
              this.uplod=null;
              this.form={};

        }, 
   uploadFile (event) {
      
           this.images.length=0;
         
        this.files = event.target.files
        var selectedFiles = event.target.files;
        for (let i=0; i < selectedFiles.length; i++){
            this.images.push(selectedFiles[i]);
        }

        for (let i=0; i<this.images.length; i++){
            let reader = new FileReader(); //instantiate a new file reader
            reader.addEventListener('load', function(){
            this.$refs['image' + parseInt( i )][0].src = reader.result;
            }.bind(this), false);  //add event listener

            reader.readAsDataURL(this.images[i]);
        }


        },
            uploadFile1 (event) {
       this.uplod=true;
           this.imagesedit.length=0;
         
        this.files = event.target.files
        var selectedFiles = event.target.files;
        for (let i=0; i < selectedFiles.length; i++){
            this.imagesedit.push(selectedFiles[i]);
        }

        for (let i=0; i<this.imagesedit.length; i++){
            let reader = new FileReader(); //instantiate a new file reader
            reader.addEventListener('load', function(){
            this.$refs['imageedit' + parseInt( i )][0].src = reader.result;
            }.bind(this), false);  //add event listener

            reader.readAsDataURL(this.imagesedit[i]);
        }
          
            console.log("editttimageee",this.editwork.image);

        }, 
  
        services(){
               const formData = new FormData();
          for (const i of Object.keys(this.files)) {
            formData.append('files', this.files[i])
          }
 var currentDate = new Date();
             this.form.createdAt=currentDate;
               this.$axios.post('/api/services/add',this.form)
              .then(res => {

                      console.log("services",  res)
                           let id=res.data;
                        if(id!==0){
                                this.$axios.post('/api/services/addimage/'+id,formData  )
                                .then(resp => {
                                    if(resp.data===true){
                                       
                                    }
                            
                                
                            console.log(resp);
                                })
                 
                        }
                             this.form={};
                                          this.activity();
                                         this.$Toast.fire({
                                            icon: 'success',
                                            title: "successfly Addes"
                                        }) 

                        
                        
                  this.getallservices();
                             



                     
                                          
         

              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )

                
           

        },
      update(){

            const formData = new FormData();
          for (const i of Object.keys(this.files)) {
            formData.append('files', this.files[i])
          }
             this.$axios.put('/api/services/update',this.form)
              .then(res => {

                    console.log("services",res.data)  ; 
                     if(res.data==true){
                                  this.$axios.post('/api/services/updateimage/'+this.form.id,formData  )
                                .then(resp => {
                            
                                        
                                          
                                         this.$Toast.fire({
                                            icon: 'success',
                                            title: "successfly Edit"
                                        }) 
                                    
                            
                                this.activity();
                            console.log(resp);
                                })
                 
                          
                          }
                    this.getallservices();
                             
           
              })
              .catch(
                
                console.log("")
              )

     
               this.message=null;
                var element = document.getElementById("tow");
                  element.classList.add("active");
                  element.classList.add("show");
        }, 
        getallservices(){
               this.$axios.get('/api/services/all')
              .then(resp => {

                    // console.log("all services",res)  ; 
                    // this.allservices=res.data;
                    //  console.log("services",this.allservices)  ; 



                     /////////////////////////////////

                       this.allservices=resp.data[0];
                        console.log(this.allservices,resp.data,"allservices resp")
                       for(let i=0;i<this.allservices.length;i++){

                                  let j=i+1;
                                   
                                    // console.log(this.allwork[i],this.allwork[i].image,"immmmmmmmm resp")
                                     for(let k=0;k<resp.data[j].length;k++){
                                          resp.data[j][k].imagePath=   resp.data[j][k].imagePath.split('\\')[   resp.data[j][k].imagePath.split('\\').length - 3]+'/'+
                                   resp.data[j][k].imagePath.split('\\')[   resp.data[j][k].imagePath.split('\\').length - 2]+'/'+
                                  resp.data[j][k].imagePath.split('\\')[  resp.data[j][k].imagePath.split('\\').length - 1];

 console.log( resp.data[j][k],"image ")
 var m='../../../../../user-photos/'+resp.data[j][k].imagePath;
                                   // this.view.push(m);
                                    
 
                                     }

                                      this.allservices[i].image=resp.data[j]; 
                                      console.log(this.view,this.allservices[i].image,"immmmmmmmm resp")
                       }
                                   
           
              })
              .catch(
                
                console.log("islog errrore")
              )
        },
        edit(id){
             this.form={};
               for(let i=0;i<this.allservices.length;i++){
                 if(this.allservices[i].id===id){
                     this.form=this.allservices[i];
                     console.log("edittttt",this.form);
                     this.uplod=false;
                     
                 }
             }
            
           
          
              

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
               this.getallservices();
                             

        },
        activity(){
              this.$axios.get('/api/services/activity')
              .then(res => {
                  this.active=res.data;
                  let k=0;
                  console.log(res.data,this.active,"activvvv");                 
              })
              .catch(
                
                console.log("active errore")
              )

        },getrequsetorder(){
              this.$axios.get('/api/ordersrequests/allconfirm/')
              .then(res => {
                  
                     res.data.forEach((element,i) => {
               
                     console.log(" req",element)  ; 
                        
                           if(element.customer.imagepath===null){
                             res.data[i].customer.imagepath='1.jpg';


                    }else{
                      res.data[i].customer.imagepath= element.customer.imagepath.split('\\')[element.customer.imagepath.split('\\').length - 2]+'/'+
                        element.customer.imagepath.split('\\')[element.customer.imagepath.split('\\').length - 1];
                    }
             
                    
                  
                      });
                  this.orderconfirm=res.data;
                 
                  console.log(res.data,this.order,"orderrrrrrrrrrconfirmmmm");                 
              })
              .catch(
                
                console.log("active errore")
              )


        },confirm(id){
 
        this.$axios.get('/api/ordersrequests/confirm/'+id)
              .then(res => {
                  if(res.data==true){
                       this.order = this.order.filter(an => {
                  return an.id != id
                })
                       this.$Toast.fire({
                         icon: 'success',
                         title: "successfly Add request services"
                         }) 
                         this.getrequsetorder();
                  }
                  
                                 
              })
              .catch(
                
                console.log("active errore")
              )
        },


/* eslint-disable */



            
    
  }


}
</script>