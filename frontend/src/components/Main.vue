<template>
  <el-container class="outer">
    <!-- 侧栏 -->
    <el-aside class="aside"
      ><el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        :default-active="pathname"
        text-color="#fff"
        style="border-right: none"
        :router="true"
      >
        <template v-for="menu in menus">
          <el-sub-menu
            v-if="menu.children"
            :index="menu.url"
            :key="'m-' + menu.url"
          >
            <template #title>
              <span
                ><el-icon
                  ><component
                    class="icons"
                    :is="menu.icon"
                    style="width: 1em; height: 1em; margin-right: 8px"
                  >
                  </component></el-icon
                >{{ menu.title }}</span
              >
            </template>
            <el-menu-item
              v-for="item in menu.children"
              :index="item.url"
              :key="item.url"
              ><el-icon
                ><component
                  class="icons"
                  :is="item.icon"
                  style="width: 1em; height: 1em; margin-right: 8px"
                >
                </component></el-icon
              >{{ item.title }}
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item v-else :index="menu.url" :key="menu.url">
            <el-icon
              ><component
                class="icons"
                :is="menu.icon"
                style="width: 1em; height: 1em; margin-right: 8px"
              >
              </component> </el-icon
            >{{ menu.title }}
          </el-menu-item>
        </template>
      </el-menu>
    </el-aside>
    <el-container>
      <!-- 头部 -->
      <el-header class="header"
        ><div class="logo"></div>
        <div class="title"><h1>汉东省人民医院门诊预约系统</h1></div>
        <div class="session">
          <el-menu
            :default-active="activeIndex"
            background-color="white"
            style="border-bottom: 1px solid #ebeef5"
            class="el-menu-demo"
            mode="horizontal"
            :ellipsis="false"
            @select="userMenuSelect"
          >
            <el-sub-menu index="uesr">
              <template #title
                ><el-icon><Avatar /></el-icon>{{ username }}</template
              >
              <el-menu-item index="2-1">个人信息</el-menu-item>
              <el-menu-item index="2-2">修改密码</el-menu-item>
              <el-menu-item index="logout">退出登录</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </div>
      </el-header>
      <!-- 主体 -->
      <el-main class="main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>
<style scoped>
.outer {
  height: 100%;
}
.aside {
  width: 200px;
  background-color: #545c64;
}
.header {
  height: 60px;
  background-color: white;
  /* background-color: #f3fcfe; */
  border-bottom: 1px solid #ebeef5;
  display: flex;
  flex-direction: row;
  padding-left: 6px;
  padding-right: 0px;
}
.header > .title {
  flex-grow: 1;
}
.header > .logo {
  width: 120px;
  flex-shrink: 0;
  box-sizing: border-box;
  padding: 5px;
  background: url("/logo-modified.png") no-repeat center center/contain;
}
.header > .session {
  height: 100%;
  width: 150px;
  flex-shrink: 0;
  z-index: 999;
}
.main {
}
</style>
<script setup>
import { ref, onMounted } from 'vue'
import { Setting, GobletSquareFull, User, Avatar, Medal, List, TrendCharts, Notebook, Lock, OfficeBuilding, Finished } from '@element-plus/icons-vue'
import { clear as removeJwt } from "../api/JwtApi"
import { getUsername } from '../api/AdminApi'
import { useRouter } from 'vue-router'
import { ElMessage, ElMessageBox } from 'element-plus'

onMounted(async () => {
  username.value = await getUsername()
  // console.log(username)
  // console.log(new URL(window.location.href).pathname)

})
// 侧栏菜单数据
const menus = ref([
  { icon: TrendCharts, title: '数据看板', url: '/main/dashboard' },
  {
    icon: Finished,
    title: '挂号管理',
    url: '/main',
    children: [{
      icon: GobletSquareFull, title: '患者挂号', url: '/main/book'
    },
    { icon: List, title: '挂号列表', url: '/main/order' },

    ]
  }, {
    icon: Medal,
    title: '医生管理',
    url: '/main/doctor'
  }, {
    icon: OfficeBuilding,
    title: '科室管理',
    url: '/main/subject'
  }, {
    icon: Notebook,
    title: '排班管理',
    url: '/main/schedule'
  }, {
    icon: User,
    title: '用户管理',
    url: '/main/patient'
  }, {
    icon: Lock,
    title: '管理员管理',
    url: '/main/admin'
  }])
const router = useRouter()
const username = ref()
const pathname = ref(new URL(window.location.href).pathname)
function userMenuSelect (menu) {
  if (menu === 'logout') {
    // console.log('logout')
    removeJwt()
    router.push('/empty')
  }
  else {
    operateAdmin()
  }
}
function operateAdmin () {
  ElMessageBox.alert('您可以到管理员管理页面进行操作', '用户操作', {
    confirmButtonText: 'OK',
  })
}

</script>
