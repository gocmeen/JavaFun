public class Answer13
{  
  public static boolean sameTwoElements(int[] a)
  {
    // No 13
    if(a.length>=2)
    {
      if(a[0]==a[1])
        return true;
      else
        return false;
    }
    return false;
  }
  
  public static boolean check()
  {
    int[] x = {2,3,4,5,5,6,7};
     if ( sameTwoElements(x) == Answers.sameTwoElements(x) )
       return true;
     else
       return false;
  }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
}