<template><!--一个template下只能有一个根标签-->
    <div class="users">
        <ul>
            <li v-for="user in users">
                {{user}}--{{Greeting()}}
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "users",
        data(){
            return {users:["迪丽热巴","杨幂","孙悟空"]}
        },
        methods:{
            Greeting(){
                return "lihang";
            }
        }
    }
</script>

<style scoped>
</style>