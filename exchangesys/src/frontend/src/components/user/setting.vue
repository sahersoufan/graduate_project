<template>
   <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="card widget-item">
                                <div class="about-me">
                                    <ul class="nav flex-column about-author-menu">
                                        <li><a href="#one" data-toggle="tab" class="active">Edit Basic Information</a></li>
                                        
                                        <li><a href="#three" data-toggle="tab">Add Work</a></li>
                                        <li><a href="#four" data-toggle="tab">Change Password </a></li>
                                        <li><a href="#five" data-toggle="tab">Contact Details</a></li>
                                        <li><a href="#six" data-toggle="tab">complaints</a></li>
                                    
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="about-description">
                                <div class="tab-content">
                                    <div class="tab-pane fade active show" id="one">
                                        <div class="work-zone">
                                              <div class="author-desc-title d-flex">
                                                <h6 class="author"><a href="">Edit Basic Information</a></h6>
                                             
                                            </div>
                                                    <form class="signup-inner--form" method="post"  @submit.prevent="update">
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
                                                            
                                                            <div class="col-md-6">
                                                                <select class="nice-select" name="sortby" v-model="form.gender">
                                                    
                                                                <option v-bind:value="Male">Male</option>
                                                                <option v-bind:value="Female">Female</option>
                                                                </select>
                                                            </div>
                                                                <div class="col-md-6">
                                                                <input type="text" class="single-field" placeholder="Phone" v-model="form.phone" >
                                                            </div>



                                                                <div class="col-12">
                                                                <textarea  class="single-field" placeholder="Say Somthing About Your Self" v-model="form.description"> </textarea>
                                                            </div>
                                                            <div class="col-md-8">
                                                                
                                                            </div>
                                    
                                                            <div class="col-md-4">
                                                                <button class="submit-btn " style="border-radius: 5%;">Update</button>
                                                            </div>
                                                        
                                                            </div>
                                                    </form>
                                            
                                        </div>
                                    </div>
                                
                                    <div class="tab-pane fade" id="three">
                                        <div class="work-zone">
                                            <div class="author-desc-title d-flex">
                                                <h6 class="author"><a href="#">Add Work</a></h6>
                                               
                                            </div>
                                               <form class="signup-inner--form" method="post"  @submit.prevent="">
                                                            <div class="row">
                                                            
                                                               <div class="col-12">
                                                                <textarea  class="single-field" placeholder="say somthing about ypur work"> </textarea>
                                                            </div>
                                                            
                                                                  <div class="col-md-8" >
                                                                
                                                                          <vue-upload-multiple-image 
                                                                                    @upload-success="uploadImageSuccess"
                                                                                    @edit-image="editImage"
                                                                                    @mark-is-primary="markIsPrimary"
                                                                                    @limit-exceeded="limitExceeded"
                                                                                    @before-remove="beforeRemove"
                                                                                    id-upload="myIdUpload"
                                                                                    id-edit="myIdEdit"
                                                                                    :max-image=20
                                                                                    primary-text="Default"
                                                                                    browse-text="Browse picture(s)"
                                                                                    drag-text="Drag pictures"
                                                                                    mark-is-primary-text="Set as default"
                                                                                    popup-text="This image will be displayed as default"
                                                                                    :multiple=true
                                                                                    :show-edit=true
                                                                                    :show-delete=true
                                                                                    :show-add=true
                                                                                >
                                                                                </vue-upload-multiple-image>
                                                            </div>
                                                            
                                                            
                                                                <div class="col-md-6">
                                                              
                                                                </div>



                                                            
                                                            <div class="col-md-8">
                                                                
                                                            </div>
                                    
                                                            <div class="col-md-4">
                                                                <button class="submit-btn " style="border-radius: 5%;">Submit</button>
                                                            </div>
                                                        
                                                            </div>
                                                    </form>


                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="four">
                                        <div class="work-zone">
                                            <div class="author-desc-title d-flex">
                                                <h6 class="author"><a href="#">Change Password </a></h6>
                                              
                                            </div>
                                            <form class="signup-inner--form" method="post"  @submit.prevent="changepassword">
                                                            <div class="row">
                                                            <div class="col-12 ">
                                                                <label for="password"></label><input type="password" placeholder="Old Password" id="password" name="password" class="single-field" v-model="password.old" >
                                                            </div>
                                                                <div class="col-12 ">
                                                                <input type="password" placeholder="New Password"  name="password" class="single-field" v-model="password.new" >
                                                            </div>
                                                                <div class="col-12 ">
                                                                <input type="password" placeholder="Confirm Password"  name="password" class="single-field" v-model="password.confirm" >
                                                            </div>
                                                            
                                                       
                                                             
                                                            <div class="col-md-8">
                                                                
                                                            </div>
                                    
                                                            <div class="col-md-4">
                                                                <button class="submit-btn " style="border-radius: 5%;">Update</button>
                                                            </div>
                                                        
                                                            </div>
                                                    </form>
                                           </div>
                                    </div>
                                    <div class="tab-pane fade" id="five">
                                        <div class="work-zone">
                                            <div class="author-desc-title d-flex">
                                                <h6 class="author"><a href="#">Contact Details</a></h6>
                                            
                                            </div>
                                               <form class="signup-inner--form" method="post"  @submit.prevent="">
                                                            <div class="row">
                                                         
                                                          <div class="col-12 col-sm">
                                                                <input type="text" placeholder="Facebook"   class="single-field" >
                                                            </div>
                                                            <div class="col-12 col-sm">
                                                                <input type="text" placeholder="Google"   class="single-field" >
                                                            </div>
                                                            <div class="col-12 col-sm">
                                                                <input type="text" placeholder="Twitter"  class="single-field" >
                                                            </div>
                                                            <div class="col-12 col-sm">
                                                                <input type="text" placeholder="Linkedin"  class="single-field" >
                                                            </div>
                                                            
                                                       
                                                             
                                                            <div class="col-md-8">
                                                                
                                                            </div>
                                    
                                                            <div class="col-md-4">
                                                                <button class="submit-btn " style="border-radius: 5%;">Update</button>
                                                            </div>
                                                        
                                                            </div>
                                                    </form>
                                      </div>
                                    </div>
                                
                                          <div class="tab-pane fade" id="six">
                                        <div class="work-zone">
                                            <div class="author-desc-title d-flex">
                                                <h6 class="author"><a href="#">complaints </a></h6>
                                              
                                            </div>
                                            <form class="signup-inner--form" method="post"  @submit.prevent="savecomplaints">
                                                            <div class="row">
                                                         
                                                            
                                                        <div class="col-12">
                                                                <textarea  class="single-field" placeholder="please explain your problem" v-model="complaints.description"> </textarea>
                                                            </div>
                                                             
                                                            <div class="col-md-8">
                                                                
                                                            </div>
                                    
                                                            <div class="col-md-4">
                                                                <button class="submit-btn " style="border-radius: 5%;">Submit</button>
                                                            </div>
                                                        
                                                            </div>
                                                    </form>
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
          gender:null,
          phone:null,
          description:null,
        }, 
         Male:"male",
        Female:"female",
        inputs: [
            {
                serviceName: '',
                description:''
            }
        ],
        password:{
            old:null,
            new:null,
            confirm:null,

        },complaints:{
             description:'',
             createdAt:'',
        }
       
      
     

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

              /** ------------------------------------------------------------------- */
                var username= Cookies.get('user')
             
                this.form.username=username;

                this.$axios.post('/api/getuser',this.form)
                .then(res => {
                    console.log("ress",res)
                    this.form=res.data;

                console.log("ttttttttttt",this.form,res.data)
                })
                .catch(
                    console.log("errorrrr")    
                )
  
               /** ------------------------------------------------------------------- */   
   
  },
    methods:{
     

        add(index) {
            this.inputs.push({ serviceName: '',description:'' });
        },
        remove(index) {
            this.inputs.splice(index, 1);
        },
        /* eslint-disable */
         uploadImageSuccess(formData, index, fileList) {
	      console.log('data', formData, index, fileList)
	      // Upload image api
	      // axios.post('http://your-url-upload', formData).then(response => {
	      //   console.log(response)
	      // })
	    },
	    beforeRemove(index, removeCallBack) {
	      console.log('index', index)
	      var r = confirm("remove image")
	      if (r == true) {
	        removeCallBack()
	      }
	    },
	    editImage(formData, index, fileList) {
	      console.log('edit data', formData, index, fileList)
	    },
	    markIsPrimary(index, fileList){
	      console.log('markIsPrimary data', index, fileList)
	    },
	    limitExceeded(amount){
	      console.log('limitExceeded data', amount)
	    },
        update(){
              this.$axios.post('/api/user/update',this.form)
              .then(res => {

                      console.log("update",  res)
                        //  User.responseAfterLogin(res)
                          this.$Toast.fire({
                            icon: 'success',
                            title: "successfly Update"
                          })  
                           this.$router.push({ name: 'setting'})                    
         

              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )
           


        },
        changepassword(){

            if(this.password.new===this.password.confirm){
            
            this.$axios.post('/api/user/changepass',this.password)
              .then(res => {

                      console.log("change",  res)
                        //  User.responseAfterLogin(res)
                        if(res.data==true){
                             this.$Toast.fire({
                            icon: 'success',
                            title: "successfly Change"
                          })  
                           this.$router.push({ name: 'logout'})   

                        }else{
                                this.$Toast.fire({
                                icon: 'warning',
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
           

            }else{
                 this.$Toast.fire({
                        icon: 'warning',
                        title: 'Password does not match'
                      })
            }

        },
        services(){

               this.$axios.post('/api/services/save',this.inputs)
              .then(res => {

                      console.log("services",  res)
                        //  User.responseAfterLogin(res)
                        if(res.data==true){
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
                                          
         

              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )
           

        },savecomplaints(){
             var currentDate = new Date();
             this.complaints.createdAt=currentDate;
              this.$axios.post('/api/complaints/save',this.complaints)
              .then(res => {

                      console.log("complaints",  res)
                        //  User.responseAfterLogin(res)
                          this.$Toast.fire({
                            icon: 'success',
                            title: "successfully submit"
                          })  
                           location.reload();                  
         

              })
              .catch(
                      this.$Toast.fire({
                        icon: 'warning',
                        title: 'Sorry but something wrong'
                      })
              )

        }
/* eslint-disable */



            
    
  }


}
</script>