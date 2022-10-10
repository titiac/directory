import { createRouter, createWebHistory } from 'vue-router'
import AllContacts from '../views/allContacts/AllContacts'
import CollectContacts from '../views/collectContacts/CollectContacts'
import NotFound from '../views/error/NotFound'
import SearchName from '../views/search/SearchName'
import MyInfo from '../views/user/MyInfo'
import UserAccountLoginView from "../views/user/account/UserAccountLoginView"
import UserAccountRegisterView from "../views/user/account/UserAccountRegisterView"

const routes = [
  {
    path: "",
    name: "home",
    redirect: "/all"
  },
  {
    path: "/all",
    name: "all_contacts",
    component: AllContacts,
  },
  {
    path: "/user/login",
    name: "user_login",
    component: UserAccountLoginView,
  },
  {
    path: "/user/register",
    name: "user_register",
    component: UserAccountRegisterView,
  },
  {
    path: "/collect",
    name: "collect_contacts",
    component: CollectContacts,
  },
  {
    path: "/search",
    name: "search_name",
    component: SearchName,
  },
  {
    path: "/info",
    name: "my_info",
    component: MyInfo,
  },
  {
    path: "/404",
    name: "404",
    component: NotFound,
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404"
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
