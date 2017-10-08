package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #29
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included 
 */
public class Check29 extends Check
{
    //right method for question:
    //Return a given string with the characters in reverse order.
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
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("reverseString", String.class);
        
        if ( reverseString("beyza").equals(m.invoke(null, "beyza")) 
                && reverseString("berat").equals(m.invoke(null, "berat")) 
                && reverseString("baran").equals(m.invoke(null, "baran")))
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
                    InputStream is = Check29.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
