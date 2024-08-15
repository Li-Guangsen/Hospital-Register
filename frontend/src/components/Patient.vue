<template>
  <div>
    <!-- 检索区查询表单 -->
    <div class="search">
      <el-form :inline="true" ref="searchFromRef" :model="sm">
        <!-- 表单项 -->
        <el-form-item label="主键" prop="id">
          <el-input placeholder="请输入ID" v-model="sm.id" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input placeholder="请输入病人手机号" v-model="sm.phone" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input placeholder="请输入病人姓名" v-model="sm.name" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthRange">
          <el-date-picker
            type="daterange"
            v-model="sm.birthRange"
            value-format="YYYY-MM-DD"
            start-placeholder="Start date"
            end-placeholder="End date"
          />
        </el-form-item>
        <el-form-item label="身份证号" prop="idNumber">
          <el-input placeholder="请输入病人身份证" v-model="sm.idNumber" />
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
          <el-table-column prop="id" label="ID" width="70" />
          <el-table-column prop="name" label="姓名" width="120" />
          <el-table-column prop="photo" label="头像" width="80">
            <template #default="{ row }">
              <el-image style="width: 100%; height: 100%" :src="row.photo" />
            </template>
          </el-table-column>
          <el-table-column prop="sex" label="性别" width="80" />
          <el-table-column prop="idNumber" label="身份证号" width="220" />
          <el-table-column prop="birth" label="生日" width="140" />
          <el-table-column prop="phone" label="手机号" width="180" />
          <el-table-column
            prop="description"
            label="备注"
            width="480"
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
          <el-col :span="12"
            ><el-form-item label="手机号:" label-width="80" prop="phone">
              <el-input v-model="sfm.phone" placeholder="请输入病人手机号" />
            </el-form-item>
            <el-form-item label="密码:" label-width="80" prop="password">
              <el-input
                v-model="sfm.password"
                placeholder="请输入密码"
              /> </el-form-item
            ><el-form-item label="姓名:" label-width="80" prop="name">
              <el-input
                v-model="sfm.name"
                placeholder="请输入病人姓名"
              /> </el-form-item
            ><el-form-item label="性别:" label-width="80" prop="sex">
              <el-select v-model="sfm.sex" placeholder="请选择病人性别">
                <el-option label="男" value="男" />
                <el-option label="女" value="女" />
              </el-select> </el-form-item
          ></el-col>
          <el-col :span="12">
            <el-form-item label="头像:" label-width="100" prop="photo">
              <el-upload
                class="photo"
                action="/api/uploads/photo"
                :show-file-list="false"
                :on-success="photoSuccess"
              >
                <el-image
                  v-if="sfm.photo"
                  style="
                    width: 170px;
                    height: 170px;
                    background-position: center center;
                    background-repeat: no-repeat;
                    background-size: contain;
                  "
                  :src="sfm.photo"
                />
                <el-icon class="icon" v-else> <Plus /></el-icon>
              </el-upload>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12"
            ><el-form-item label="身份证号:" label-width="80" prop="idNumber">
              <el-input
                v-model="sfm.idNumber"
                placeholder="请输入身份证号"
              /> </el-form-item
          ></el-col>
          <el-col :span="12"
            ><el-form-item label="出生日期:" label-width="100" prop="birth">
              <el-date-picker
                v-model="sfm.birth"
                type="date"
                placeholder="请选择出生日期"
                :width="650"
                style="width: 180px"
              /> </el-form-item
          ></el-col>
        </el-row>
        <el-form-item label="信息:" label-width="60" prop="description">
          <el-input
            v-model="sfm.description"
            :rows="8"
            type="textarea"
            placeholder="请输入信息"
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
import { findAll as apiFindAll, deleteById as apiDeleteById, save as apiSave, update as apiUpdate } from '@/api/PatientApi'
import { nextTick, onMounted, ref, toRaw } from 'vue'
import { descriptionProps, ElMessage, ElMessageBox } from 'element-plus'

//当组件加载完成后，自动调用findAll方法
onMounted(async () => {
  search()
  document.title = '用户管理'
})
const tableData = ref()
// 前两项是双向数据绑定
const pi = ref({
  pageNo: 1,
  pageSize: 5,
  total: 1000
})
async function search () {
  // console.log(sm.value)
  let params = sm.value
  // console.log(params)
  let resp = await apiFindAll(pi.value.pageNo, pi.value.pageSize, params)
  // console.log(resp.rows)
  tableData.value = resp.rows
  pi.value = resp.pi
}
function paginate () {
  // console.log(pi.value.pageNo, pi.value.pageSize)
  search()
}
//查询条件引用
const sm = ref({
  id: '',
  idNumber: '',
  name: "",
  phone: "",
  birthRange: "",
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
  // console.log(id)
  deleteById(id)
}
function deleteById (id) {
  ElMessageBox.confirm(
    '是否确认删除选中病人数据?',
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
  show.value = true
  dialogTitle.value = '修改病人信息'
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
  sfm.value.id = ''
  show.value = true
  dialogTitle.value = '添加病人'
}
async function submitAdd (stu) {
  let resp = await apiSave(stu)
  // console.log(resp)
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
const patientFormModel = ref({
  password: "",
  name: "",
  sex: "",
  birth: "",
  idNumber: "",
  phone: "",
  photo: "",
  description: "",
})
const sfm = patientFormModel

//新增修改表单实例
let sfRef
//重置表单
function close () {
  sfRef.resetFields()
}
let dialogTitle = ref()
function photoSuccess (resp, file) {
  // console.log(resp.url)
  if (resp.success) {
    sfm.value.photo = resp.url
  }
  else {
    ElMessage({
      message: '上传失败',
      type: 'warning',
    })
  }
}
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
<style scoped>
.photo {
  width: 170px;
  height: 170px;
  border: 1px solid #ccc;
}
.photo .icon {
  width: 170px;
  height: 170px;
}
</style>
<style>
.el-popper {
  max-width: 450px;
}
</style>

