<template>
    <div style="position: relative; width: 300px;">
        <person-form :persons="persons" :personAttr="person"/>
        <person-row v-for="person in persons" :key="person.id"
                    :person="person" :persons="persons"
                    :editPerson="editPerson" :deletePerson="deletePerson"></person-row>
    </div>
</template>


<script>
    import PersonRow from "components/PersonRow.vue";
    import PersonForm from "components/PersonForm.vue";
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
        methods: {
            editPerson(person) {
                this.person = person
            },
            deletePerson(person){
                this.$resource('/person{/id}').remove({id: this.person.id}).then(result => {
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