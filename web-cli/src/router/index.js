import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import NotFound from '../views/404'
import Test from "../views/Test";
import Dept from "../views/Dept";
import Policy from "../views/Policy";
import Interaction from "../views/Interaction";
import DeptIntroduction from "../views/dept/DeptIntroduction";
import PolicyDetail from "../views/policy/PolicyDetail";
import EditTxt from "../views/policy/EditTxt";
import Register from "../components/loginAndRegister/Register";
import InformationBoard from "../views/InformationModules/InformationBoard";
import ApplyForm from "../views/form/ApplyForm";
import UserCenter from "../views/UserCenter";
import Consult from "../views/interaction/Consult";
import Complaint from "../views/interaction/Complaint";
import Suggestions from "../views/interaction/Suggestions";
import CollectPolicyOpinion from "../views/interaction/CollectPolicyOpinion";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/404',
    name: 'notFound',
    component: NotFound
  },
  {
    path: '/test',
    name: 'test',
    component: Test
  },
  {
    path: '/dept',
    name: 'dept',
    component: Dept
  },
  {
    path: '/policy',
    name: 'policy',
    component: Policy
  },
  {
    path: '/interact',
    name: 'interact',
    component: Interaction
  },
  {
    path: '/deptIntro',
    name: 'deptIntro',
    component: DeptIntroduction
  },
  {
    path: '/policyDetail',
    name: 'policyDetail',
    component: PolicyDetail
  },
  {
    path: '/editTxt',
    name: 'editTxt',
    component: EditTxt
  },
  {
    path: '/register',
    component: Register,
    name: 'Register',
  },
  {
    path: '/informationBoard',
    component: InformationBoard,
    name: 'informationBoard',
  },
  {
    path: '/applyForm',
    component: ApplyForm,
    name: 'applyForm',
  },

  {
    path: '/userCenter',
    component: UserCenter,
    name: 'userCenter',
  },
  {
    path: '/consult',
    component: Consult,
    name: 'consult',
  },
  {
    path: '/complaint',
    component: Complaint,
    name: 'complaint',
  },
  {
    path: '/suggestions',
    component: Suggestions,
    name: 'suggestions',
  },
  {
    path: '/collectPolicyOpinion',
    component: CollectPolicyOpinion,
    name: 'collectPolicyOpinion',
  },





  {
    path: "*", // 此处需特别注意置于最底部
    redirect: "/404"
  }


];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
