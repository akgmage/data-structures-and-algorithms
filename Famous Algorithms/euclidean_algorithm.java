//extended version of Euclid's algorithm to find GCD of 2 numbers
//runs in O(log N) time/space complexity for GCD of numbers a and b 
//in comparison, the standard Euclidean algorithm runs in O (log (min (a,b)))

public class euclidean_algorithm {
    public static int euclid(int a, int b, int c, int d){
        if(a == 0){
            c = 0;
            d = 0;
            return b;
        }
        int c1 = 1,d1 = 1;
        int result = euclid(b%a, a, c1, d1);
        //update with recursive call
        c = d1 - (b / a) * c1;
        d = c1;
        return result;
    }
    //driver
    public static void main(String[] args) {
        int c =1, d = 1;
        int a = 45;
        int b = 10;
        int gcd = euclid(a, b, c, d);
        System.out.print("gcd of "+ a+"," +b +" is equal to: " + gcd);
    }
}
