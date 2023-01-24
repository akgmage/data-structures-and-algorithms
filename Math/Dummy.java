public class Dummy {

    public static void main(String[] args) {
       solve(20);
    }
    public static int solve(int num) {
        int count = 0;
        for(int i = 3; i <= num; i += 2)  {
            if(num % i != 0) {
                count += 1;
                System.out.println(i);
            }
        }
        return count;
    }
}

