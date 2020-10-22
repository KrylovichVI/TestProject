<template>
    <v-list two-line>
        <v-subheader>
            Contacts
        </v-subheader>
        <template
            v-for="(item, index) in contacts"
        >
            <v-divider v-if="index > 0"
                        :key="index"
            >
            </v-divider>
            <contact-item :contact="item" :key="'item' + index"/>
        </template>
        <contact-form :person-id="personId"/>
    </v-list>
</template>

<script>
    import ContactItem from "../contact/ContactItem.vue";
    import ContactForm from "../contact/ContactForm.vue";
    export default {
        name: "ContactList",
        components: {ContactItem, ContactForm},
        props:['contacts', "personId"]
    }
</script>

<style scoped>

</style>