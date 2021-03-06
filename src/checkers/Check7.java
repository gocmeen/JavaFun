package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #7
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check7 extends Check{
    //right method for question:
    //  Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}. 
    public static int[] returnPi(){
        int[] pi = new int[3];
        pi[0] = 3;
        pi[1] = 1;
        pi[2] = 4;
        return pi;
    }
    
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("returnPi");
        if (((int[])m.invoke(null, new Object[] {})).length == 3) {
            if (((int[])m.invoke(null, new Object[] {}))[0] == 3 && ((int[])m.invoke(null, new Object[] {}))[1] == 1 &&
                ((int[])m.invoke(null, new Object[] {}))[2] == 4)
                return true;
            else
                return false;
        }
        else
            return false;
        
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check7.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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

