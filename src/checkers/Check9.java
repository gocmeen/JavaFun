package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #9
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check9 extends Check
{
    //right method for question:
    //Given 2 strings, a and b, return a string of the form short+long+short, 
    //with the shorter string on the outside and the longer string on the inside.
    //The strings will not be the same length, but they may be empty (length 0).
    public static String stringSandwich(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            if (s1.length() < s2.length())
                return s1 + s2 + s1;
            else
                return s2 + s1 + s2;
        }
        else
            return "Strings are of the same size";
    }
    
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("stringSandwich", String.class, String.class);
        if( stringSandwich("abcd","").equals(m.invoke(null, "abcd",""))
               && stringSandwich("","aqwe").equals(m.invoke(null, "","aqwe"))
               && stringSandwich("a","a").equals(m.invoke(null, "a","a"))
               && stringSandwich("","").equals(m.invoke(null, "","")))
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
                    InputStream is = Check9.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
