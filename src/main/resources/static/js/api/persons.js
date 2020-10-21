import Vue from 'vue'

const persons = Vue.resource('/person{/id}')

export default {
    get:() => persons.get(),
    add: person => persons.save({}, person),
    update: person => persons.update({id: person.id}, person),
    remove: id => persons.remove({id})
}