package BitManipulation;

public class SwapNumsUsingXOR {
    public static void main(String[] args) {
        int a = 5, b = 7;

        a = a ^ b; // 5 ^ 7
        b = a ^ b; // 5 ^ 7 ^ 7 --> 5
        a = a ^ b; // 5 ^ 7 ^ 5 --> 7

    }
}
