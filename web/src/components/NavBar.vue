<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <!-- <a class="navbar-brand" href="">通讯录</a> -->
            <router-link class="navbar-brand" :to="{name:'home'}">通讯录</router-link>
            <!-- name后跟的值是router.index.js中的name -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <!-- <a class="nav-link active" aria-current="page" href="all">所有联系人</a> -->
                        <router-link class="nav-link active" aria-current="page" :to="{name:'all_contacts'}">
                            所有联系人
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <!-- <a class="nav-link" href="/collect">收藏联系人</a> -->
                        <router-link class="nav-link" :to="{name:'collect_contacts'}">收藏联系人</router-link>
                    </li>
                </ul>
                <!-- <form class="d-flex me-auto mb-2 mb-lg-0" role="search">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form> -->
                <ul class="navbar-nav" v-if="$store.state.user.is_login">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            {{ $store.state.user.username }}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li>

                                <router-link class="dropdown-item" :to="{name:'my_info'}">我的信息</router-link>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav" v-else>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'user_login' }" role="button">
                            登录
                        </router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'user_register'}" role="button">
                            注册
                        </router-link>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</template>

<script>
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import { useStore } from 'vuex'

export default {
    setup() {
        const store = useStore();
        const route = useRoute();
        let route_name = computed(() => route.name) // 用于高亮，未实现

        const logout = () => {
            store.dispatch("logout");
        }

        return {
            route_name,
            logout
        }
    }
}

</script>

<style scoped>

</style>