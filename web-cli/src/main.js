import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import api from './http'
import global from "./utils/global";


Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(api);

import axios from "axios"
//配置 请求的 根路径
axios.defaults.baseURL = 'http://127.0.0.1:1681/'
Vue.prototype.$http = axios;
Vue.prototype.global = global;

new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App)
}).$mount('#app');
