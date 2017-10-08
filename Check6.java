package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #8
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */
public class Check6 extends Check{
    //right method for question:
    //Given an array of ints, return true if 6 appears as either the first or last element in the array.
    public static boolean lookFor6(int[] i) {
        if ( i.length == 0)
            return false;
        else if ((i[0] == 6 && i[i.length - 1] != 6) || (i[0] != 6 && i[i.length - 1] == 6))
            return true;
        else 
            return false;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        boolean checks = true;
        
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("lookFor6", int[].class);
        
        int[] a = new int[] {6,0,7};
        int[] b = new int[] {6,5,6};
        int[] e = new int[] {4,6,8,2};
        int[] d = new int[] {3,6,7,6};
        
        if (checks && (lookFor6(a) != (boolean)m.invoke(null, a)))
            checks = false;
        if (checks && (lookFor6(b) != (boolean)m.invoke(null, b)))
            checks = false;
        if (checks && (lookFor6(e) != (boolean)m.invoke(null, e)))
            checks = false;
        if (checks && (lookFor6(d) != (boolean)m.invoke(null, d)))
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check6.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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