package Patterns;

public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
//        solve(n);
          solve1(n);
    }
    public static void solve(int n) {
        String star = "*";
        int idx = 0;
        while(idx < n) {
            System.out.println(star);
            if(idx == n - 1) star += "*";
            else star += " *";
            idx++;
        }
    }
    public static void solve1(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == i)
                    System.out.print("*");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}
