public class Answer14
{
  public static String reverseString(String s)
  {
    // No 14
    if(s.length()>=2)
    {
      String reverse = new StringBuffer(s).reverse().toString();
      return reverse;
    }
    else
      return "Unexpected value!";
  }
  
  public static boolean check()
  {
    if ( reverseString("beyza").equals(Answers.reverseString("beyza")) 
          && reverseString("berat").equals(Answers.reverseString("berat")) 
          && reverseString("baran").equals(Answers.reverseString("baran")))
      return true;
    else
      return false;
  }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
}
