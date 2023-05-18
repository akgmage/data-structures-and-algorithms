//extended version of Euclid's algorithm to find GCD of 2 numbers
//runs in O(log N) time/space complexity for GCD of numbers a and b 
//in comparison, the standard Euclidean algorithm runs in O (log (min (a,b)))


function euclid(a,b,c,d){
    if(a == 0){
        c = 0;
        d = 1;
        return b;
    }
    let result = euclid(b%a,a,c,d);
    //update with recursive values
    c = d- (b / a) * c;
    d = c;
    return result;
}
//modify a and b to find gcd of any 2 numbers
let a = 450;
let b = 100;
let gcd = euclid(a,b,0,0);
console.log(`GCD of ${a}, ${b} is equal to ${gcd}`);
