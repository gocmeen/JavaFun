package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #5
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check5 extends Check{
    //right method for question:
    //Given a number, return its factorial. use recursive.
    public static int factorial(int i) {
        if (i < 2)
            return 1;
        else
            return i * factorial(i - 1);
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        boolean checks = true;
        
        for (int i = 0; i < 10; i++) {
            Class<?> c = new AnswerLoader().loadClass("answer.Answer");
            Method m = c.getMethod("factorial", int.class);
            if (checks && (factorial(i) != (int)m.invoke(null,i)))
                checks = false;
        }
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check5.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
