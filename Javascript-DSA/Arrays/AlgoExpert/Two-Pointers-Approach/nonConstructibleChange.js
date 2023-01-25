//? https://www.algoexpert.io/questions/Non-Constructible%20Change
let coins = [5, 7, 1, 1, 2, 3, 22];

//! O(nlogn) | space O(1)

function findCoin(coins) {
   coins.sort((a, b) => a - b);

   const currentChangeCreated = 0;
   for(const coin in coins) {
       if(coin > currentChangeCreated + 1) return currentChangeCreated + 1;

       currentChangeCreated += coins;
   }
}



console.log(findCoin(coins));