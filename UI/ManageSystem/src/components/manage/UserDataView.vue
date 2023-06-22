<template>
  <div class="topCon">
    <div class="container" style="border-right: 2px solid #dcdfe6;">
        <h1>用户年龄分布</h1>
        <div style="width: 100%;">
            <canvas id="myChart2"></canvas>
        </div>
    </div>
    <div class="container" >
      <div class="con" style="width: 60%; margin: auto">
        <canvas id="myChart1"></canvas>
        <h1 style="margin:10px auto">用户角色分布</h1>
      </div>
      <el-divider></el-divider>
      <div class="con">
        <canvas id="myChart3"></canvas>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'UserDataView',
  data() {
    return {}
  },
}
</script>

<style scoped>

h1{
    text-align: center;
    font-size: 25px;
    padding: 0;
    height: 40px;
    margin: 30px auto;
    margin-bottom: 20px;
    background-image: linear-gradient(135deg,#e4002b, rgb(0, 195, 255));
            background-clip:text;
            -webkit-background-clip:text;
            color: transparent;
}

.topCon {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 100%;
  height: 100%;
}
.container {
  display: flex;
  align-content: flex-start;
  width: 49%;
  height: 800px;
  margin-top: 10px;
  flex-wrap: wrap;

}

.con {
  width: 100%;
  height: 50%;
  margin: auto;
}
</style>
