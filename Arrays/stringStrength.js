function stringStrength(str) {
    let longest = [0, 1];
    let startIdx = 0;
    let lastSeen = {};

    for(let i = 0; i < str.length; i++) {
        const char = str.charAt(i);
        if(char in lastSeen) {
            startIdx = Math.max(startIdx, lastSeen[char] + 1);
        }
        if(longest[1] - longest[0] < i + 1 - startIdx) {
            longest = [startIdx, i + 1];
        }
        lastSeen[char] = i;
    }

    const longestStringLength = str.slice(longest[0], longest[1]).length;

    return ((longestStringLength / str.length) * 100).toFixed(2);
}

console.log(stringStrength("cccc"));