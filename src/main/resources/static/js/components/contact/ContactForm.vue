<template>
    <v-container>
        <v-text-field v-on:keyup.enter="submit" label="Contact" placeholder="Write contact" v-model="telephone"/>
        <v-btn @click="save">
            Add
        </v-btn>
    </v-container>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        name: "ContactForm",
        props: ['personId'],
        data(){
            return{
                telephone: ''
            }
        },
        methods: {
            ...mapActions(['addContactAction']),
            save(){
                this.addContactAction({
                    telephone: this.telephone,
                    personId: this.personId
                })
                this.telephone = ''
            }
        }
    }
</script>

<style scoped>

</style>