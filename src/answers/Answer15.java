public class Answer15
{
  public static boolean isConsecutive(int[] givenArray)
    {
        // No 15
        if( givenArray.length <= 1)
            return true;
        else
            for( int i = 0; i < givenArray.length-1; i++)
        {
            if((givenArray[i] +1) !=  givenArray[i+1])
                return false;
        }
        return true;
    }
 
  public static boolean check()
  {
    int[] x = {2,3,4,5,6,7,8};
    if ( isConsecutive(x) == Answers.isConsecutive(x) )
      return true;
    else
      return false;
  }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
}
