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
  background-image: url(https://w.wallhaven.cc/full/6d/wallhaven-6dqjdl.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
