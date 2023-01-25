// ! 25/01/2022

function f(str, output) {
    if(str == "") {
        console.log(output);
        return;
    }
    let ch = str[0]; // ! a
    let restOfTheString = str.substring(1); // ! bc
    // console.log("restOfTheString",restOfTheString);
    f(restOfTheString, output + ch);
    f(restOfTheString, output);
}

f("abc", "");