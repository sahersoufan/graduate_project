<template>
   <div class="container">
                    <div class="row">
                     
                     
                        <div class="col-lg-8">
                            <div class="card widget-item">
                                    <div class="header-top-navigation">
                                  <h4 class="widget-title">Your Work</h4>
                                </div>

                                <div class="tab-content">
                                    <div class="tab-pane fade active show" >

                                         <div class="work-zone">
                                             
                                          
                                <div class="content-box friends-zone">
                                      <div class="row mt--20 ">
                                        <div class="col-lg-11 col-sm-6 " ></div>
                                    <div class="col-lg-1 col-sm-6 " >
                                    <button data-toggle="modal" data-target="#textbox1"  style="margin-right:40%;" aria-expanded="false" id="ember1650" class="artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view artdeco-button artdeco-button--circle artdeco-button--muted artdeco-button--3 artdeco-button--tertiary artdeco-button-dropdown-trigger
                                        " type="button" tabindex="0">
                                        <div class="ivm-image-view-model   ">
                                        <div class="ivm-view-attr__img-wrapper ivm-view-attr__img-wrapper--use-img-tag display-flex
                                        
                                        ">
                                        <li-icon type="plus-icon" size="large" role="img" aria-label="Add new experience"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" data-supported-dps="24x24" fill="currentColor" class="mercado-match" width="24" height="24" focusable="false">
                                    <path d="M21 13h-8v8h-2v-8H3v-2h8V3h2v8h8z"></path>
                                    </svg></li-icon>
                                    </div>
                                    </div>
                                    
                                    </button>
                                    </div>
                                        </div>
                                         <div class="modal fade" id="textbox1" aria-labelledby="textbox">
                                    <div class="modal-dialog modal-dialog-scrollable">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Add Work</h5>
                                                <button type="button" class="close" data-dismiss="modal" @click="delactive()" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="title " v-model="form.name"  >
                                                   <input type="text" class="single-field" placeholder="company name " v-model="form.company"  >
                                                   <input type="text" class="single-field" placeholder="location" v-model="form.location"  >
                                                    <input type="checkbox"  id="checkbox" name="checkbox"  v-model="checkedNames">
                                                    <label for="checkbox"> I am currently working in this role </label><br><br>
                                                    <label> <strong>Start date :</strong>  </label><br>
                                                    
                                                    <input type="date" class="single-field" placeholder="start date" v-model="form.startdate"  >
                                                     <label  v-if="checkedNames ===false " ><strong>End date :</strong> </label><br>
                                                     <input  v-if="checkedNames ===false  "  type="date" class="single-field" placeholder="end date" :rules=[rules.enddate] v-model="form.enddate" >
                                                      <span v-if="msg.enddate">{{msg.enddate}}</span>
                                                   <input type="text" class="single-field" placeholder="description" >
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
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="addwork()" >Submit
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal" @click="delactive()" >cancel</button>
                                               
                                               
                                            </div>
                                        </div>
                                    </div>
                                        </div>

                                 
                                <div class="row mt--20 friends-list">
                                    
                                    <div class="col-lg-12 col-sm-6 recently request"  v-for="(work,k) in allwork" :key="k" >
                                        
                                        <div class="friend-list-view " >
                                            

                                            <div class="col-lg-10">

                                                <h6 style="text-align : center" class="author" v-if="work.name!=null"> Title : {{work.name}}</h6><br>
                                                <p class="" v-if="work.company!=null " > <strong>Company Name</strong>  {{ work.company}} </p>
                                                  <p class="" v-if="  work.location !=null" > <strong>Location</strong> {{work.location}} </p>
                                                 <p class="" v-if="work.startdate!=null "  ><strong> Start Date:</strong> {{ work.startdate}}  </p>
                                                  <p class="" v-if="work.enddate!=null && work.startdate!=null"  ><strong> End Date:</strong> {{ work.enddate}}  </p>
                                                  <p class="" v-if="work.enddate==null && work.startdate!=null"  > <strong> End Date:</strong>  Present </p>
                                                    <p class="" v-if="work.description!=null "  ><strong>Description:</strong> </p>
                                                  <p class="" v-if="work.description!=null "  > {{work.description}} </p>
                                           
                                            <div class="row">
                                             
                                                <!--  eslint-disable   -->
                                                        <carousel-3d  :width="200" :height="100">           
                                                        <slide v-for="(img,i) in allwork[k].image" :key="i" :index="i" >
                                                            <template slot-scope="{ index, isCurrent, leftIndex, rightIndex }">
                                                                <img :data-index="index" :class="{ current: isCurrent, onLeft: (leftIndex >= 0), onRight: (rightIndex >= 0) }" :src="require('../../../../../user-photos/'+img.imagePath)">
                                                            </template>
                                                        </slide>
                                                    </carousel-3d>
                                                    <!--  eslint-disable   -->
                                                </div> 
                                           </div>
                                               <div class="col-lg-2">

                                                  <i @click="edit(work.id)"   data-toggle="modal" data-target="#textbox2"  class=' 	fas fa-pencil-alt' style='font-size:24px ;'></i>&nbsp;&nbsp;
                                          
                                               
                                               <i  @click="Delete(work.id)" class='fas fa-trash' style='font-size:24px;color:red'></i>
                                             
                                                 
                                                
                                            </div>
                                        </div>

                                 
                                    </div>
                                
                             
                             
                                  
                                </div>

                                             <div class="modal fade" id="textbox2" aria-labelledby="textbox">
                                    <div class="modal-dialog modal-dialog-scrollable">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Edit Work</h5>
                                                <button type="button" class="close" data-dismiss="modal" @click="delactive()" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body custom-scroll signup-inner--form">
                                                   <input type="text" class="single-field" placeholder="title " v-model="editwork.name"  >
                                                   <input type="text" class="single-field" placeholder="company name " v-model="editwork.company"  >
                                                   <input type="text" class="single-field" placeholder="location" v-model="editwork.location"  >
                                                    <input type="checkbox"  id="checkbox" name="checkbox"  v-model="checkedNames">
                                                    <label for="checkbox"> I am currently working in this role </label><br><br>
                                                    <label> <strong>Start date :</strong>  </label><br>
                                                    
                                                    <input type="date" class="single-field" placeholder="start date" v-model="editwork.startdate"  >
                                                     <label  v-if="checkedNames ===false " ><strong>End date :</strong> </label><br>
                                                     <input  v-if="checkedNames ===false  "  type="date" class="single-field" placeholder="end date" :rules=[rules.enddate] v-model="editwork.enddate" >
                                                      <span v-if="msg.enddate">{{msg.enddate}}</span>
                                                   <input type="text" class="single-field" placeholder="description" >
                                                    <i  @click="$refs.f.click()" class="fa fa-camera" style='font-size:24px;'  ></i>
                                                             

                                                    <input type="file" ref="f" @change="uploadFile1"  style="display: none"   multiple>
                                                    <div style="overflow: hidden; display: flex; justify-content:space-around;">
                                                    <div v-if="uplod===true" v-for="(image, key) in imagesedit" :key="key"  >
                                                        <div>
                                                            <img class="preview1" v-bind:ref="'imageedit' +parseInt( key )" width="100px" height="100px"  /> 
                                                        
                                                        </div>
                                                    </div>
                                                        <div v-if="uplod==false"  v-for="(img,i) in editwork.image" :key="i" >           
                                                       
                                                             <img  :src="require('../../../../../user-photos/'+img.imagePath)">
                                                         
                                                    </div>
                                                    </div>
                                            </div>
                                            <div class="modal-footer">
                                                  <button type="button" class="post-share-btn" data-dismiss="modal"  @click="update(editwork.id)" >Edit
                                                    <span aria-hidden="true"></span>
                                                </button>
                                                <button type="button" class="post-share-btn" data-dismiss="modal" @click="delactive()" >cancel</button>
                                               
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                
                               
                
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
                                     <div class="col-lg-9">

                                                <h6 class="author" v-if="active.length<0 "  > you dont have any activity </h6>
                                              
                                                 
                                            </div>
                                       <div class="friend-list-view "  v-for="(a,k) in active" :key="k">
                                           

                                            <div class="col-lg-9">

                                                <h6 class="author" v-if="a.name==='add' "  > you add anew Work </h6>
                                                <p class="" v-if="a.name==='add'" >Title Work: {{a.title}} </p>

                                                 <h6 class="author" v-if="a.name==='edit' "  > you edit information previos Work </h6>
                                                <p class="" v-if="a.name==='edit'" >Title Work: {{a.title}} </p>
                                            
                                            </div>
                                             
                                        </div>
                                   
                         
                                </div>
                            </div>
                         </div>
                    </div>
                </div>
</template>


<script>
import {Carousel3d,Slide } from 'vue-carousel-3d';

  export default {

    data() {
      return {
        
       message:null,
     
       checkedNames:true,
       form:{
           id:null,
           name:null,
           company:null,
           location:null,
           startdate:null,
           enddate:null,
           
       },
         allwork:[{
           id:null,
           name:null,
           company:null,
           location:null,
           startdate:null,
           enddate:null,
           image:[{
               id:null,
                imagePath:'hh'

           }]
           
       }],
           editwork:{
           id:null,
           name:null,
           company:null,
           location:null,
           startdate:null,
           enddate:null,
           image:[{
               id:null,
                imagePath:null

           }]
           
       },
       
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
      rules: {
      enddate() {
          if(this.form.enddate<this.form.selectedFiles)
        return 'Invalid';
      }
           },
           uplod:null,
           active:[{
               id:null,
               name:null,
               id_work:null,
               title:null,
           }],
    
      
     

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

              /** ------------------------------------------------------------------- */
               this.getAllwork();
               this.activity();
  
               /** ------------------------------------------------------------------- */   
   
  }, watch: {
    enddate(value){
        if(this.form.startdate>this.form.enddate){
            this.msg['enddate'] = 'Invalid End Date';
            value=null;
        }else{
            this.enddate=value;
        }
   
    }
  },
    methods:{
        delactive(){
             this.imagesedit=[];
              this.images=[];
              this.uplod=null;

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
    addwork() {
        const formData = new FormData();
          for (const i of Object.keys(this.files)) {
            formData.append('files', this.files[i])
          }
        
     

                this.$axios.post('/api/work/add',this.form)
                    .then(resp => {
                        console.log(resp.data,"iddddd")
                        let id=resp.data;
                            this.$axios.post('/api/work/addimage/'+id,formData  )
                                .then(resp => {
                                    if(resp.data===true){
                                         this.getAllwork();
                                          this.activity();
                                         this.$Toast.fire({
                                            icon: 'success',
                                            title: "successfly Addes"
                                        }) 
                                    }else{
                                           this.$Toast.fire({
                                            icon: 'error',
                                            title: 'Sorry but something wrong'
                                        })
                                    }
                            
                                
                            console.log(resp);
                                })
                 
                       
                   console.log(resp);
                    })

              
         this.getAllwork();
                                          this.activity();
          },
    getAllwork(){
        this.$axios.get('/api/work/all')
                    .then(resp => {
                        this.allwork=resp.data[0];
                        console.log(this.allwork,resp.data,"allllwork resp")
                       for(let i=0;i<this.allwork.length;i++){

                                  let j=i+1;
                                   
                                    // console.log(this.allwork[i],this.allwork[i].image,"immmmmmmmm resp")
                                     for(let k=0;k<resp.data[j].length;k++){
                                          resp.data[j][k].imagePath=   resp.data[j][k].imagePath.split('\\')[   resp.data[j][k].imagePath.split('\\').length - 3]+'/'+
                                   resp.data[j][k].imagePath.split('\\')[   resp.data[j][k].imagePath.split('\\').length - 2]+'/'+
                                  resp.data[j][k].imagePath.split('\\')[  resp.data[j][k].imagePath.split('\\').length - 1];

 console.log( resp.data[j][k],"image ")
                                     }
                                      this.allwork[i].image=resp.data[j]; 
                                      console.log(this.allwork[i],this.allwork[i].image,"immmmmmmmm resp")
                            
                 
                             
                           
                
                            // })
                       }
//                  
                      
        
                    })

                         
              

    },
    edit(id){
             
             for(let i=0;i<this.allwork.length;i++){
                 if(this.allwork[i].id===id){
                     this.editwork=this.allwork[i];
                     console.log("edittttt",this.editwork);
                     this.uplod=false;
                     
                 }
             }
    },update(id){
          const formData = new FormData();
          for (const i of Object.keys(this.files)) {
            formData.append('files', this.files[i])
          }
         this.$axios.put('/api/work/update',this.editwork)
              .then(res => {

                    console.log("updatework",res.data)  ; 
                     if(res.data==true){
                          this.$axios.post('/api/work/updateimage/'+this.editwork.id,formData  )
                                .then(resp => {
                                    if(resp.data===true){
                                         this.getAllwork();
                                          this.activity();
                                         this.$Toast.fire({
                                            icon: 'success',
                                            title: "successfly Edit"
                                        }) 
                                    }else{
                                           this.$Toast.fire({
                                            icon: 'error',
                                            title: 'Sorry but something wrong'
                                        })
                                    }
                            
                                
                            console.log(resp);
                                })
                 
                           }
                    
                             
           this.getAllwork();
                                          this.activity();
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
               this.$axios.delete('/api/work/delete/'+id)
               .then(() => {
            console.log("deleteee")
                this.allwork = this.allwork.filter(an => {
                  return an.id != id
                })
                this.activity();
               })
               .catch(() => {
               
               })
              
                Swal.fire(
                  'Deleted!',
                  'Your Work has been deleted.',
                  'success'
                )
              }
            })

        },
        activity(){
              this.$axios.get('/api/work/activity')
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

