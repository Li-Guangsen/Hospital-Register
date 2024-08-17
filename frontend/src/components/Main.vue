<template>
  <el-container class="outer">
    <!-- 侧栏 -->
    <el-aside class="aside"
      ><el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
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
              <span>{{ menu.title }}</span>
            </template>
            <el-menu-item
              v-for="item in menu.children"
              :index="item.url"
              :key="item.url"
              >{{ item.title }}
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item v-else :index="menu.url" :key="menu.url">
            {{ menu.title }}
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
            background-color="#f3fcfe"
            style="border-bottom: 1px solid #ebeef5"
            class="el-menu-demo"
            mode="horizontal"
            :ellipsis="false"
            @select="userMenuSelect"
          >
            <el-sub-menu index="uesr">
              <template #title>Admin</template>
              <el-menu-item index="2-1">item one</el-menu-item>
              <el-menu-item index="2-2">item two</el-menu-item>
              <el-menu-item index="logout">logout</el-menu-item>
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
  background-color: #f3fcfe;
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
  background: url("../../public/logo-modified.png") no-repeat center
    center/contain;
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
import { ref } from 'vue'
import { Setting, User } from '@element-plus/icons-vue'
import { clear as removeJwt } from "../api/JwtApi"
import { useRouter } from 'vue-router'
// 侧栏菜单数据
const menus = ref([
  { title: '数据看板', url: '/main/dashboard' },
  {
    title: '挂号管理',
    url: '/main',
    children: [
      { title: '患者挂号', url: '/main/book' },
      { title: '挂号列表', url: '/main/order' },

    ]
  }, {
    title: '医生管理',
    url: '/main/doctor'
  }, {
    title: '科室管理',
    url: '/main/subject'
  }, {
    title: '排班管理',
    url: '/main/schedule'
  }, {
    title: '用户管理',
    url: '/main/patient'
  }, {
    title: '管理员管理',
    url: '/main/admin'
  }])
const router = useRouter()
function userMenuSelect (menu) {
  if (menu === 'logout') {
    // console.log('logout')
    removeJwt()
    router.push('/empty')
  }
}

</script>
