public class PerfectSquare {
    /**
     * Scaler class 4 jan 2023
     */

    public static void main(String[] args) {
        int num = 84630800;
//        System.out.println(solve1(num));
        System.out.println(solve2(num));
    }
    public static int solve1(int num) {
       int sr = (int)Math.sqrt(num);
       if(sr * sr == num) return sr;
       return -1;
    }
    public static int solve2(int num) {
        for(int i = 1; i * i <= num; i++) {
            if (i * i == num) return i;
        }
        return -1;
    }
}
