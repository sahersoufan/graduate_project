<template>
   <div class="container">
                    <div class="row">
                     
                     
                        <div class="col-lg-8">
                            <div class="card widget-item">
                                    <div class="header-top-navigation">
                                  <nav>
                                <ul>
                                        <li @click="refactor1()"><a href="#one" data-toggle="tab" class="active widget-title">Add Friends</a></li>
                                     <li @click="refactor2()"><a href="#tow" data-toggle="tab"  >Friend Request</a></li>
                                     <li @click="refactor3()"><a href="#three" data-toggle="tab" >All Friend</a></li>

                                    
                            </ul>
                                  </nav>
                                </div>

                                <div class="tab-content">
                                    <div class="tab-pane fade active show" id="one">
                                         <div class="work-zone">
                                          
                                             <div class="content-box friends-zone">
                                <div class="row mt--20 friends-list"  v-if="alluser.length >0">
                                    <div class="col-lg-12 col-sm-6 recently request"  v-for="(oneuser,k) in pageOfItems" :key="k">
                                        
                                        <div class="friend-list-view ">
                                             <div class="profile-thumb ">
                                                <a href="#">
                                                    <figure class="profile-thumb-middle">
                                                        <img v-if="oneuser.imagepath !=''" :src="require('../../../../../user-photos/'+oneuser.imagepath)" alt="profile picture">
                                                    </figure>
                                                </a>
                                            </div>

                                            <div class="col-lg-4">

                                                <h6 class="author" v-if="oneuser.firstname!='' &&  oneuser.lastname!=''" >{{oneuser.firstname}} {{oneuser.lastname}}</h6>
                                                <p class="" v-if="oneuser.description !=''" >{{oneuser.description}} </p>
                                            </div>
                                              <div class="col-lg-8">
                                                 
                                                  <button @click="addfriend(oneuser.id)" class="edit-btn">Add Friend</button>
                                                 
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div v-if="alluser[0].id !==''"  style="margin-left:35%; padding-top: 20px;">
                               
                               
                                    <jw-pagination :pageSize="10" :items="alluser" @changePage="onChangePage" :labels="customLabels"  ></jw-pagination>
                                 
                            
                                </div>
                                  
                                </div>
                                  <div v-if="alluser.length ==0"><strong>There are no user to send friend request</strong></div>
                              
                
                            </div>
                                        
                                           </div>
                                    </div>
                                <div  class="tab-pane fade" id="tow">
                                        <div class="work-zone">
                                          
                                             <div class="content-box friends-zone">
                                <div class="row mt--20 friends-list" v-if="allrequest.length >0">
                                    <div class="col-lg-12 col-sm-6 recently request"  v-for="(request,k) in pageOfrequest" :key="k">
                                        
                                        <div class="friend-list-view ">
                                             <div class="profile-thumb ">
                                                <a href="#">
                                                    <figure class="profile-thumb-middle">
                                                        <img  v-if="request.imagepath!=''" :src="require('../../../../../user-photos/'+request.imagepath)" alt="profile picture">
                                                    </figure>
                                                </a>
                                            </div>

                                            <div class="col-lg-9">

                                                <h6 class="author" v-if="request.firstname !='' && request.lastname !=''" >{{request.firstname}} {{request.lastname}}</h6>
                                                <p class="" v-if="request.description!=''">{{request.description}} </p>
                                            </div>
                                              <div class="col-lg-3">
                                                  <i v-if="request.id != ''" @click="confirm(request.id)" class='fa fa-check' style='font-size:24px ;color:green'></i>&nbsp;&nbsp;
                                          
                                               
                                               <i v-if="request.id != ''" @click="Delete(request.id)" class='fas fa-trash' style='font-size:24px;color:red'></i>
                                             
                                                 
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div v-if="allrequest[0].id !==''" style="margin-left:35%; padding-top: 20px;">
    
                                    <jw-pagination :pageSize="10" :items="allrequest" @changePage="onChangePage2" :labels="customLabels"  ></jw-pagination>
                                </div>
                                
                                  
                                </div>
                                  <div v-if="allrequest.length ==0"><strong>There are no friend requests yet</strong></div>
                              
                            </div>
                                        
                                           </div>
                                    </div>
                                     <div class="tab-pane fade "  id="three">
                                         <div class="work-zone">
                                          
                                             <div class="content-box friends-zone">
                                <div class="row mt--20 friends-list" v-if="allfriend.length >0">
                                    <div class="col-lg-12 col-sm-6 recently request"  v-for="(friend,k) in pageOffriend" :key="k">
                                        
                                        <div class="friend-list-view ">
                                             <div class="profile-thumb ">
                                                <a href="#">
                                                    <figure class="profile-thumb-middle">
                                                        <img  v-if="friend.imagepath!=''" :src="require('../../../../../user-photos/'+friend.imagepath)" alt="profile picture">
                                                    </figure>
                                                </a>
                                            </div>

                                            <div class="col-lg-9">

                                                <h6 class="author" v-if="friend.firstname !='' && friend.lastname !=''" >{{friend.firstname}} {{friend.lastname}}</h6>
                                                <p class="" v-if="friend.description!=''">{{friend.description}} </p>
                                            </div>
                                              <div class="col-lg-3">
                                                
                                           
                                               <i v-if="friend.id != ''" @click="DeleteFriend(friend.id)" class='fas fa-trash' style='font-size:24px;color:red'></i>
                                             
                                                 
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div v-if="allfriend[0].id !==''" style="margin-left:35%; padding-top: 20px;">
    
                                    <jw-pagination :pageSize="10" :items="allfriend" @changePage="onChangePage3" :labels="customLabels"  ></jw-pagination>
                                </div>
                                
                                  
                                </div>
                                  <div v-if="allfriend.length ==0"><strong>There are no friend </strong></div>
                              
                            </div>
                                        
                                           </div>
                                    </div>
                                 
                                
                                    
                                </div>
                            </div>
                        </div>
                         <div class="col-lg-4">
                              <div class="card widget-item" style='position: sticky;'>
                                <div class="about-me">
                                     <h4 class="widget-title">Last Activity</h4>
                                   
                                    <div class="card widget-item">
                                <div class="col-lg-12">

                                                <h6 class="author" v-if="active.length<0 "  > you dont have any activity </h6>
                                              
                                                 
                                            </div>
                                       <div  v-for="(a,k) in active" :key="k">
                                           

                                            <div class="col-lg-12">

                                                <h6 class="author" v-if="a.name==='add' && a.type==='send'"  > send friend request to: </h6>
                                                <p class="" v-if="a.name==='add'  && a.type==='send'" > {{a.friendname}} </p><br>
                                                 <h6 class="author" v-if="a.name==='add' && a.type==='accept'"  > accept friend request to: </h6>
                                                <p class="" v-if="a.name==='add'  && a.type==='accept'" > {{a.friendname}} </p><br>


                                             
                                            
                                            </div>
                                             
                                        </div>
                            </div>
                                </div>
                            </div>
                         </div>
                    </div>
                </div>
</template>


<script>





 import VueUploadMultipleImage from 'vue-upload-multiple-image'
 import Cookies from 'js-cookie'
 import Swal from 'sweetalert2'


const customLabels = {
    first: '<<',
    last: '>>',
    previous: '<',
    next: '>'
};

  export default {

    data() {
      return {
    
        inputs: [
            {
                serviceName: '',
                description:''
            }
        ],
            message:null,
       allrequest: [
            {
               id:'',
             imagepath:'',
          firstname:'',
          lastname:'',
          description:'',
            }
        ],
        alluser:[ 
          {
            id:'',
             imagepath:'',
          firstname:'',
          lastname:'',
          description:'',
        }],
           allfriend:[ 
          {
            id:'',
             imagepath:'',
          firstname:'',
          lastname:'',
          description:'',
        }],
        form:{
                serviceName: '',
                description:'',
                id:''
        },

        customLabels,
        pageOfItems:[],
        pageOfrequest:[],
        pageOffriend:[],
        active:[{
          id:null,
          name:null,
          friendname:null,

        }]
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

          

               this.$axios.post('/api/friendrequest/all')
              .then(res => {

               
             
             
                     res.data.forEach((element,i) => {
               
                     console.log(" req",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.allrequest=res.data;

                 console.log("all request user",this.allrequest)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll request error")
              )

                this.$axios.post('/api/all')
              .then(res => {

                console.log("all user",res.data)  ; 
                 
             
             
             
                   res.data.forEach((element,i) => {
               
                     console.log(" user",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.alluser=res.data;



              
                 console.log("all user",this.alluser)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll user error")
              )


                 this.$axios.post('/api/friends/allfriend')
              .then(res => {

                console.log("all friend",res.data)  ; 
                 
             
             
             
                   res.data.forEach((element,i) => {
               
                     console.log(" friend",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.allfriend=res.data;



              
                 console.log("all friend",this.allfriend)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll user error")
              )

this.activity();

   
  },
    methods:{
     

     onChangePage(pageOfItems) {
            // update page of items
            this.pageOfItems = pageOfItems;
        },
           onChangePage2(pageOfrequest) {
            // update page of items
            this.pageOfrequest = pageOfrequest;
        },
        
           onChangePage3(pageOffriend) {
            // update page of items
            this.pageOffriend = pageOffriend;
        },
        addfriend(id){
          
         
          this.$axios.post('/api/friendrequest/add/'+id)
              .then(res => {

                       if(res.data==true){
                         this.activity();
                             this.$Toast.fire({
                            icon: 'success',
                            title: "send request"
                          })  
                            this.alluser = this.alluser.filter(an => {
                            return an.id != id
                          })


                        }else{
                                this.$Toast.fire({
                                icon: 'error',
                                title: 'Sorry but something wrong'
                            })

                        }
                                   
           
              })
              .catch(
                
                console.log("errore add request friend")
              )
              

        },
        confirm(id){
           this.$axios.post('/api/friends/add/'+id)
              .then(res => {
                this.activity();

                       if(res.data==true){
                             this.$Toast.fire({
                            icon: 'success',
                            title: "add friend"
                          })  
                            this.allrequest = this.allrequest.filter(an => {
                            return an.id != id
                          })

                               this.$axios.post('/api/friendrequest/all')
              .then(res => {

               
             
             
                     res.data.forEach((element,i) => {
               
                     console.log(" req",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.allrequest=res.data;

                 console.log("all request user",this.allrequest)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll request error")
              )

              
                 this.$axios.post('/api/friends/allfriend')
              .then(res => {

                console.log("all friend",res.data)  ; 
                 
             
             
             
                   res.data.forEach((element,i) => {
               
                     console.log(" friend",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.allfriend=res.data;



              
                 console.log("all friend",this.allfriend)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll user error")
              )


                        }else{
                                this.$Toast.fire({
                                icon: 'error',
                                title: 'Sorry but something wrong'
                            })

                        }
                                   
           
              })
              .catch(
                
                console.log("errore add  friend")
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
               this.$axios.delete('/api/friendrequest/delete/'+id)
               .then(() => {
            console.log("deleteee")
                this.allrequest = this.allrequest.filter(an => {
                  return an.id != id
                })
                
                 this.$axios.post('/api/all')
              .then(res => {

                console.log("all user",res.data)  ; 
                 
             
             
             
                   res.data.forEach((element,i) => {
               
                     console.log(" user",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.alluser=res.data;



              
                 console.log("all user",this.alluser)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll user error")
              )
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

               

        },DeleteFriend(id){
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
               this.$axios.delete('/api/friends/delete/'+id)
               .then(() => {
            console.log("deleteee")
                this.allfriend = this.allfriend.filter(an => {
                  return an.id != id
                })
                 this.$axios.post('/api/all')
              .then(res => {

                console.log("all user",res.data)  ; 
                 
             
             
             
                   res.data.forEach((element,i) => {
               
                     console.log(" user",element)  ; 
                        
                           if(element.imagepath===null){
                             res.data[i].imagepath='1.jpg';


                    }else{
                      res.data[i].imagepath= element.imagepath.split('\\')[element.imagepath.split('\\').length - 2]+'/'+
                        element.imagepath.split('\\')[element.imagepath.split('\\').length - 1];
                    }
             
                    console.log("cccccc",element.imagepath);
                  
                      });
                      this.alluser=res.data;



              
                 console.log("all user",this.alluser)  ; 
                                   
           
              })
              .catch(
                
                console.log("alll user error")
              )
               })
               .catch(() => {
               
               })
              
                Swal.fire(
                  'Deleted!',
                  'Your Friend has been deleted.',
                  'success'
                )
              }
            })

        },
        refactor1(){
            this.message=null;
               var element = document.getElementById("tow");
                  element.classList.remove("active");
                  element.classList.remove("show");
                       var element3 = document.getElementById("three");
                  element3.classList.remove("active");
                  element3.classList.remove("show");
                var element2 = document.getElementById("one");
                  element2.classList.add("active");
                  element2.classList.add("show");
                  
              

        },refactor2(){
            this.message=null;
              var element1 = document.getElementById("one");
                  element1.classList.remove("active");
                  element1.classList.remove("show");
                     var element3 = document.getElementById("three");
                  element3.classList.remove("active");
                  element3.classList.remove("show");
                var element = document.getElementById("tow");
                  element.classList.add("active");
                  element.classList.add("show");
            
        },
        refactor3(){
            this.message=null;
              var element1 = document.getElementById("one");
                  element1.classList.remove("active");
                  element1.classList.remove("show");
                       var element3 = document.getElementById("tow");
                  element3.classList.remove("active");
                  element3.classList.remove("show");
                var element = document.getElementById("three");
                  element.classList.add("active");
                  element.classList.add("show");
            
        },     
        activity(){
              this.$axios.get('/api/friendrequest/activity')
              .then(res => {
                  this.active=res.data;
                  let k=0;
                  console.log(res.data,this.active,"activvvv");
                               
              })
              .catch(
                
                console.log("")
              )

        }
/* eslint-disable */



            
    
  }


}
</script>