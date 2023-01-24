//! O(n) time | O(n) space
function arrayOfProducts(array) {
  const products = new Array(array.length).fill(1);

	let leftRunningProduct = 1;
	for(let i = 0; i < array.length; i++){
		products[i] = leftRunningProduct;
		leftRunningProduct *= array[i];
	}
	let rightRunningProduct = 1;
	for(let i = array.length - 1; i > -1; i--) {
		products[i] *= rightRunningProduct;
		rightRunningProduct *= array[i];
	}
}

//! O(n) time | O(n) space
function arrayOfProducts(array) {
 const products = new Array(array.length).fill(1);
 const leftProducts = new Array(array.length).fill(1);
 const rightProducts = new Array(array.length).fill(1);

	let leftRunningProduct = 1;
	for(let i = 0; i < array.length; i++) {
		leftProducts[i] = leftRunningProduct;
		leftRunningProduct *= array[i];
	}
	let rightRunningProduct = 1;
	for(let i = array.length - 1;  i > -1; i--) {
		 rightProducts[i] = rightRunningProduct;
		 rightRunningProduct *= array[i];
	}
	for(let i = 0; i < array.length; i++) {
		products[i] = leftProducts[i] * rightProducts[i];
	}
	return products;
}

//! O(n^2) time | O(n) space
function arrayOfProducts1(array) {
	const products = [];

	for(let i = 0; i <array.length; i++) {
		let runningProduct = 1;
		for(let j = 0; j < array.length; j++) {
			  if(i != j) {
					runningProduct *= array[j];
				}
		}
		products[i] = runningProduct;

	}
	return products;
}

console.log(arrayOfProducts([1, 2, 3, 4]));
