public class EvenAdjacent {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(solve(arr));
    }
    public static int solve(int arr[]) {
        int numOfEven = 0;
        int numOfOdd = 0;
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(num % 2 == 0)
                numOfEven++;
            else numOfOdd++;
        }
        return Math.min(numOfEven, numOfOdd);
    }
}