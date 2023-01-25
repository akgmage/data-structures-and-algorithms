class User {
    constructor(firstname = "default user", lastname = "default user", credit = NaN) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.credit = credit;
    }
    getFullName() { return this.firstname};
    getCredit() { return this.credit; }
    editName(newName) {
        const myName = newName.split(' ')
        return myName;
    }
}

const user1 = new User('parma1', 'param2', 1);
const user2 = new User('param1', 'param2', 2);
const user3 = new User('param1', 'param2', 3);
const user4 = new User();

console.log(user4.editName("edi ted"));