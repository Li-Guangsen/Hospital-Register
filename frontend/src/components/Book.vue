<template>
  <div>
    <!-- 检索区查询表单 -->
    <div class="search">
      <el-form :inline="true" ref="searchFromRef" :model="sm">
        <!-- 表单项 -->
        <el-form-item label="科室" prop="subId">
          <el-select
            placeholder="请选择科室"
            style="width: 300px"
            v-model="sm.subId"
          >
            <el-option key="0" label="不限" value="" />
            <el-option
              v-for="department in departments"
              :key="department.id"
              :label="department.name"
              :value="department.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="医生姓名" prop="doctorName">
          <el-input placeholder="请输入医生姓名" v-model="sm.doctorName" />
        </el-form-item>
        <el-form-item label="预约日期:" prop="workTime">
          <el-date-picker
            v-model="sm.workTime"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择预约日期"
            :width="650"
          />
        </el-form-item>
      </el-form>
    </div>
    <!-- 操作区 -->
    <div class="operate">
      <el-button type="primary" @click="search" :icon="Search">查询</el-button>
      <el-button type="primary" @click="resetSearch" :icon="Refresh"
        >重置</el-button
      >
    </div>
    <div class="card-wrapper">
      <el-card
        v-for="item in tableData"
        :key="item.id"
        class="card-container"
        style="background-color: #eef8fd"
      >
        <!-- 卡片的头像和名称部分 -->
        <div class="card-header">
          <el-avatar :src="item.doctor.photo" :size="100" />
          <div style="margin: 10px 0"></div>
          <div class="card-info">
            <!-- 黑体粗体 -->
            <strong>{{ item.doctor.name }}</strong>
            ---
            <strong></strong>{{ item.doctor.subject.name }}
          </div>
          <div style="margin: 20px 0"></div>
          <strong>挂号日期；</strong>{{ item.workTime }}
        </div>

        <!-- 卡片的主要内容部分 -->
        <div class="card-body">
          <div class="amount">
            <strong>挂号费:</strong>
            <span style="color: red"
              >￥{{ item.doctor.money }}&nbsp;&nbsp;</span
            >
            <strong>剩余:</strong> {{ item.count }}
          </div>
          <p><strong>简介:&nbsp;&nbsp;&nbsp;</strong>{{ item.doctor.about }}</p>
        </div>

        <!-- 卡片的底部按钮 -->
        <div class="card-footer">
          <el-button type="primary" @click="handleAction(item.id)"
            >挂号</el-button
          >
        </div>
      </el-card>
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
          <el-table-column prop="doctor.name" label="医生姓名" width="120" />
          <el-table-column prop="doctor.photo" label="医生头像" width="100">
            <template #default="{ row }">
              <el-image
                style="width: 100%; height: 100%"
                :src="row.doctor.photo"
              />
            </template>
          </el-table-column>
          <el-table-column
            prop="doctor.subject.name"
            label="科室"
            width="110"
          />
          <el-table-column prop="workTime" label="预约日期" width="120" />
          <el-table-column prop="count" label="剩余个数" width="120" />
          <el-table-column prop="doctor.money" label="挂号费" width="100" />
          <el-table-column
            prop="doctor.about"
            label="医生简介"
            width="480"
            show-overflow-tooltip
          />
          <el-table-column
            prop="description"
            label="备注"
            width="300"
            show-overflow-tooltip
          />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" @click="deleteRow(scope.row)">
                挂号
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
          :page-sizes="[5, 10]"
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
      width="500"
      draggable
      :close-on-click-modal="false"
      @closed="close"
    >
      <!-- 新增操作表单 -->
      <el-form :model="sfm" ref="sfRef">
        <el-form-item label="医生:" label-width="120" prop="doctorId">
          <el-select
            placeholder="请选择医生"
            style="width: 300px"
            v-model="sfm.doctorId"
          >
            <el-option
              v-for="doctorItem in doctors"
              :key="doctorItem.id"
              :label="doctorItem.name"
              :value="doctorItem.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="预约个数:" label-width="120" prop="count">
          <el-input
            v-model="sfm.count"
            style="width: 300px"
            placeholder="请输入预约个数"
          />
        </el-form-item>
        <el-form-item label="预约日期:" label-width="120" prop="workTime">
          <el-date-picker
            v-model="sfm.workTime"
            type="date"
            placeholder="请选择预约日期"
            :width="650"
            style="width: 300px"
          />
        </el-form-item>
        <el-form-item label="备注:" label-width="45" prop="description">
          <el-input
            v-model="sfm.description"
            :rows="8"
            type="textarea"
            placeholder="请输入备注"
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
import { findAll as apiFindAll, addOrder as apiAddOrder } from '../api/ScheduleApi'
import { findSubNames } from '@/api/SubjectApi'
import { findDocNames } from '../api/DoctorApi'
import { nextTick, onMounted, ref, toRaw } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

const loading = ref(true)
const lists = ref()
const setLoading = () => {
  loading.value = true
  setTimeout(() => {
    loading.value = false
  }, 2000)
}

//当组件加载完成后，自动调用findAll方法
onMounted(async () => {
  search()
  departments.value = await findSubNames()
  doctors.value = await findDocNames()
  // console.log(doctors.value)
  // 拼接医生的name和subject.name
  doctors.value = doctors.value.map(doctor => {
    doctor.name = `${doctor.name} -- ${doctor.subject.name}`;
    return doctor;
  });
  document.title = '患者挂号'
  loading.value = false
  lists.value = [
    {
      imgUrl:
        'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
      name: 'Deer',
      date: "2021-09-01"
    },
    {
      imgUrl:
        'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
      name: 'Horse',
      date: "2021-09-01"
    },
    {
      imgUrl:
        'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
      name: 'Mountain Lion',
      date: "2021-09-01"
    },
  ]

})
const departments = ref([])
const doctors = ref([])
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
  // console.log(pi.value.pageNo, pi.value.pageSize)
  search()
}
//查询条件引用
const sm = ref({
  id: '',
  doctorName: '',
  subId: '',
  workTime: "",
  count: "",
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
    '是否确认删除选中排班数据?',
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

const doctorFormModel = ref({
  id: '',
  doctorId: '',
  doctor: {
    id: '',
    subId: '',
    name: '',
    about: '',
    subject: {
      id: "",
      name: "",
    },
    money: "",
  },
  workTime: "",
  description: "",
  count: "",
})
const sfm = doctorFormModel

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
<style scoped>
.photo {
  width: 100px;
  height: 100px;
  border: 1px solid #ccc;
}
.photo .icon {
  width: 100px;
  height: 100px;
}
.card-wrapper {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  margin: 10px 0;
}

.card-container {
  flex: 1 1 calc(20% - 20px);
  box-sizing: border-box;
  max-width: calc(20% - 20px);
  min-width: 250px;
}

.card-header {
  text-align: center;
  align-items: center;
}

.card-body {
  margin-top: 20px;
  height: 250px;
  overflow: hidden;
}

.amount {
  text-align: center;
  font-size: 16px;
  margin-bottom: 10px;
}

.card-footer {
  text-align: right;
  margin-top: 20px;
}
</style>
<style>
.el-popper {
  max-width: 450px;
}
</style>

