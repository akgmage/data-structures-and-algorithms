 import java.util.Arrays;
  import java.util.Scanner;
  
  public class test {
	  public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
  
		  System.out.print("Enter the number of coin types (2type of coins or 5 type of coins): \n");
		  int numCoins = scanner.nextInt();
  
		  
		  int[] coins = new int[numCoins];
		  System.out.println("Now Enter the number of coin of a particular type\n");
		  
		  for (int i = 0; i < numCoins; i++) {
			System.out.println("Enter the number of coin of type "+ (i+1));
			  coins[i] = scanner.nextInt();
		  }
  
		  System.out.print("Enter the target amount: ");
		  int targetAmount = scanner.nextInt();
  
		  int minCoins = getMinCoins(coins, targetAmount);
		  System.out.println("Minimum number of coins needed: " + minCoins);
  
		  scanner.close();
	  }
  
	  public static int getMinCoins(int[] coins, int targetAmount) {
		  Arrays.sort(coins); // Sort the coins in ascending order
  
		  int coinIndex = coins.length - 1; // Start with the largest coin
		  int minCoins = 0;
  
		  while (targetAmount > 0) {
			  int currentCoin = coins[coinIndex];
  
			  if (currentCoin <= targetAmount) {
				  int numCoins = targetAmount / currentCoin;
				  minCoins += numCoins;
				  targetAmount -= numCoins * currentCoin;
			  }
  
			  coinIndex--; // Move to the next smaller coin
		  }
  
		  return minCoins;
	  }
  }
  
