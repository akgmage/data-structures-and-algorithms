// var findTheDifference = function(s, t) {
    
//     const obj = {};
//    for(let i = 0; i < s.length; i++) {
//         if(!obj[s[i]]) obj[s[i]] = 0;
//         obj[s[i]] += 1;
//    }
   
//    let result = "";
//    for(let i = 0; i < t.length; i++) {
//     if(obj[t[i]]) obj[t[i]] -= 1;
//     else if(!obj[t[i]]) result += t[i]
//    }
//    return result;
  
//     let sum1 = 0;
    
//     for(let i = 0; i < s.length; i++) {
//         sum1 += s[i].charCodeAt();
//     }
//     let sum2 = 0;
    
//     for(let i = 0; i < t.length; i++) {
//         sum2 += t[i].charCodeAt();
//     }
//     return String.fromCharCode(sum2 - sum1);
// };

// const s = "a";
const s = "abcde";
// const t = "aa";
const t = "acd";


