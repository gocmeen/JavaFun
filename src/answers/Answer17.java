public class Answer17
{
  public static String Remover(String given)
    {
        // No 17
        if (given.length() == 0)
        {
            return given;
        }
        
        if (given.charAt(0) == 'y')
        {
            return "" + remover(given.substring(1));
        }
        return given.charAt(0) + recursiveRemover(given.substring(1));
    }
  
  
 public static boolean check()
 {
   if ( remover("").equals(Answers.remover(""))
         && recursiveRemover("answer").equals(Answers.recursiveRemover("answer")) 
         && recursiveRemover("question").equals(Answers.recursiveRemover("question")) )
     return true;
   
   return false;
 } 
 
 public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
}
