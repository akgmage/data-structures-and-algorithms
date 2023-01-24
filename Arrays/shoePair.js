

function shoePair(arr) {

    let set = new Set();

    for(let i = 0; i < arr.length; i++) {
        for(let j = 0; j < arr[i].length; j++) {
            set.add(arr[i][j]);
        }
    }
    
    let result = [];

    for (const item of set.values()) {
        let temp = [item, item];
        result.push(temp);
    }
    return result;
}
const matrix = [[3,3,8],[9,8,9],[15,15]];

console.log(shoePair(matrix));