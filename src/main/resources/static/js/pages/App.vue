<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>Contacts</v-toolbar-title>
        </v-toolbar>
        <v-content>
            <v-container v-if="persons">
                <person-list :persons="persons"/>
            </v-container>
            <v-container v-else>
                No persons in list
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
    import personApi from 'api/persons.js'
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
                personApi.get().then(result =>
                    result.json().then(data =>
                        data.forEach(person  => this.persons.push(person))
                    )
        )}

    }

</script>

<style scoped>
</style>