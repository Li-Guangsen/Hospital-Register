import { createRouter, createWebHistory } from "vue-router";

const routes = [{
  name: "main",
  path: "/main",
  component: () => import("../components/Main.vue"),
  children: [{
    name: "doctor",//路由名称
    path: "/main/doctor",//路由路径
    component: () => import("../components/Doctor.vue")//路由组件
  }, {
    name: "Subject",//路由名称
    path: "/main/subject",//路由路径
    component: () => import("../components/Subject.vue")//路由组件
  },
  ]
}, {
  name: "index",
  path: "",
  redirect: "/main"
}];
//创建路由实例
const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;