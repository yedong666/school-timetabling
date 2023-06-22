<template>
  <div>
      <el-table
      :data="userList"
      style="width: 100%;"
       :cell-style="{ color: 'black' }"
        :header-cell-style="{ color: 'black' }">
      class="table">
      <el-table-column
        prop="id"
        label="序号"
        width="80"
        >
      </el-table-column>
      <el-table-column
        prop="account"
        label="账号"
        >
      </el-table-column>
      <el-table-column
        prop="nickname"
        label="昵称">
      </el-table-column>
       <el-table-column
        prop="phoneNumber"
        label="手机号">
      </el-table-column>
       <el-table-column
        prop="email"
        label="邮箱"
        width="180"
        >
      </el-table-column>
       <el-table-column
        prop="role"
        label="角色"
         >
      </el-table-column>
       <el-table-column
        prop="status"
        label="账号状态"
         >
      </el-table-column>
       <el-table-column
        prop="isOnline"
        label="是否在线"
       >
      </el-table-column>
       <el-table-column  width="200">
      <template slot-scope="scope">
        <el-button
          size="mini"
          :type="getKickType(scope.row.isOnline)"
          @click="handleEdit(scope.$index, scope.row)">{{isKick(scope.row.isOnline)}}</el-button>
        <el-button
          size="mini"
          :type="getBanType(scope.row.status)"
          @click="handleDelete(scope.$index, scope.row)">{{isBanIt(scope.row.status)}}</el-button>
      </template>
    </el-table-column>
    </el-table>
  </div>
</template>

<script>


export default {
    name: 'UserListView',
    data(){
        return {
            userList: [],
        }
    },
    mounted(){

    },
     methods: {
      handleEdit(index, row) {
        alert("编辑")
        console.log(index, row);
      },
      handleDelete(index, row) {
        alert("删除")
        console.log(index, row);
      },
      isBanIt(status){
        if(status == "正常") return "封禁此号"
        return "解封此号"
      },
      isKick(isOnline){
        if(isOnline == "在线") return "强制下线"
        return "邀请上线"
      },
      getBanType(status){
        if(status == "正常") return "primary"
        return "danger"
      },
      getKickType(isOnline){
         if(isOnline == "在线") return "warning"
         return "success"
      }

    }
}
</script>

<style scoped>

/*最外层透明*/
::v-deep .el-table,
::v-deep .el-table__expanded-cell {
  background-color: transparent !important;
}
/* 表格内背景颜色 */
::v-deep .el-table th,
::v-deep .el-table tr,
::v-deep .el-table td {
  background-color: transparent !important;
}

    

</style>