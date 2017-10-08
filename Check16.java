package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #16
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check16 extends Check{
    //right method for question:
    //Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive, are forbidden, so in that case just return 20.
    public static int forbiddenInterval(int a,int b)
    {
        // No 1
        if( a+b < 10 || a+b > 19 )
            return a+b;
        else
            return 20;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("forbiddenMethod", int.class, int.class);
        boolean checks = true;
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (!checks && forbiddenInterval(i,j) != (int)m.invoke(null, i, j) )
                    checks = true;
            }
        }
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check16.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
