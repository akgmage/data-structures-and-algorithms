function powerHelper(a, n) {
  if (n == 1) return a;
  let mid = Math.floor(n / 2);
  let b = powerHelper(a, mid);
  let c = b * b;
  console.log(c)
  if (n % 2 === 0) return c;
  return a * c;
}

function power(a, n) {
    let ans;
    if(n < 0) {
        ans = powerHelper(a,  -1 * n);
        ans = 1.0 / ans;
    }
     else {
        ans = powerHelper(a, n);
     }
    return ans;
}
console.log(power(2.00000, -2));
