<template>
    <div>
        <div>实验室id:{{lab_id}}</div>
        <div>实验室名称:{{lab_name}}</div>
        <div>实验室地址:{{lab_adr}}</div>
    </div>
    <router-view />
</template>
  
<script>
import $ from 'jquery';
import { ref } from 'vue';
export default {
    name: "APP",
    setup: () => {
        let lab_id = ref("");
        let lab_name = ref("");
        let lab_adr = ref("");

        $.ajax({
            url: "http://localhost:3000/test/getAll",
            type: "get",
            success: resp => {
                lab_id.value = resp[0].id;
                lab_name.value = resp[0].name;
                lab_adr.value = resp[0].address;
            }
        });

        return {
            lab_id,
            lab_name,
            lab_adr
        }
    }
}
</script>
  
<style>
body {}
</style>
  