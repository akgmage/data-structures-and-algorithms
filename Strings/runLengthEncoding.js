// function runLengthEncoding(string) {
// 	//!The input string is guaranteed to be non-empty,
// 	//! so first run will be of at least length 1.
// 	const encodedStringCharacters = [];
// 	let currentRunLength = 1;
// 	for(let i = 1; i < string.length; i++) {
// 		const currentCharacter = string[i];
// 		const previousCharacter = string[i - 1];
		
// 		if(currentCharacter !== previousCharacter || currentRunLength == 9) {
// 			encodedStringCharacters.push(currentRunLength.toString());
// 			encodedStringCharacters.push(previousCharacter);
// 			currentRunLength = 0;
// 		}
// 		currentRunLength++;
// 	}
// 	//! Handle the last run.
// 	encodedStringCharacters.push(currentRunLength.toString());
// 	encodedStringCharacters.push(string[string.length - 1]);
	
// 	return encodedStringCharacters.join('');
	
// }

// //! myLogic : only working for few test cases.
// function runLengthEncoding(string) {
// 	let char = string[0];
// 	let count = 1;
// 	let output = [];
// 	for(let i = 1; i <= string.length; i++) {
// 		if(char !== string[i]) {
// 			output.push(count + char);
// 			char = string[i];
// 			count = 0;
//         }
// 		if(char === string[i]) {
// 			count++;
// 		}
// 		if(count == 9) {
// 			let temp = count + char;
// 			output.push(temp);
// 			temp = '';
// 			count = 0;
// 		}
// 	}
// 	return output.join('');
// }


function runLengthEncoding(string) {
  let resultStr = "";
	let counts = [];
	let chars = [];
	
	for(let i = 0; i < string.length; i++) {
		let j = i;
		let char = string[i];
		let temp = 1;
		while(char == string[j]) {
				j++;
				temp++;
		}
		counts.push(temp);
		chars.push(string[i]);
		i = j;
	}
	
	
	console.log(chars, counts)
	for(let i = 0; i < counts.length; i++) {
		if(counts[i] > 9) {
			let k = counts[i] % 10;
			let z = 9 + chars[i] + k + chars[i];
			resultStr += z;
		}
		else {
			let a = counts[i] + chars[i];
		resultStr += a;
		}
	}
	return resultStr;
}

// Do not edit the line below.
exports.runLengthEncoding = runLengthEncoding;


// let str = 'AAAAAAAAAAAAABBCCCCDD';
let str = 'aaAA';

console.log(runLengthEncoding(str));