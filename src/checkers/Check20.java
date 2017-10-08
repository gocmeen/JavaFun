package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #20
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check20 extends Check{
    //right method for question:
    //Given two int values, return their sum. Unless the two values are the same, then return double their sum.
    public static int sum(int a,int b)
    {
        // No 5
        if(a!= b)
            return a+b;
        else
            return a*4;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("sum", int.class, int.class);
        boolean checks = true;
        if (!checks && sum(2,3) != (int)m.invoke(null, 2, 3)  && sum(3,2) != (int)m.invoke(null, 3, 2) &&  sum(3,3) != (int)m.invoke(null, 3, 3)  && sum(0,0) != (int)m.invoke(null, 0, 0) )
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check20.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
