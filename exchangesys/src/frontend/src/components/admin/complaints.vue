

<template>
 <vue-good-table
      :columns="columns"
      :rows="rows"
       :search-options="{
    enabled: true
  }"
   :pagination-options="{
    enabled: true,
    mode: 'records'
  }"
   @on-cell-click="onCellClick"
  />

</template>



<script type="text/javascript">
	
import Swal from 'sweetalert2'





export default {
   created(){
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
              /**===================================================== */
                   this.$axios.get('/api/complaints/all')
              .then(res => {

                    console.log("complaints",res.data,)  ; 
                   
                  
                      res.data.forEach(item => {
                        this.rows.push({
                            id: item.id,
                            description: item.description,
                            createdAt: item.createdAt ,
                            user: item.user.username,
                             btn: '<i id="del" class="btn fa fa-trash" style="font-size:28px;color:red"></i>',
                           
                        });
                        console.log(item);
                        });
                  
                     
                    
                                  
           
              })
              .catch(
                
                console.log("islog errrore")
              )
   }, data(){
    return {
      columns: [
        {
          label: 'Name',
          field: 'user',
        },
        {
          label: 'Description',
          field: 'description',
 
        },
        {
          label: 'Created On',
          field: 'createdAt',
      
        },
        {
            label: 'Action',
            field: 'btn',
            html: true,
        }
       
      ],
      rows: [
        { id:'', user:' ', description: '', createdAt: '', btn: '', },
 
      ],
    }
   },
   methods: {
       /* eslint-disable */
  onCellClick(params) {

      if(params.event.target.id=='del'){
         console.log("nnnnnnnnnnnnnnnn");
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
               this.$axios.delete('/api/complaints/'+params.row.id)
               .then(() => {
            console.log("deleteee")
                   this.rows = this.rows.filter(an => {
                  return an.id != params.row.id
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
    // params.row - row object 
    // params.column - column object
    // params.rowIndex - index of this row on the current page.
    // params.event - click event
  }
  /* eslint-disable */
}
      
}




</script>


