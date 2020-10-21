<template>
    <v-layout align-space-around justify-start column>
        <person-form :persons="persons" :personAttr="person"/>
        <person-row v-for="person in sortedContacts" :key="person.id"
                    :person="person" :persons="persons"
                    :editPerson="editPerson" :deletePerson="deletePerson"></person-row>
    </v-layout>
</template>


<script>
    import PersonRow from 'components/PersonRow.vue'
    import PersonForm from 'components/PersonForm.vue'
    import personApi from '../api/persons.js'

    export default {
        name: "PersonList",
        components:{
            PersonRow,
            PersonForm
        },
        props: ['persons'],
        data(){
            return{
                person: null
            }
        },
        computed: {
            sortedContacts(){
                return this.persons.sort((a, b) => - (a.id - b.id))
            }
        },
        methods: {
            editPerson(person) {
                this.person = person
            },
            deletePerson(person){
                personApi.remove(person.id).then(result => {
                    if(result.ok){
                        this.persons.splice(this.persons.indexOf(this.person), 1)
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>