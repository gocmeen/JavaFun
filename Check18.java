package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #18
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check18 extends Check{
    //right method for question:
    //Given a number n, return true if n is in the range 1..10, inclusive.
    public static boolean isInRange(int a)
    {
        // No 3
        if( a < 1 || a > 10 )
            return false;
        else
            return true;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("isInRange", int.class);
        boolean checks = true;
        if (!checks && isInRange(0) != (boolean)m.invoke(null, 0) &&  isInRange(10) != (boolean)m.invoke(null, 10) && isInRange(1) != (boolean)m.invoke(null, 1) && isInRange(7) != (boolean)m.invoke(null, 7) && isInRange(12) != (boolean)m.invoke(null, 12))
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check18.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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