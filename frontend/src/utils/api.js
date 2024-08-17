import axios from "axios"
import { ElMessage } from "element-plus"
import { get as getJwt } from "../api/JwtApi"

//创建一个axios实例
const api = axios.create({
  baseURL: "/api",
  timeout: 3000
})
api.interceptors.request.use(config => {
  let jwt = getJwt()
  if (jwt) {
    config.headers["jwt"] = jwt
  }
  return config
}, error => {
  Promise.reject("请求拦截器异常")
})
//响应拦截器
api.interceptors.response.use(resp => {
  // console.log("resp+", resp)
  // console.log(resp.data)
  let data = resp.data
  if (data.code === 401) {
    ElMessage({
      message: "登录信息无效，稍后转到登录页",
      type: "error"
    });
    setTimeout(() => {
      location.href = "/login";
    }, 2000); // 延时
  }
  else
    return data

}, error => {
  Promise.reject("获取后端服务器数据异常")
})

export default api