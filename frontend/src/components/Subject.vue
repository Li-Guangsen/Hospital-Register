<template>
  <div>
    <!-- 检索区查询表单 -->
    <div class="search">
      <el-form :inline="true" ref="searchFromRef" :model="sm">
        <!-- 表单项 -->
        <el-form-item label="主键" prop="id">
          <el-input placeholder="请输入ID" v-model="sm.id" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input placeholder="请输入科室名称" v-model="sm.name" />
        </el-form-item>
        <el-form-item label="代码" prop="subCode">
          <el-input placeholder="请输入科室代码" v-model="sm.subCode" />
        </el-form-item>
        <!-- <el-form-item label="负责医师" prop="dutyDoctor">
          <el-input placeholder="请输入医师姓名" v-model="sm.dutyDoctor" />
        </el-form-item> -->
        <el-form-item label="地址" prop="address">
          <el-input placeholder="请输入地址" v-model="sm.address" />
        </el-form-item>
        <el-form-item label="晚于日期筛选" prop="createTime">
          <el-date-picker
            v-model="sm.createTime"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请输入日期"
            :width="650"
          />
        </el-form-item>
      </el-form>
    </div>
    <!-- 操作区 -->
    <div class="operate">
      <el-button type="primary" @click="add" :icon="Plus">新增</el-button>
      <el-button type="primary" @click="search" :icon="Search">查询</el-button>
      <el-button type="primary" @click="resetSearch" :icon="Refresh"
        >重置</el-button
      >
    </div>

    <!-- 数据展示区 -->
    <div class="data">
      <!-- 表格 -->
      <div class="grid" style="margin-top: 5px">
        <el-table
          :data="tableData"
          border
          style="width: 100%"
          :header-cell-style="headercellStyle"
        >
          <el-table-column prop="id" label="ID" width="60" sortable />
          <el-table-column prop="name" label="科室名称" width="120" />
          <el-table-column prop="subCode" label="科室代码" width="100" />
          <!-- <el-table-column prop="dutyDoctor" label="负责医师" width="100" /> -->
          <el-table-column prop="address" label="科室地址" width="100" />
          <el-table-column prop="createTime" label="创立日期" width="110" />
          <el-table-column
            prop="about"
            label="历程"
            width="470"
            show-overflow-tooltip
          />
          <el-table-column
            prop="description"
            label="简介"
            width="470"
            show-overflow-tooltip
          />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button size="small" @click="editRow(scope.row)">
                Edit
              </el-button>
              <el-button
                size="small"
                type="danger"
                @click="deleteRow(scope.row)"
              >
                Delete
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!-- 分页 -->
      <div class="pagination" style="margin: 5px">
        <el-pagination
          v-model:current-page="pi.pageNo"
          v-model:page-size="pi.pageSize"
          :page-sizes="[5, 10, 15, 30, 50, 100]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="pi.total"
          background
          @change="paginate"
        />
      </div>
    </div>
    <!-- 新增对话框 -->
    <el-dialog
      v-model="show"
      :title="dialogTitle"
      width="640"
      draggable
      :close-on-click-modal="false"
      @closed="close"
    >
      <!-- 新增操作表单 -->
      <el-form :model="sfm" ref="sfRef">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="科室代码:" label-width="100" prop="subCode">
              <el-input v-model="sfm.subCode" placeholder="请输入科室代码" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="科室名称:" label-width="100" prop="name">
              <el-input
                v-model="sfm.name"
                placeholder="请输入科室名称"
              /> </el-form-item
          ></el-col>
        </el-row>
        <el-row :gutter="20">
          <!-- <el-col :span="11"
            ><el-form-item label="负责医师:" label-width="45" prop="dutyDoctor">
              <el-input
                v-model="sfm.dutyDoctor"
                placeholder="请输入负责医师"
              /> </el-form-item
          ></el-col> -->
          <el-col :span="12"
            ><el-form-item
              label="创立日期:"
              label-width="100"
              prop="createTime"
            >
              <el-date-picker
                v-model="sfm.createTime"
                type="date"
                placeholder="请输入创立日期"
                value-format="YYYY-MM-DD"
                :width="650"
              /> </el-form-item
          ></el-col>
          <el-col :span="12"
            ><el-form-item label="地址:" label-width="100" prop="address">
              <el-input
                v-model="sfm.address"
                placeholder="请输入科室地址"
              /> </el-form-item
          ></el-col>
        </el-row>
        <el-form-item label="历程:" label-width="60" prop="about">
          <el-input
            v-model="sfm.about"
            :rows="8"
            type="textarea"
            placeholder="请输入历程"
          />
        </el-form-item>
        <el-form-item label="简介:" label-width="60" prop="description">
          <el-input
            v-model="sfm.description"
            :rows="8"
            type="textarea"
            placeholder="请输入简介"
          />
        </el-form-item>
      </el-form>
      <!-- 对话框按钮 # 插槽 -->
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="show = false">取消</el-button>
          <el-button type="primary" @click="submitForm"> 确认 </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import { Plus, Delete, Edit, Refresh, Search, Share, Upload, } from '@element-plus/icons-vue'
import { findAll as apiFindAll, deleteById as apiDeleteById, save as apiSave, update as apiUpdate } from "../api/SubjectApi"
import { nextTick, onMounted, ref, toRaw } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

//当组件加载完成后，自动调用findAll方法
onMounted(async () => {
  search()
  document.title = '科室管理'
})
const tableData = ref()
// 前两项是双向数据绑定
const pi = ref({
  pageNo: 1,
  pageSize: 5,
  total: 1000
})
async function search () {
  let params = sm.value
  // console.log(params)
  let resp = await apiFindAll(pi.value.pageNo, pi.value.pageSize, params)
  //   console.log(resp)
  tableData.value = resp.rows
  pi.value = resp.pi
}
function paginate () {
  console.log(pi.value.pageNo, pi.value.pageSize)
  search()
}
//查询条件引用
const sm = ref({
  id: '',
  subCode: '',
  name: "",
  dutyDoctor: "",
  address: "",
  createTime: "",
})
//查询表单实例引用
let searchFromRef
function resetSearch () {
  searchFromRef.resetFields()
}
function submitForm () {
  let stu = toRaw(sfm.value)
  if (stu.id && stu.id != '') {//修改
    submitEdit(stu)
  } else {//添加
    submitAdd(stu)
  }
}
function deleteRow (row) {
  let id = row.id
  console.log(id)
  deleteById(id)
}
function deleteById (id) {
  ElMessageBox.confirm(
    '是否确认删除选中科室数据?',
    '删除确认',
    {
      type: 'warning',
    }
  ).then(async () => {//点击确认
    let resp = await apiDeleteById(id)
    if (resp.success) {
      ElMessage({
        type: 'success',
        message: '删除成功',
      })
      search()
    }
    else {
      ElMessage({
        message: '删除失败',
        type: 'warning',
      })
    }
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '删除取消',
    })
  })
}
const show = ref(false)//控制对话框是否显示
function editRow (row) {
  //克隆防止修改数据时影响原数据
  row = Object.assign({}, row)
  // console.log(row)
  show.value = true
  dialogTitle.value = '修改科室信息'
  nextTick(() => {
    sfm.value = row
  })
}
async function submitEdit (stu) {
  let resp = await apiUpdate(stu)
  // console.log("0000" + resp)
  if (resp.success) {
    ElMessage({
      type: 'success',
      message: '操作成功',
    })
    show.value = false
    search()
  }
  else {
    ElMessage({
      message: '操作失败',
      type: 'warning',
    })
  }
}

function add () {
  // console.log(sfm.value)
  sfm.value.id = ''
  // console.log(sfm.value)
  show.value = true
  dialogTitle.value = '添加科室'
}
async function submitAdd (stu) {
  let resp = await apiSave(stu)
  console.log(resp)
  if (resp.success) {
    ElMessage({
      type: 'success',
      message: '操作成功',
    })
    show.value = false
    search()
  }
  else {
    ElMessage({
      message: '操作失败',
      type: 'warning',
    })
  }
}
const subjectFormModel = ref({
  subCode: "",
  name: "",
  dutyDoctor: "",
  createTime: "",
  description: "",
  about: "",
  adress: ""
})
const sfm = subjectFormModel

//新增修改表单实例
let sfRef
//重置表单
function close () {
  sfRef.resetFields()
}
let dialogTitle = ref()
function a () {
  console.log('a')
}
function headercellStyle () {
  return {
    backgroundColor: '#f5f7fa',
    textAlign: 'center',
    color: "#000"
  }
}
</script>
<style>
.el-popper {
  max-width: 440px;
}
</style>

