import axios from 'axios'
import {Message} from 'element-ui'

const service = axios.create({
  baseURL: "http://localhost:8888",
  timeout: 10000
})

//request拦截器
service.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    let user = JSON.parse(localStorage.user)
    let token = user.token
    if(token != null){
        alert(token)
        config.headers = {
            'Content-Type': 'application/json',
            'Authorization':token
        }
    }
    Message({
        type: 'success',
        showClose: true,
        message: '已成功发送请求'
      })
    return config;
  }, function (error) {
    // 对请求错误做些什么
    Message({
        type: 'warning',
        showClose: true,
        message: '请求发送失败'
      })
    return Promise.reject(error);
  });


// respone拦截器
service.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    Message({
        type: 'success',
        showClose: true,
        message: '已成功接收响应数据'
      })
    return response;
  }, function (error) {
    // 对响应错误做点什么
    Message({
        type: 'warning',
        showClose: true,
        message: '响应数据接收失败'
      })
    return Promise.reject(error);
  });

export default service
