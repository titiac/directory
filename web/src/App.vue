<template>
  <NavBar />
  <router-view />
</template>

<script>
import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default {
  components: {
    NavBar
  }
}
</script>

<style>
body {
  background-image: url(https://git.acwing.com/yxc/kob/-/raw/78b820fc5c389286259eba6d09bcd192c23caf91/web/src/assets/background.png);
  background-repeat: no-repeat;
  background-size: 100%;
}
</style>
