package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #23
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check23 extends Check{
    //right method for question:
    //Return the number of times ëaí chars appear in a string.
    public static int howManyInString(String s) {
        // No 8
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' )
                count++;
        }
        return count;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("howManyInString", String.class);
        boolean checks = true;
        if (!checks || howManyInString("baran") != (int)m.invoke(null, "baran")
                || howManyInString("baran ataman") != (int)m.invoke(null, "baran ataman")
                || howManyInString("qwertyu�op��i�lkjhgfdsazxcvbnm��.<>|,") != (int)m.invoke(null, "qwertyu�op��i�lkjhgfdsazxcvbnm��.<>|,"))
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check23.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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