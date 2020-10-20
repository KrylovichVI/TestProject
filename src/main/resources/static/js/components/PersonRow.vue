<template>
    <div class="main-app">
        <i>({{ person.id }})</i> {{ person.name }}
        <strong v-if="person.contacts">
            <i v-for="contact in person.contacts"> {{contact.telephone}}; </i>
        </strong>
        <span style="position: absolute; right: 0">
                    <input type="button" value="Edit" @click="edit"/>
                    <input type="button" value="X" @click="del"/>
        </span>
    </div>
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
    .main-app {
        color: brown;
    }
</style>