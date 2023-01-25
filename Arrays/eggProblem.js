function countEmptyCells(mat) {
	let count = 0;
	for(let i = 0; i < mat.length; i++) {
		for(let j = 0; j < mat[0].length; j++) {
			if(mat[i][j] === 0) count++;
			else break;
		}
	}
	return count;
}

let mat = [];
let line = true;
while(line) {
	let inp = readline();
	if(inp) {
		mat.push(inp.split(',').map(item => parseInt(item)));
	} else line = false;
}
console.log(countEmptyCells(mat));

// const mat = [ [10, 20, 30, 40],
//               [15, 25, 35, 45],
//               [24, 29, 37, 48],
//               [32, 33, 39, 50]];


// let result = [];
// 	for(let row = 0; row < mat[0].length; row++) {
// 		let sum = 0;
// 		for(let col = 0; col < mat.length; col++) {
// 			sum += mat[col][row];
// 		}
// 		result.push(sum);
// 	}

//     console.log(result);

// let result = [];
// 	for(let row = 0; row < mat[0].length; row++) {
// 		let sum = 0;
// 		for(let col = 0; col < mat.length; col++) {
// 			sum += mat[col][row];
// 		}
// 		result.push(sum);
// 	}
//     console.log(result);
