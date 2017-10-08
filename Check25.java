package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #25
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check25 extends Check
{
    //right method for question:
    //Return  true if a non-negative integer is multiple of 2 but not 3.
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
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("multipleOf", int.class);
        if ( multipleOf(7) == (boolean)m.invoke(null, 7) 
                && multipleOf(56) == (boolean)m.invoke(null, 56) 
                && multipleOf(43) == (boolean)m.invoke(null, 43)  )
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
                    InputStream is = Check25.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
