//! O(n + m) time | O(c) space - where n is the number of characters, m is
//! ths length of the document, and c is the number of unique characters in the characters string.
function generateDocument(characters, document) {
	const characterCounts = {}; 
	for(const character of characters) {
		if(! (character in characterCounts)) characterCounts[character] = 0;
		
		characterCounts[character]++;
	}
	for(const character of document) {
		if( !(character in characterCounts) || characterCounts[character] === 0) return false;
		characterCounts[character]--;
	}
	return true;
}


//! O(m * (n + m)) time | O(1) space - where n is the number
//! of characters and m is the length of the document

function generateDocument(characters, document) {
for(const character of document) {
	const documentFrequency = countCharacterFrequency(character, document);
	const charactersFrequency = countCharacterFrequency(character, characters);
	if(documentFrequency > charactersFrequency) return false;
}
	return true;
}

function countCharacterFrequency(character, target) {
	let frequency = 0;
	for(const char of target)
		if(char === character) frequency++;
	return frequency;
}



//! my logic, passed all test cases;
//! my logic O(n + m) time | O(c) space c is no of unique characters;
function generateDocument(characters, document) {
  let hash_table = {};
	 for(let i = 0; i < characters.length; i++) {
		   if(hash_table[characters[i]]) {
				 hash_table[characters[i]] += 1;
			 } else {
				 hash_table[characters[i]] = 1;
			 }
	 }
     console.log(hash_table);
	for(let i = 0; i < document.length; i++) {
         if(!(document[i] in hash_table)) return false;
		 if(hash_table[document[i]] === 0) 
				return false;
				hash_table[document[i]] -= 1;
}
console.log("------------------------");
console.log(hash_table);
	return true;
}

let characters = "Bste!hetsi ogEAxpelrt x ";
let document = "AlgoExpert is the Best!";

let characters = "helloworld ";
let document = "hello wOrld";

let characters = "hello";
let document = "wOrld";

console.log(generateDocument(characters, document));