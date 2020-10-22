<template>
    <v-list-tile>
        <v-list-tile-content>
            <v-list-tile-title>{{contact.telephone}}</v-list-tile-title>
        </v-list-tile-content>
        <v-card-actions>
            <v-btn icon @click="del" small
            >
                <v-icon>
                    delete
                </v-icon>
            </v-btn>
        </v-card-actions>
    </v-list-tile>
</template>

<script>
    import { mapActions } from 'vuex'
    import contact from "../../api/contact";
    export default {
        name: "ContactItem",
        props: ['contact'],
        methods: {
            ...mapActions(['removeContactAction']),
            del(){
                this.removeContactAction(contact)
            }
        }
    }
</script>

<style scoped>

</style>