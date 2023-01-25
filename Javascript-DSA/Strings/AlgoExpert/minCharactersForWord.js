//! O(n * l) time | O(c) space - where n is the number of words,
//! l is the length of the longest word, and c is the
//! number of unique characters across all words.


function minimumCharactersForWords(words) {
    const maximumCharacterFrequencies = {};

    for(const word of words) {
        const characterFrequencies = countCharacterFrequencies(word);
        updateMaximumCharacterFrequencies(characterFrequencies, maximumCharacterFrequencies);
    }

    return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
}

function countCharacterFrequencies(string) {
    const characterFrequencies = {};

    for(const character of string) {
        if(!(character in characterFrequencies)) characterFrequencies[character] = 0;
        characterFrequencies[character] += 1;
    }
    return characterFrequencies;
}

function updateMaximumCharacterFrequencies(frequencies, maximumFrequencies) {

    for(const character in frequencies) {
        const frequency = frequencies[character];

        if(character in maximumFrequencies) maximumFrequencies[character] = Math.max(maximumFrequencies[character], frequency);
        else {
            maximumFrequencies[character] = frequency;
        }

        
        
    }       
}


function makeArrayFromCharacterFrequencies(characterFrequencies) {
    const characters = [];
    for(const character in characterFrequencies) {

        const frequency = characterFrequencies[character];

        for(let i = 0; i < frequency; i++) {
            characters.push(character);
        }
    }
    return characters;
}


const words =  ["this", "that", "did", "deed", "them!", "a"];
console.log(minimumCharactersForWords(words));