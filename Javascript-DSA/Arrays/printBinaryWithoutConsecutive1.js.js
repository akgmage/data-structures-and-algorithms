function f(n, i, str) {
    if(i == n) {
        console.log(str);
        return;
    }
    if(i > n) return;
    if(str[str.length - 1] == '0') {
        f(n, i + 1, str + '0');
        f(n, i + 1, str + '1');
    } else if(str[str.length - 1] == '1') {
        // f(n, i + 2, str + '01');
        f(n, i + 1, str + '0');
    }
}

let n = 4;

f(n, 1, "0");
f(n, 1, "1");