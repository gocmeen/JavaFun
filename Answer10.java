public class Answer10  
{
  public static boolean multipleOf(int a)
  {
    // No 10
    if(a<=0)
      return false;
    else
    {
      if(a%2==0 && a%3!=0)
        return true;
    }
    return false;
  }
  
  public static boolean check()
  {
    if ( multipleOf(7) == Answers.multipleOf(7) 
       && multipleOf(56) == Answers.multipleOf(56)
          && multipleOf(43) == Answers.multipleOf(43) )
      return true;
    else
      return false;
  }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
  
}