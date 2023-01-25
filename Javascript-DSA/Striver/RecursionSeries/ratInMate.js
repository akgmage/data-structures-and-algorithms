function findPathHelper(i, j, arr, n, ans, mov, visited) {
if(i == n - 1 && j == n - 1) {
    ans.push(mov);
    return;
}

// downward
    if(i + 1 < n && !visited[i + 1][j] && arr[i + 1][j] === 1) {
        visited[i][j] = 1;
        findPathHelper(i + 1, j, arr, n, ans, mov + "D", visited);
        visited[i][j] = 0;
    }
    // left
    if(j - 1 > -1 && !visited[i][j - 1] && arr[i][j - 1] === 1) {
        visited[i][j] = 1;
        findPathHelper(i, j - 1, arr, n, ans, mov + "L", visited);
        visited[i][j] = 0;
    }
    // right
    if(j + 1 < n && !visited[i][j + 1] && arr[i][j + 1] === 1) {
        visited[i][j] = 1;
        findPathHelper(i, j + 1, arr, n, ans, mov + "R", visited);
        visited[i][j] = 0;
    }
    // upward
    if(i - 1 > -1 && !visited[i - 1][j] && arr[i - 1][j] === 1) {
        visited[i][j] = 1;
        findPathHelper(i - 1, j, arr, n, ans, mov + "U", visited);
        visited[i][j] = 0;
    }
}

function findPath(m, n) {
  var ans = [];
  var visited = [...Array(n)].map(e => Array(n));
  if (m[0][0] === 1) findPathHelper(0, 0, m, n, ans, "", visited);
  return ans;
}

const m =  [ [1, 0, 0, 0],
             [1, 1, 0, 1],
             [1, 1, 0, 0],
             [0, 1, 1, 1] 
]; 
const n = 4;
console.log(findPath(m, n));


