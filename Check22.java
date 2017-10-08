package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #22
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check22 extends Check{
    //right method for question:
    //Return the sum of two int values. If both of them are even, then return double their sum.
    public static int sumOrDoubleSum(int a,int b)
    {
        // No 7
        if( a % 2 == 0 && b % 2 == 0)
            return 2 * (a+b);
        else
            return a+b;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("sumOrDoubleSum", int.class, int.class);
        boolean checks = true;
        if (!checks && sumOrDoubleSum(3,4) != (int)m.invoke(null, 3, 4) && sumOrDoubleSum(4,3) != (int)m.invoke(null, 4, 3)  && sumOrDoubleSum(4,4) != (int)m.invoke(null, 4, 4) && sumOrDoubleSum(3,3) != (int)m.invoke(null, 3, 3) )
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check22.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
