//! O(n^2) time | O(1) space - where n is the length of the input string
function firstNonRepeatingCharacter(string) {
 for(let i = 0; i < string.length; i++) {
	 let foundDuplicate = false;
	 for(let j = 0; j < string.length; j++) {
		 if(string[i] === string[j] && i !== j) foundDuplicate = true;
	 }
	 if(!foundDuplicate) return i;
 }
	return -1;
}

//! O(n) time | O(1) space - where n is the length of the input string
//! The constant space is because the input string only has lowercase.
//! English-alphabet letters; thus our hash table will never have more than
//! 26 character frequencies.

function firstNonRepeatingCharacter(string) {
   const characterFrequencies = {};
	
	for(const character of string) {
		if( !(character in characterFrequencies)) characterFrequencies[character] = 0;
		characterFrequencies[character]++;
	}

for(let i = 0; i < string.length; i++) {
	const character = string[i];
	if(characterFrequencies[character] === 1) return i;
}
return -1;
}

//! my logic
function firstNonRepeatingCharacter(string) {
  let hash_table = {};
	for(const char of string) {
		if ( !(char in hash_table)) hash_table[char] = 0;
		
		hash_table[char]++;
	}
	for( const [char, count] of Object.entries(hash_table)) {
		  if(count == 1) return string.indexOf(char); //! indexOf take O(n) time for finding index 
	} return -1;
}
const string = "abbccddcaff";
console.log(firstNonRepeatingCharacter(string));