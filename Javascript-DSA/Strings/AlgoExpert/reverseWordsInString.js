//! O(n) time | O(n) space
function reverseWordsInString(string) {
  const characters = [];
  for(const char of string) 
      characters.push(char);
console.log(characters);
  
  reverseListRange(characters, 0, characters.length - 1);

  console.log(characters);
}

function reverseListRange(list, start, end) {

  while(start < end) {
      const temp = list[start];
      list[start] = list[end];
      list[end] = temp;
      start++;
      end--;
  }
}
const words = "AlgoExpert is the best!";


console.log(reverseWordsInString(words));