import axios from "axios"

//创建一个axios实例
const api = axios.create({
  baseURL: "/api",
  timeout: 3000
})

//响应拦截器
api.interceptors.response.use(resp => {
  // console.log(resp)
  let data = resp.data
  return data

}, error => {
  Promise.reject("获取后端服务器数据异常")
})

export default api