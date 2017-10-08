package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #21
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check21 extends Check{
    //right method for question:
    // Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie.
    public static int nearestValue(int a,int b)
    {
        // No 6
        if(Math.abs(10-a)< Math.abs(10-b))
            return a;
        else if(Math.abs(10-a)> Math.abs(10-b))
            return b;
        else
            return 0;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("nearestValue", int.class, int.class);
        boolean checks = true;
        if (!checks && nearestValue(5,5) != (int)m.invoke(null, 5, 5)  && nearestValue(5, 15) != (int)m.invoke(null, 5, 15) && nearestValue(10,10) != (int)m.invoke(null, 10, 10) )
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check21.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
