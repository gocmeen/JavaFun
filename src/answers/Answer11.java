import java.util.Arrays;

public class Answer11
{
  public static int[] evenButNotDivisibleByThree()
  {
    // No 11
    // IMPORTANT: I assumed that we will return an array
    int[] array = new int[15];
    int count = 0;
    int number = 0;
    
    while(count<15)
    {
      number++;
      
      if(number%2==0 && number%3!=0)
      {
        array[count]=number;
        count++;
      }
    }
    return array; 
  }
  
  public static boolean check()
  {
      if( Arrays.equals(Answers.evenButNotDivisibleByThree(),evenButNotDivisibleByThree()))
        return true;
      return false;
  }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
  
}
