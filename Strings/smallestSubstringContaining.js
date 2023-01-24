//! https://www.algoexpert.io/questions/Smallest%20Substring%20Containing
//! https://leetcode.com/problems/minimum-window-substring/

function smallestSubstringContaining(bigString, smallString) {
    const targetCharCounts = getCharCounts(smallString);
    const substringBounds = getStringBounds(bigString, targetCharCounts);
    return getStringFromBounds(bigString, substringBounds);
}

function getCharCounts(string) {
    const charCounts = {};
    for(const char of string) {
        increaseCharCount(char, charCounts);
    }
    return charCounts;
}

function getStringBounds(string, targetCharCounts) {
    let subStringBounds = [0, Infinity];
    const subStringCharCounts = {};
    const numUniqueChars = Object.keys(targetCharCounts).length;
    let numUniqueCharsDone = 0;
    let leftIdx = 0;
    let rightIdx =0;

    while(rightIdx < string.length) {
        const rightChar = string[rightIdx];
        if(!(rightChar in targetCharCounts)) {
            rightIdx++;
            continue;
        }
        increaseCharCount(rightChar, subStringCharCounts);
        if(subStringCharCounts[rightChar] == targetCharCounts[rightChar]) {
            numUniqueCharsDone++;
        }
        while(numUniqueCharsDone === numUniqueChars && leftIdx <= rightIdx) {
            subStringBounds = getCloserBounds(leftIdx, rightIdx, subStringBounds[0], subStringBounds[1]);
            const leftChar = string[leftIdx];
            if(!(leftChar in targetCharCounts)) {
                leftIdx++;
                continue;
            }
            if(subStringCharCounts[leftChar] === targetCharCounts[leftChar]) {
                numUniqueCharsDone--;
            }
            decreaseCharCount(leftChar, subStringCharCounts);
            leftIdx++;
        }
        rightIdx++;
    }
     return subStringBounds;
}

function getCloserBounds(idx1, idx2, idx3, idx4) {
    return idx2 - idx1 < idx4 - idx3 ? [idx1, idx2] : [idx3, idx4];
}

function increaseCharCount(char, charCounts) {
    charCounts[char] = (charCounts[char] || 0) + 1;
}

function decreaseCharCount(char, charCounts) {
    charCounts[char]--;
}

function getStringFromBounds(string, bounds) {
    const [start, end] = bounds;
    if(end == Infinity) return '';
    return string.slice(start, end + 1);
 }


 console.log(smallestSubstringContaining("abcd$ef$axb$c$", "$$abf"));