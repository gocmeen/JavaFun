package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #17
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check17 extends Check{
    //right method for question:
    //Given two numbers, return the biggest one.
    public static int biggerNumber(int a, int b) {
        // No 2
        if (a < b)
            return b;
        else
            return a;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception{
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("biggerNumber", int.class, int.class);
        boolean checks = true;
        if (!checks && biggerNumber(3, 4) != (int)m.invoke(null,3, 4)
                && biggerNumber(4, 3) != (int)m.invoke(null,4, 3) && biggerNumber(3, 3) != (int)m.invoke(null,3, 3)
                && biggerNumber(-4, -3) != (int)m.invoke(null,-4, -3)) // end of if statement
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check17.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
