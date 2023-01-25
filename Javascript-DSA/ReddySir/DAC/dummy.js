/**
 * 
 */

const person = new Object(); // 1st way to create a object with


person.name = "A";
person.age = 10;
person.gender = "male";
person.dance = function() {
    console.log("I am dancing");
}
person.eat = function eat() {
    console.log("I am eating");
}

/**
 * JS object will have fields as well as functions/behaviour
 * 
 */

// console.log(person.age);

// console.log(person['age']);

/**
 * ! obj.fieldName -> access both the field and the functions
 */

// for (k in person) {
//     console.log(k);
// }

// console.log(Object.keys(person));


function makeObject(name, age, gender) {
   return {
        name,
        age,
        gender
   }
}

// console.log(makeObject(1, 2, 3));

/**
 * ! Another way to create object
 */

function Person(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}

const person1 = new Person(1, 2, 3);
const person2 = new Person(4, 5, 6);

console.log(person1);




