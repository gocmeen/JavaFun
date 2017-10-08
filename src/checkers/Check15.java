package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #15
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */
public class Check15 extends Check{
    //right method for question:
    //Given 2 strings, return their concatenation, except omit the first char of each.The strings will be at least length 1.
    public static String concatenate(String s1, String s2) {
        // No15
        if (s1.length() < 1 || s2.length() < 1)
            return "Strings too short";
        else
            return s1.substring(1) + s2.substring(1);
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("concatenate", String.class, String.class);
        if(concatenate("","").equals(m.invoke(null, "",""))
               && concatenate("q","").equals(m.invoke(null, "q",""))
               && concatenate("","q").equals(m.invoke(null, "","q"))
               && concatenate("xx","qwe").equals(m.invoke(null, "xx","qwe"))
               && concatenate("e","r").equals(m.invoke(null, "e","r")))
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
                    InputStream is = Check15.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
