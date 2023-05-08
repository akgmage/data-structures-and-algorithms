public class ExcelColumnTitle {
    public static void main(String[] args) {
        int a = 100;
        String ans = solve(a);
        System.out.println(ans);
    }

    public static String solve(int a) {
        // time O(LogN) time | K space where K is the character count
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            a--;
            int curr = a % 26;
            a /= 26;
            sb.append((char)(curr+'A'));
            System.out.println(sb);
        }
        return sb.reverse().toString();
    }
}
