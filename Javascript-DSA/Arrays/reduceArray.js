function reduceArray(array) {

    const count = {};
    const result = [];

    for(let i = 0; i < array.length; i++) {
       if(!(array[i] in count)) {
           count[array[i]] = 1;
       } else {
           count[array[i]] += 1;
       }
    }
    for(const num in count) {
        if(count[num] == 1) {
            result.push(parseInt(num))
        } 
        if(count[num] >= 2) {
            result.push(parseInt(num))
            result.push(parseInt(num))
        } 
    }
    return result;
}       

const array = [1, 2, 2, 3, 3, 3, 4, 4 ,6];

console.log(reduceArray(array));