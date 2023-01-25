package Patterns;

public class Pattern19 {
    //https://practice.geeksforgeeks.org/problems/double-triangle-pattern/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_19
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int n) {

       //   upper half
        for(int i = n; i >= 1; i--) {

            // Star
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }

            //Star

            for(int j = 1; j <= i; j++){

                System.out.print("*");

            }

            System.out.println();
        }

        // Lower Half
        for(int i = 1; i <= n; i++){
            // Star
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            // Spaces
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");

            }
            //Star
            for(int j = 1; j <= i; j++){
                System.out.print("*");

            }
            System.out.println();

        }

    }
}
