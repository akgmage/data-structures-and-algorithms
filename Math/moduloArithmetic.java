public class moduloArithmetic {
    public static void main(String[] args) {
        int a = 2147483647;
        int b = 2;

        System.out.println((a + b) % 5);

        /**
         * ADDITION
         * (a + b) % c = (a % c + b %c) % c
         *
         * SUBTRACTION
         * (a-b) % c = (a % c - b % c) % c
         *
         * MULTIPLICATION
         * (a * b) % c = (a % c * b % c) % c
         *
         * DIVISION --> Inverse Modulo
         * (a + b) % c(5) = ?
         *
         * (2147483647 + 2) % 5 = 2147483647 % 5 = 4
         *
         * (a + b) % c = (a % c + b %c) % c
         * a = c * quotient1(q1)+ reminder1(r1)
         * a = c * quotient2(q2) + reminder2(r2)
         *
         * LHS
         *(a + b) % c | REPLACE a && b values
         * (c * q1 + r1 + c * q2 + r2) % c
         * (c * (q1 + q2) + r1 + r2) % c // (c * (q1 + q2) == c
         * (r1 + r2) % c
         *
         * RHS
         * (a % c + b %c) % c | REPLACE a && b values
         * ((c * q1 + r1) % c + (c * q2 + r2) % c ) % c
         * (r1 + r2 ) % c
         * */
        System.out.println(((a % 5) + (b % 5) % 5));
    }
}