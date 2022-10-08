import { createRouter, createWebHistory } from 'vue-router'
import AllContacts from '../views/allContacts/AllContacts'
import CollectContacts from '../views/collectContacts/CollectContacts'
import NotFound from '../views/error/NotFound'
import SearchName from '../views/search/SearchName'
import MyInfo from '../views/user/MyInfo'

const routes = [
  {
    path: "/all",
    name: "all_contacts",
    component: AllContacts,
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
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
