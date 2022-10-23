<template>
    <div class="container">
        <div class="row">
            <div class="col-12"> <!-- 一个页面中占三份，共十二份 -->
                <div class="card" style="margin-top:20px">
                    <div class="card-header">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" style="float: right" data-bs-toggle="modal" data-bs-target="#add_contact_btn">
                            新增
                        </button>
                        
                        <!-- Modal -->
                        <div class="modal fade" id="add_contact_btn" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5">新增联系人</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="add_contact_name" class="form-label">联系人姓名</label>
                                            <input v-model="contactadd.name" type="text" class="form-control" id="add_contact_name" placeholder="请输入联系人姓名">
                                        </div>
                                        <div class="mb-3">
                                            <label for="add_contact_telephone" class="form-label">电话</label>
                                            <input v-model="contactadd.telephone" type="text" class="form-control" id="add_contact_telephone" placeholder="请输入联系人电话">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="error_message">{{contactadd.error_message}}</div>
                                        <button type="button" class="btn btn-primary" @click="add_contact">创建</button>
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="card-body">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <!-- <th scope="col">#</th> -->
                                    <th scope="col">名称</th>
                                    <th scope="col">电话</th>
                                    <th scope="col">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="contact in contacts" :key="contact.id">
                                    <td>{{ contact.name }}</td>
                                    <td>{{ contact.telephone }}</td>
                                    <td>
                                        <button type="button" class="btn btn-secondary" style="margin-right: 10px" data-bs-toggle="modal" :data-bs-target="'#update_contact_btn' + contact.id">编辑</button>
                                        <!-- Modal -->
                                        <div class="modal fade" :id="'update_contact_btn' + contact.id" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h1 class="modal-title fs-5">编辑联系人</h1>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="mb-3">
                                                            <label for="add_contact_name" class="form-label">联系人姓名</label>
                                                            <input v-model="contact.name" type="text" class="form-control" id="update_contact_name"
                                                                placeholder="请输入联系人姓名">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="add_contact_telephone" class="form-label">电话</label>
                                                            <input v-model="contact.telephone" type="text" class="form-control" id="update_contact_telephone"
                                                                placeholder="请输入联系人电话">
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <div class="error_message">{{contact.error_message}}</div>
                                                        <button type="button" class="btn btn-primary" @click="update_contact(contact)">修改</button>
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-danger" @click="remove_contact(contact)">删除</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { ref, reactive } from 'vue'
import $ from 'jquery'
import { useStore } from 'vuex'
import { Modal } from 'bootstrap/dist/js/bootstrap'

export default {

    setup (){ 
        const store = useStore();
        let contacts = ref([]);
        let contactadd = reactive({
            name: "",
            telephone: "",
            error_message: "",
        })

        const refresh_list = () => {
            $.ajax({
                url: "http://localhost:3000/mine/get/contact",
                type: "get",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success(resp) { 
                    contacts.value = resp;
                }
            })
        }

        refresh_list();

        const add_contact = () => { 
            contactadd.error_message = "";
            $.ajax({
                url: "http://localhost:3000/mine/add/contact",
                type: "post",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    name: contactadd.name,
                    telephone: contactadd.telephone,
                },
                success(resp) { 
                    if (resp.error_message === "success") {
                        contactadd.error_message = "";
                        contactadd.name = "";
                        contactadd.telephone = "";
                        Modal.getInstance("#add_contact_btn").hide();

                        refresh_list();
                    } else {
                        contactadd.error_message = resp.error_message;
                    }
                }
            })
        }

        const remove_contact = (contact) => {
            $.ajax({
                url: "http://localhost:3000/mine/delete/contact",
                type: "delete",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    contactId: contact.id
                },
                success(resp) { 
                    if (resp.error_message === "success") { 
                        refresh_list();
                    }
                }
            })
        }

        const update_contact = (contact) => {
            contactadd.error_message = "";
            $.ajax({
                url: "http://localhost:3000/mine/update/contact",
                type: "post",
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    contactId: contact.id,
                    name: contact.name,
                    telephone: contact.telephone,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        Modal.getInstance("#update_contact_btn" + contact.id).hide();
                        // :id="'update_contact_btn' + contact.id"
                        refresh_list();
                    } else {
                        contactadd.error_message = resp.error_message;
                    }
                }
            })
        }


        return {
            contacts,
            contactadd,
            add_contact,
            remove_contact,
            update_contact
        }
    }
}
</script>

<style scoped>
div.error_message{
    color: red;
}
</style>