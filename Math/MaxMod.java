public class MaxMod {
    public static void main(String[] args) {

        int A[] = {1, 2, 44, 3};
        System.out.println(solve(A));
    }
    public static int solve(int arr[]) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            }
            if(num > secondMax && num != firstMax)
                secondMax = num;
        }
        System.out.println(firstMax + "," + secondMax);
        if(firstMax == Integer.MIN_VALUE || secondMax == Integer.MIN_VALUE) return 0;
        return secondMax % firstMax;
    }
}