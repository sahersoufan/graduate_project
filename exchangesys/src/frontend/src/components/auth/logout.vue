

<template>
<div>
</div>
</template>



<script type="text/javascript">
	
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
   created(){
       console.log("loggggggggout")
       Cookies.remove('access_token', { path: '/' })
          Cookies.remove('refresh_token', { path: '/' })

    Toast.fire({
          icon: 'success',
          title: 'Logout successfully'
        })
   // this.$router.push({ name: '/'})

    window.location.href = "/";

   }
 

}




</script>


<style type="text/css">
	
</style>