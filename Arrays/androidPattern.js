//! 28/01/2022
let hoptable = []; 

function calcPattern(visited, curr, remain) {
    if(remain == 0) return 1;
    visited[curr] = true;
    let ans = 0;
    for(let i = 1; i <= 9; i++) {
        if(!visited[i] && (hoptable[curr][i] == 0 || visited[hoptable[curr][i]] == true)) {
            ans += calcPattern(visited, i, remain - 1);
        }
    }
    visited[curr] = false;
    return ans;

}
function countPattern(m, n) {
    for(let i = 0; i < 10; i++) {
        hoptable.push(Array(10).fill(0));
    }
    hoptable[1][3] = hoptable[3][1] = 2;
    hoptable[1][7] = hoptable[7][1] = 4;
    hoptable[3][9] = hoptable[9][3] = 6;
    hoptable[7][9] = hoptable[9][7] = 8;
    hoptable[1][9] = hoptable[9][1] = hoptable[3][7] = hoptable[7][3] = hoptable[2][8] = hoptable[8][2] = hoptable[4][6] = hoptable[6][4] = 5;
    let ans = 0;
    let visited = Array(9).fill(false);
    for(let i = m; i <= n; i++) {
        ans += calcPattern(visited, 1, i-1)*4;
        ans += calcPattern(visited, 2, i-1)*4;
        ans += calcPattern(visited, 5, i-1);
    }
    return ans;

}

console.log(countPattern(1,2));


