package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #28
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check28 extends Check
{  
    //right method for question:
    //Return true if the first element of two int arrays are the same.
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
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("sameTwoElements", int[].class);
        int[] x = {2,3,4,5,5,6,7};
        if ( sameTwoElements(x) == (boolean)m.invoke(null, x) )
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
                    InputStream is = Check28.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
