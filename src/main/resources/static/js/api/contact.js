import Vue from 'vue'

const contacts = Vue.resource('/contact{/id}')

export default {
    add: contact => contacts.save({}, contact),
    remove: id => contacts.remove({id})
}