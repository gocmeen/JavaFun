package checkers;
import java.lang.reflect.*;
import java.io.*;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #1
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */ 

public class Check1 extends Check{
    //right method for question:
    // Check the number whether its even or odd. return true if its even.
    public static boolean isEven(int i) {
        return i % 2 == 0;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        boolean checks = true;
        System.out.println("yay");
        for (int i = 0; i < 100; i++) {
            Class<?> c = new AnswerLoader().loadClass("answer.Answer");
            Method m = c.getMethod("isEven", int.class);
            
            if (checks && (isEven(i) != (boolean)m.invoke(null, i)))
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
                    InputStream is = Check1.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
