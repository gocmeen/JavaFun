public class Answer12
{
  public static void swap(int[] a)
 {
  // No 12
  if(a.length>=2)
  {
   int tmp = 0;
  
   tmp = a[0];
   a[0]= a[a.length -1];
   a[a.length-1]=tmp;
  }
  else
   System.out.println("Unexpected value!");
 }
  
  public static boolean check()
  {
    int[] x = {2,3,5,8,2,3,9,7};
    int[] y = {2,3,5,8,2,3,9,7};
    swap(x);
    Answers.swap(y);
    
    for ( int i = 0; i < x.length; i++ )
    {
      if ( x[i] != y[i]  )
      return false;
    }  
    return true;
  }
  
  public static void main( String[] args)
  {
    System.out.println( check()); 
  }
  
  
  
}
