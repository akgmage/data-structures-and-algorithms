//! 29/01/2022

const users = [
    ['a', 'a@gmail.com', 1 ],
    ['b', 'b@gmail.com', 2 ],
    ['c', 'c@gmail.com', 3 ],
    ['d', 'd@gmail.com', 4 ]
];


users.push([1, 2]);
users.shift();
users.pop();
users.unshift("newly inserted", 1, 2)
console.log(users);