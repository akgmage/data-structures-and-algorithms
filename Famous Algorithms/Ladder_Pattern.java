import java.util.Scanner;  
public class Ladder_Pattern 
{  
  public static void main(String args[])   
  {  
    Scanner sc=new Scanner(System.in);  
    System.out.print("Enter the number of steps: " );  
    //reads an integer form the user  
    //n is the number of steps in ladder  
    int n=sc.nextInt();  
    for(int i=1;i<=n*3+2;i++)  
    {  
      for(int j=1;j<=5;j++)  
      {  
        if(i%3==0)  
        System.out.print("*");  
        else if(j==1||j==5)  
        System.out.print("*");  
        else  
        System.out.print(" ");  
      }  
      //throws cursor to the new line  
      System.out.println();  
    }  
  }  
}  
