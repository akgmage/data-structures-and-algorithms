class Solution {
public:
    int countPrimes(int n) {
        if(n <= 1) return 0;
        bool seive[n];
        for(int i = 0; i < n; i++) 
            seive[i] = true;
        seive[0] = false; seive[1] = false;
        for(int i = 2; i * i < n; i++){
            if(seive[i]){
                for(int j = i * i; j < n; j += i){
                    seive[j] = false;
                }
            }
        }
        return count(seive, seive + n, true);
    }
};