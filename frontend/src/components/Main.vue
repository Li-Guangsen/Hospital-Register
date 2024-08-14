<template>
  <el-container class="outer">
    <!-- 侧栏 -->
    <el-aside class="aside"
      ><el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        default-active="/main/subject"
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
        <div class="title"><h1>医院门诊预约管理系统</h1></div>
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
  background-color: #f3fcfe;
  border-bottom: 1px solid #ebeef5;
  display: flex;
  flex-direction: row;
  padding-left: 6px;
}
.header > .title {
  flex-grow: 1;
}
.header > .logo {
  width: 120px;
  flex-shrink: 0;
  box-sizing: border-box;
  padding: 5px;
  background: url("../../public/logo.png") no-repeat center center/contain;
}
.header > .session {
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
import { onBeforeRouteUpdate } from 'vue-router';
import { useRouter } from 'vue-router'
// 侧栏菜单数据
const menus = ref([{
  title: '预约管理',
  url: '/book',
  children: [
    { title: '预约列表', url: '/book/list' },
    { title: '数据统计', url: '/book/stat' }
  ]
}, {
  title: '医生管理',
  url: '/main/doctor'
}, {
  title: '科室管理',
  url: '/main/subject'
}])


</script>
