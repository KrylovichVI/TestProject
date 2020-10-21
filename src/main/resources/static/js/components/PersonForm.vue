<template>
    <v-container>
        <v-text-field label="Name" placeholder="Write name" v-model="name"/>
        <v-text-field label="Phone" placeholder="Write phone" v-model="telephone"/>
        <v-btn @click="save">
            Save
        </v-btn>
    </v-container>
</template>

<script>
    import personApi from 'api/persons.js'

    export default {
        name: "PersonForm",
        props: ['persons', 'personAttr'],
        data() {
            return {
                name: '',
                telephone: '',
                id: ''
            }
        },
        watch:{
            personAttr(newVal, oldVal){
                this.name = newVal.name
                this.id = newVal.id
            }
        },

        methods: {
            save() {
                const person = { id: this.id, name: this.name};

                if(this.id){
                    personApi.update(person).then(result =>
                        result.json().then(data => {
                            const index = this.persons.findIndex(item => item.id === data.id)
                            this.persons.splice(index, 1, data)
                        })
                    )
                } else{
                    personApi.add(person).then(result =>
                        result.json().then(data => {
                            this.persons.push(data)
                        }))
                }
                this.name = ''
                this.telephone = ''
                this.id = ''
            }
        }
    }
</script>

<style scoped>

</style>