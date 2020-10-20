<template>
    <div>
        <input type="text" placeholder="Write name" v-model="name"/>
        <input type="text" placeholder="Write phone" v-model="telephone"/>
        <input type="button"  value="Save" @click="save"/>
    </div>
</template>

<script>
    function getIndex(list, id) {
        for(const i = 0; i < list.length; i++){
            if(list[i].id === id){
                return i
            }
            return -1
        }
    }

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
                const person = { name: this.name};

                if(this.id){
                    this.$resource('/person{/id}').update({id: this.id}, person).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.persons, data.id)
                            this.persons.splice(index, 1, data)
                            this.name = ''
                            this.telephone = ''
                            this.id = ''
                        })
                    )
                } else{
                    this.$resource('/person{/id}').save({}, person).then(result =>
                        result.json().then(data => {
                            this.persons.push(data)
                            this.telephone = ''
                            this.name = ''
                        }))
                }
            }
        }
    }
</script>

<style scoped>

</style>