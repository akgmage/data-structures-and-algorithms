function f(str, i) {
    if(i == str.length - 1) {
    console.log(str);
    return;
    }
    let arr = Array(26).fill(false);
    for(let j = i; j < str.length; j++) {
        let current_char = str[j];

        if(arr[current_char.charCodeAt(0) - 97] == false)  {
            arr[current_char.charCodeAt(0) - 97] = true;
            swap(str, i, j);
            f(str, i+1);
            swap(str, i, j);
        }
    }
}

function swap(str, m, n) {
    let temp = str[m];
    str[m] = str[n];
    str[n] = temp;
}
let arr = ['a', 'b', 'a'];

f(arr, 0);