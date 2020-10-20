function getIndex(list, id) {
    for(var i = 0; i < list.length; i++){
        if(list[i].id === id){
            return i;
        }
        return -1;
    }
}

var personApi = Vue.resource('/person{/id}')

Vue.component('person-form',{
    props: ['persons', 'personAttr'],
    data: function () {
        return {
            name: '',
            telephone: '',
            id: ''
        }
    },
    watch:{
        personAttr:function(newVal, oldVal){
          this.name = newVal.name;
          this.id = newVal.id;
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Write name" v-model="name"/>' +
            '<input type="text" placeholder="Write phone" v-model="telephone"/>' +
            '<input type="button"  value="Save" @click="save"/>' +
       '</div>',
    methods: {
        save: function () {
            var person = { name: this.name, contacts: push(this.telephone)};

            if(this.id){
                personApi.update({id: this.id}, person).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.persons, data.id);
                        this.persons.splice(index, 1, data);
                        this.name = '';
                        this.telephone = '';
                        this.id = '';
                    })
                )
            } else{
                personApi.save({}, person).then(result =>
                    result.json().then(data => {
                        this.persons.push(data);
                        this.telephone = '';
                        this.name = '';
                }))
            }
        }
    }
});

Vue.component('person-row', {
    props: ['person', 'persons', 'editPerson'],
    template: '<div>' +
                '<i>({{ person.id }})</i> {{ person.name }}' +
                '<strong v-if="person.contacts"><i v-for="contact in person.contacts"> {{contact.telephone}}; </i></strong>' +
                '<span style="position: absolute; right: 0">' +
                    '<input type="button" value="Edit" @click="edit"/>' +
                    '<input type="button" value="X" @click="del"/>' +
                '</span>' +
            '</div>',
    methods: {
        edit: function () {
            this.editPerson(this.person)
        },
        del: function () {
            personApi.remove({id: this.person.id}).then(result => {
                if(result.ok){
                    this.persons.splice(this.persons.indexOf(this.person), 1)
                }
            })
        }
    }
});


Vue.component('person-list', {
    props: ['persons'],
    data: function(){
        return{
            person: null
        }
    },
    template: '<div style="position: relative; width: 300px;">' +
                '<person-form :persons="persons" :personAttr="person"/>' +
                '<person-row v-for="person in persons" :key="person.id" :person="person" :persons="persons":editPerson="editPerson"></person-row>' +
            '</div>',
    methods: {
        editPerson: function (person) {
            this.person = person;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<person-list :persons="persons"/>',
    created: function(){
      personApi.get().then(result =>
      result.json().then(data =>
          data.forEach(person  => this.persons.push(person))
      )
      )
    },
    data: {
        persons: []
    }
});