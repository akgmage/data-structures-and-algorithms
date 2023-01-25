var reverseVowels = function(s) {
    
    let vowelCount = [];
    
    for(let i = 0; i < s.length; i++) {
        const letter = s[i];
        if(letter in VOWELS) vowelCount.push(letter);
    }
    let k = vowelCount.length - 1;
    let str = s.split('');
    for(let i = 0; i < s.length; i++) {
        const letter = s[i];
        if(letter in VOWELS){
             str[i] = vowelCount[k--];
        }
    }
    return str.join('');
};

const VOWELS = {
    'a': true,
    'e': true,
    'i': true,
    'o': true,
    'u': true,
    'A': true,
    'E': true,
    'I': true,
    'O': true,
    'U': true,
}


console.log(reverseVowels("aA"));