/* 
We have a problem where we are given a set of coins 
and our task is to form a sum of money n using the coins. 
The values of the coins are coins = {c1, c2,..., ck}, 
and each coin can be used as many times we want. 
What is the minimum number of coins needed?
For example, if the coins are the euro coins (in cents) {1,2,5,10,20,50,100,200} 
and n = 520, we need at least 4 coins. 
The coins being 200 + 200 + 100 + 20 whose sum is 520.

Approach:
The greedy approach for the coin change problem works by selecting the 
largest denomination available at each step 
and repeatedly subtracting it from the remaining amount until 
the amount becomes zero or cannot be further reduced. 
This approach makes locally optimal choices at each step, 
hoping to reach the global optimum.

Here's an explanation of the greedy approach for the coin change problem:

1) Sort the available denominations in descending order. 
This step ensures that we always consider the largest denomination first.

2) Initialize a variable count to keep track of the number of coins used.

3) Iterate through the sorted denominations:

4) At each iteration, check if the current denomination is 
less than or equal to the remaining amount to be changed.
If it is, subtract the current denomination from the remaining amount 
and increment count by one.
Repeat this process until the current denomination is greater than the remaining amount.
After the loop ends, the value of count will represent the minimum number 
of coins required to make the given amount of change.

Note: It's important to note that the greedy approach may not always 
provide the optimal solution for the coin change problem, 
especially if the denominations are arbitrary or 
not well-suited for a greedy strategy. 
In some cases, the greedy approach may produce an incorrect result.

*/
// Javascript program using above approach

function findMin(num) {
	// Initialize result
	let ans = 0;
  
	// Traverse through all denominations
	for (let i = deno.length - 1; i >= 0; i--) {
	  // Find denominations
	  while (num >= deno[i]) {
		num -= deno[i];
		ans++;
	  }
	}
  
	// Print result
	console.log(ans);
  }
  
  // Driver code
  // No. of available denominations
  let len = parseInt(prompt("Enter the no. of available denominations: "));
  
  // All denominations of Indian Currency
  let deno = [];
  for (let i = 0; i < len; i++) {
	let input = parseInt(prompt("Enter the element: "));
	deno.push(input);
  }
  
  // Amount to be changed
  let n = parseInt(prompt("Enter the amount: "));
  findMin(n);
  