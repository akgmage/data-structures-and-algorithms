package Strings;

public class ValidateSubsequence {
  public static void main(String[] args) {

      int array[] = {5, 1, 22, 25, 6, -1, 8, 0};
      int sequence[] = {1, 6, -1, 10};
      System.out.println(solve(array, sequence));
  }
    public static Boolean solve(int array[], int sequence[]) {

      int seqIdx = 0;
      for(int i = 0; i < array.length; i++) {
          int num = array[i];
          if(seqIdx == sequence.length) break;
          if(sequence[seqIdx] == num) seqIdx++;
      }
        return seqIdx == sequence.length;
  }
}