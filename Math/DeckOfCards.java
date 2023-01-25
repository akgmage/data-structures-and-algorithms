//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
public class DeckOfCards {
    public static void main(String[] args) {
        int[] deck = {1,2,3,4,4,3,2,1};
        System.out.println(solve(deck));
    }
    public static boolean solve(int[] deck) {
        int[] count = new int[10000];
        for(int i: deck)
                count[i]++; // get counts;
        int g = 0;
        for(int c: count) // find gcd of all counts;
            if(c > 0)
                if(g == 0)
                    g = c;
                else
                    g = gcd(g, c);
        System.out.println(g);
        return g > 1;
    }
    public static int gcd(int x, int y) {
        return x == 0 ? y: gcd(y % x, x);
    }
}
