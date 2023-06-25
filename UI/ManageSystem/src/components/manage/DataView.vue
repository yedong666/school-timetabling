<template>
  <div class="timetables-con">
    <div id="timetables">
    </div>
    <div class="timetables-menu">
      <el-button @click="nextWeekTimeTables" style="margin: 10px">
        上周课表
      </el-button>
      <el-button @click="nextWeekTimeTables" style="margin: 10px">
        下周课表
      </el-button>
    </div>
  </div>
</template>

<script>
import Timetables from 'timetables'
export default {
  data() {
  },
 mounted() {
   const timetables = [
     ['大学英语(Ⅳ)@10203','大学英语(Ⅳ)@10203','','','','','毛概@14208','毛概@14208','','','选修','选修'],
     ['','','信号与系统@11302','信号与系统@11302','模拟电子技术基础@16204','模拟电子技术基础@16204','','','','','',''],
     ['大学体育(Ⅳ)','大学体育(Ⅳ)','形势与政策(Ⅳ)@15208','形势与政策(Ⅳ)@15208','','','电路、信号与系统实验','电路、信号与系统实验','','','',''],
     ['','','','','电装实习@11301','电装实习@11301','','','大学体育','大学体育','',''],
     ['','','数据结构与算法分析','数据结构与算法分析','','','','','信号与系统','信号与系统','',''],
   ];
   const timetableType = [
     [{index: '第一节',name: '8:00 - 8:50'}, 1],
     [{index: '第二节',name: '9:00 - 9:50'}, 1],
     [{index: '第三节',name: '10:10 - 11:00'}, 1],
     [{index: '第四节',name: '11:10 - 12:00'}, 1],
     [{index: '第五节',name: '14:00 - 14:50'}, 1],
     [{index: '第六节',name: '15:00 - 15:50'}, 1],
     [{index: '第七节',name: '16:00 - 16:50'}, 1],
     [{index: '第八节',name: '17:00 - 17:50'}, 1],
     [{index: '第九节',name: '19:00 - 19:50'}, 1],
     [{index: '第十节',name: '20:00 - 20:50'}, 1],
     [{index: '第十一节',name: '21:00 - 21:50'}, 1],
     [{index: '第十二节',name: '22:00 - 22:50'}, 1]
   ];
   const week =  ['周一', '周二', '周三', '周四', '周五'];
   const highlightWeek = new Date().getDay();
   const styles = {
     Gheight: 50,
     leftHandWidth: 120,
     palette: ['#dedcda', '#ff4081']
   };

// 实例化(初始化课表)
   const timetable = new Timetables({
     el: '#timetables',
     timetables: timetables,
     week: week,
     timetableType: timetableType,
     highlightWeek: highlightWeek,
     setOption:function onChange() {
       Timetable.setOption({
         timetables: courseListOther,
         week: ['一', '二', '三', '四', '五', '六', '日'],
         styles:{
           palette: ['#dedcda', '#ff4081']
         },
         timetableType:courseType,
         gridOnClick: function (e) {
           console.log(e)
         }})
     },
     gridOnClick: function (e) {
       alert(e.name + '  ' + e.week +', 第' + e.index + '节课, 课长' + e.length +'节')
       console.log(e)
     },
     styles: styles
   });
 },
  methods:{
    nextWeekTimeTables(){
      alert("获取下周课表")
    }
  }

}
</script>

<style >

.timetables-con{
  display: flex;
  align-content: space-around;
}

#timetables{
  width: 80%;
   /*background: white;*/

}

.Courses-head > div {
  border-left: none !important;
}

.Courses-leftHand > div {
  padding-top: 5px;
  border-bottom: 1px dashed rgb(219, 219, 219);
}

.Courses-leftHand > div:last-child {
  border-bottom: none !important;
}

.left-hand-TextDom, .Courses-head {
  border-bottom: 1px solid rgba(0, 0, 0, 0.1) !important;
}

.Courses-content > ul {
  border-bottom: 1px dashed rgb(219, 219, 219);
  box-sizing: border-box;
}

.Courses-content > ul:last-child {
  border-bottom: none !important;
}

.highlight-week {
  color: #02a9f5 !important;
}

.Courses-content li {
  text-align: center;
  color: #666666;
  font-size: 14px;
  line-height: 50px;
}

.Courses-content li span {
  padding: 6px 2px;
  box-sizing: border-box;
  line-height: 18px;
  border-radius: 4px;
  white-space: normal;
  word-break: break-all;
  cursor: pointer;
}

.grid-active span {
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
}

.timetables-menu{
  width: 20%;
  display: flex;
  flex-direction: column;
}


</style>
