
 //! O(n^2) time | O(n) space
function isPalindrome(string) {
	let reversedString = '';
	for(let i = string.length - 1; i >= 0; i) {
		reversedString += string[i];
	}
	return string === reversedString;
}

//! O(n) time | O(n) space
function isPalindrome(string) {
 
	const reversedChars = [];
	for(let i = string.length - 1; i >= 0; i--) {
		reversedChars.push(string[i]);
	}
	return string === reversedChars.join('');
}

//! O(n) time | O(n) space
function isPalindrome(string, i = 0) {
	const j = string.length - 1 - i;
	return i >= j ? true : string[i] === string[j] && isPalindrome(string, i + 1);
}

//!O(n) time | O(1) space
function isPalindrome(string) {
	  let i = 0;
    let j = string.length - 1;
	  while(i < j) {
			if(string[i] != string[j]) return false;
			i++; 
			j--;
		}
	return true;
}