public class AddDigits {

    public static void main(String[] args){
      int num = 20;
//      System.out.println(solve(num));
        /**
         * O(1) time
         * if (num == 0) return 0;
         *         if (num % 9 == 0) return 9;
         *         return num % 9;
         *         simply
         *         return num == 0 ? 0 : 1 + (num - 1) % 9;
         */
    }

    public static int solve(int num) {
        int val = num;
        int result = 0;
        while(val > 9) {
            result = val % 10;
            result += val / 10;
            val = result;
        }
        return result;
    }
}