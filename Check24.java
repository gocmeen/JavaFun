package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #24
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check24 extends Check{
    //right method for question:
    //Return  true if a non-negative integer is a multiple of 5.
    public static boolean modFive(int a) {
        // No 9
        if (a <= 0)
            return false;
        else {
            if (a % 5 == 0)
                return true;
        }
        return false;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("modFive", int.class);
        boolean checks = true;
        if (!checks && modFive(0) != (boolean)m.invoke(null, 0) && modFive(5) != (boolean)m.invoke(null, 5)
                && modFive(-5) != (boolean)m.invoke(null, -5) && modFive(12) != (boolean)m.invoke(null, 12)
                && modFive(-12) != (boolean)m.invoke(null, -12) ) // end of if statement, -12'yi 5in kat� olarak alm�yor; do�ru �al���yor.
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check24.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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