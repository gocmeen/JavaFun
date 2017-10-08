package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #4
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check4 extends Check{
    //right method for question:
    //Check the number whether it is an armstrong number or not. return true if it is.
    public static boolean isArmstrong(int i) {
        int first = i % 10;
        int sec = (i % 100) / 10;
        int third = i / 100;
        if ( (i + "").length() != 3)
            return false;
        else if ( (int)Math.pow(first, 3) + (int)Math.pow(sec, 3) + (int)Math.pow(third, 3) == i )
            return true;
        else
            return false;
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        boolean checks = true;
        
        for (int i = 0; i < 999; i++) {
            Class<?> c = new AnswerLoader().loadClass("answer.Answer");
            Method m = c.getMethod("isArmstrong", int.class);
            if (checks && (isArmstrong(i) != (boolean)m.invoke(null, i)))
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
                    InputStream is = Check4.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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

