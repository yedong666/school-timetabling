<template>
  <div class="container">
      <div class="logo"><img src="../assets/avater1.png" /></div>
      <div class="msg"><h1>欢迎使用合肥工业大学601寝室排课系统</h1></div>
  </div>
</template>

<script>
export default {
  name: 'Background',
  data() {
    return {
    }
  },
}
</script>
<style scoped>
  .container{
    display: flex;
    justify-content: center;
  }

  .logo{
    width: 100px;
    height: 100px;
  }

  .logo img{
    width: 100%;
    height: 100%;
  }

  .msg{
    width: 800px;
  }

  h1{  
      line-height: 100px;
       font-size: 40px;
            background-image: linear-gradient(135deg,rgb(0, 195, 255),#e4002b);
            background-clip:text;
            -webkit-background-clip:text;
            color: transparent;
    }
   


</style>
