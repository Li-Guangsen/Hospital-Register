import { createRouter, createWebHistory } from "vue-router";
import { get as getJwt } from "../api/JwtApi"
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
  {
    name: "Patient",//路由名称
    path: "/main/patient",//路由路径
    component: () => import("../components/Patient.vue")//路由组件
  },
  {
    name: "Admin",//路由名称
    path: "/main/admin",//路由路径
    component: () => import("../components/Admin.vue")//路由组件
  },
  {
    name: "Schedule",//路由名称
    path: "/main/schedule",//路由路径
    component: () => import("../components/Schedule.vue")//路由组件
  },
  {
    name: "Book",//路由名称
    path: "/main/book",//路由路径
    component: () => import("../components/Book.vue")//路由组件
  },
  {
    name: "Order",//路由名称
    path: "/main/order",//路由路径
    component: () => import("../components/Order.vue")//路由组件
  },
  {
    name: "DashBoard",//路由名称
    path: "/main/dashboard",//路由路径
    component: () => import("../components/DashBoard.vue")//路由组件
  },
  ]
}, {
  name: "Login",
  path: "/login",
  component: () => import("../components/Login.vue")//路由组件
},
{
  name: "index",
  path: "",
  redirect: "/main"
}];
//创建路由实例
const router = createRouter({
  history: createWebHistory(),
  routes
});
router.beforeEach((to, from, next) => {
  let jwt = getJwt();
  //只能校验有没有token，不能校验token是否有效
  //不是login页面，且没有jwt，
  // console.log("to.name:" + to.name);
  if (to.name !== "Login" && !jwt) {
    // console.log("to.name:" + to.name);
    next({ name: "Login" });
  } else {
    next();
  }
});
export default router;