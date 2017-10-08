public class Answer16
{
  public static String deleteSubstring(String s)
 {
  // No 16
  if(s.length()>=2)
  {
   String str=s.replaceAll("hi","");
   return str;
  }
  else
   return "Unexpected value!";
 }
  
  public static boolean check()
 {
   if ( deleteSubstring("").equals(Answers.deleteSubstring("")) 
         && deleteSubstring("answer").equals(Answers.deleteSubstring("answer")) 
         && deleteSubstring("question").equals(Answers.deleteSubstring("question")))
     return true;
   
   return false;
 }
  
  public static void main( String[] args)
  {
    System.out.println(check()); 
  }
  
}
