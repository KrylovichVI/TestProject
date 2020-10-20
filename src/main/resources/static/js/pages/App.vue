<template>
    <div>
        <person-list :persons="persons"/>
    </div>
</template>

<script>
    import PersonList from '../components/PersonList.vue'

    export default {
        name: "App",
        components: {
            PersonList
        },
        data() {
            return{
                persons: []
            }
        },
        created(){
                this.$resource('/person{/id}').get().then(result =>
                    result.json().then(data =>
                        data.forEach(person  => this.persons.push(person))
                    )
        )}

    }

</script>

<style scoped>
</style>