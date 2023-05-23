
function coinChangeGreedy(s, l) {
    // First step: sort l in descending order
    l.sort((a, b) => b - a);
  
    let r = []; // Result list
    let sumr = 0; // Keep track of the current sum of r to avoid iterating over r to calculate the sum
  
    for (let coin of l) {
      if (sumr === s) { // The sum of r is the target sum s
        break;
      }
  
      let n = Math.floor((s - sumr) / coin); // Calculate the max n with sum(r) + l[i] * n <= s
  
      for (let i = 0; i < n; i++) { // Append n elements of this coin to r
        r.push(coin);
      }
  
      sumr += coin * n; // Update the sum of r
    }
  
    if (sumr !== s) { // The target sum s was not reached
      return false;
    }
  
    return r;
  }
  
  // SAMPLE 1 (optimal)
  console.log(coinChangeGreedy(60, [5, 10, 25]));
  
  // SAMPLE 2 (not optimal)
  console.log(coinChangeGreedy(50, [25, 10, 30, 5]));
  
  // SAMPLE 3 (fails)
  console.log(coinChangeGreedy(50, [25, 30]));
  