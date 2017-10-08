package checkers;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #11
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check11 extends Check{
    //right method for question:
    //Given a string, return true if the first 2 chars in the string also appear at the end of the string, such as with "edited".
    public static boolean first2Repeats(String s){
        // NO 11
        if (s.length() >= 2) {
            if (s.substring(s.length()- 2, s.length()).equals(s.substring(0, 2)))
                return true;
            else
                return false;
        }
        else
            return true;            
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("first2Repeats", String.class);
        if(first2Repeats("abcd")== (boolean)m.invoke(null, "abcd")
               && first2Repeats("")==(boolean)m.invoke(null, "") 
               && first2Repeats("beeeb")==(boolean)m.invoke(null, "beeeb")
               && first2Repeats("bbbbbb")==(boolean)m.invoke(null, "bbbbbb"))
            return true;
        else
            return false;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check11.class.getClassLoader().getResourceAsStream("answer/Answer.class");
                    byte[] buf = new byte[10000];
                    int len = is.read(buf);
                    return defineClass(name, buf, 0, len);
                } 
                catch (IOException e) {
                    throw new ClassNotFoundException("", e);
                }
            }
            return getParent().loadClass(name);
        }
    }
}
