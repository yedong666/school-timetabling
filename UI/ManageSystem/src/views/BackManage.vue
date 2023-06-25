<template>
  <div class="container">
    <el-container>
      <el-aside width="18%" class="scroll">
        <div class="title">
            <el-image :src="avater"></el-image><span>{{user.realName}}</span>
        </div>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"

          background-color="#4cbccc"
          text-color="black"
          active-text-color="#ffd04b"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-s-data"></i>
              <span>课时安排</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1" @click="goTo('/manage/dataview')">本周课表</el-menu-item>
              <el-menu-item index="1-2" @click="goTo('/manage/userDataview')">课时列表</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-s-custom"></i>
              <span>排课管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="goTo('/manage/userListView')">综合列表</el-menu-item>
              <el-menu-item index="2-2">搜索用户</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span>教室管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1">教室列表</el-menu-item>
               <el-menu-item index="3-2">教室查询</el-menu-item>
                <el-menu-item index="3-3">标签添加</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-s-help"></i>
              <span>培养计划</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="4-1">添加培养计划</el-menu-item>
              <el-menu-item index="4-2">查询培养计划</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="5"> <i class="el-icon-s-tools"></i>网站设置</el-menu-item>
          <el-menu-item index="6" @click="goTo('/')"> <i class="el-icon-s-home" ></i>返回首页</el-menu-item>
        </el-menu>
      </el-aside>
      <el-main style="padding: 0;">
        <el-container>
          <el-header height="100px" class="head">
            <Background></Background>
          </el-header>
          <el-main class="scroll" style="border-left: 0; height: 86vh;padding:0;overflow:scroll;">
            <router-view></router-view>
          </el-main>
        </el-container>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Background from '@/components/Background.vue'

export default {
  name: 'BackManage',
  data() {
    return {
       user: JSON.parse(localStorage.user),
       avater:'https://img2.baidu.com/it/u=1451684198,866874194&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=625',
    }
  },
  components: {
    Background,
  },
  mounted() {
    let user =  JSON.parse(localStorage.user);
    console.log(user)
  },
  methods:{
    goTo(path){
         this.$router.push({ path: path })
    },

  }
}
</script>

<style scoped>
.el-menu-item {
  margin-left: 30px;
  text-align: left;
  font-size: 20px;
}

.el-menu-item-group .el-menu-item {
  font-size: 16px;
}

span {
  font-size: 20px;
}

.el-submenu {
  text-align: left;
  font-size: 20px;
  margin-left: 30px;
}

.container {
  width: 100%;
  height: 100vh;
  overflow: hidden;
}

.el-header {
  background: #86c9ce;
}

.el-main {
    border: 2px solid #ebebeb;
    overflow: hidden;
}


.el-aside {
  height: 100vh;
    background: #4cbccc;
}

.scroll::-webkit-scrollbar {/*滚动条整体样式*/
        width: 10px;     /*高宽分别对应横竖滚动条的尺寸*/
        height: 1px;
    }
.scroll::-webkit-scrollbar-thumb {/*滚动条里面小方块*/
        border-radius: 10px;
         -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        background: #caccd1;
    }
.scroll::-webkit-scrollbar-track {/*滚动条里面轨道*/
        -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        border-radius: 10px;
        background: #EDEDED;
    }

.title {
    display: flex;
    align-content: center;
    justify-content: center;
  width: 100%;
  height: 100px;
  background: #86c9ce;
  border-bottom: 2px solid #ebebeb;
  margin: 0;
  border: 2px solid #ebebeb;
}

.title .el-image {
  height: 70px;
  width: 70px;
  margin: auto 40px;
  margin-right: 10px;
  border-radius: 100%;
}

.title span{
  text-align: left;
  width: 120px;
  line-height: 100px;
  font-size: 26px;
  padding: 0;
  margin-left: 0;
}
</style>
