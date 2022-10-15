import { createRouter, createWebHistory } from 'vue-router'
import AllContacts from '../views/allContacts/AllContacts'
import CollectContacts from '../views/collectContacts/CollectContacts'
import NotFound from '../views/error/NotFound'
import SearchName from '../views/search/SearchName'
import MyInfo from '../views/user/MyInfo'
import UserAccountLoginView from "../views/user/account/UserAccountLoginView"
import UserAccountRegisterView from "../views/user/account/UserAccountRegisterView"
import store from "../store/index"


const routes = [
  {
    path: "",
    name: "home",
    redirect: "/all",
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/all",
    name: "all_contacts",
    component: AllContacts,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/login",
    name: "user_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/user/register",
    name: "user_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/collect",
    name: "collect_contacts",
    component: CollectContacts,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/search",
    name: "search_name",
    component: SearchName,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/info",
    name: "my_info",
    component: MyInfo,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/404",
    name: "404",
    component: NotFound,
    meta: {
      requestAuth: false,
    }
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

router.beforeEach((to, from, next) => { // from 从哪个页面跳过去    to 去往哪个页面
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({ name: "user_login" })
  } else {
    next();
  }
})

export default router
