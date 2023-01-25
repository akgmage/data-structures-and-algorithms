//? https://www.algoexpert.io/questions/Spiral%20Traverse
//! O(n) time | O(n) space
function spiralTraverse(array) {
	const result = [];
	let startRow = 0,
		endRow = array.length - 1;
	let startCol = 0, 
		endCol = array[0].length - 1;
	
		while(startRow <= endRow && startCol <= endCol) {
			for(let col = startCol; col <= endCol; col++) {
				result.push(array[startRow][col]);
			}
			for(let row = startRow + 1; row <= endRow; row++) {
				result.push(array[row][endCol]);
			}
			for(let col = endCol - 1; col >= startCol; col--) {
				/**
				 * Handle the edge case when there's a single row
				 * in the middle of the matrix. In this case, we don't
				 * want to double-count the values in this row, which 
				 * we've already counted in the first for loop above.
				 */
				if(startRow == endRow) break;
				result.push(array[endRow][col]);
			}
			for(let row = endRow - 1; row > startRow; row--) {
				/**
				 * Handle the edge case when there's a single column
				 * in the middle of the matrix. In this case, we don't
				 * want to double-count the values in this column, which
				 * we've already counted in the second for loop above.
				 */
				if(startCol == endCol) break;
				result.push(array[row][startCol]);
			} 
			startRow++;
			endRow--;
			startCol++;
			endCol--;

		} return result;
}

const array = [
//!  					   		[1, 2, 3, 4],
//! Test case for line no. 18	[10, 11, 12, 5],
//! startRow === endRow	   		[9, 8, 7, 6]

//!       						  [1, 2, 3],
//!       						  [12, 13, 4],
//!  Test case for line no. 23    11, 14, 5],
//!  startCol === endCol     	  [10, 15, 6],
//!       						  [9, 8, 7]

]

console.log(spiralTraverse(array));



