//? https://www.algoexpert.io/questions/Move%20Element%20To%20End
//! O(n) time | O(1) space
function moveElementToEnd(array, toMove) {
let i = 0;
let j = array.length - 1;
while(i < j) {
	while( i < j && array[j] == toMove) j--;
	  if(array[j] == toMove) [ array[i], array[j] ] = [ array[j], array[i] ];
	  i++;
  } return array;
}

