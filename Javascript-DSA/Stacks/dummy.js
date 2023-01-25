function a(arr) {

    let n = arr.length;
    let array = Array(2 * n);
    let result = [];
    
   
    for(let i = 0; i < n; i++) {
        result[i] = -1;
    }

    for(let i = 0; i < arr.length; i++) {
        array[i] = array[n + i] = arr[i];
    }
    
    
    for(let i = 0; i < arr.length; i++) {
        let j = i + 1;
        while(j < arr.length + i) {
        if(array[j] > array[i]) {
            // result.splice(i, 0, array[j]);
            result[i] = array[j];
            break;
        }
        j++;
    }
    // if(j == arr.length + i + 1 && array[j] < array[i]) 

    // {
    //     // console.log("j", j);
    //     // console.log("i", i);
    //     result.splice(i, 0, -1);
    // }
}

return result;
}


let arr = [2, 5, -3, -4, 6, 7, 2];
// let arr = [1, 0, 1, 0, 1, 0, 1];

console.log(a(arr));
// a(arr);