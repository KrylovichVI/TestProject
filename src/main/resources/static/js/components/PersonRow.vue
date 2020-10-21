<template>
    <v-card class="my-2">
        <v-card-text primary-title>
            <strong>
                <i>({{ person.id}})</i>
                {{ person.name }}
            </strong>
        </v-card-text>
        <v-card-text class="text--primary" v-if="person.contacts">
            <div v-for="contact in person.contacts"> {{contact.telephone}}; </div>
        </v-card-text>
        <v-card-actions>
            <v-btn @click="edit" small flat round>Edit</v-btn>
            <v-btn icon @click="del" small
            >
                <v-icon>
                    delete
                </v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "PersonRow",
        props: ['person', 'persons', 'editPerson', 'deletePerson'],
        methods: {
            edit() {
                this.editPerson(this.person)
            },
            del() {
                this.deletePerson(this.person)
            }
        }
    }
</script>

<style scoped>
</style>