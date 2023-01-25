let a = [
    [1, 2, 3], 
    [2, 3, 4], 
    [3, 4, 5]
];

let b = [
    [1, 2, 3], 
    [2, 3, 4], 
    [3, 4, 5]
]

function add(a, b) {
    let rows = a.length; //! find rows
    let cols = a[0].length; //! find columns
    let c = [];

    for(let i = 0; i < rows; i++) {
        c.push(Array(cols).fill(0));
    }

    for(let i = 0; i < rows; i++) {
      for(let j = 0; j < cols; j++) {
         c[i][j] = a[i][j] + b[i][j];
    }
}
return c;

}

console.log(add(a, b));