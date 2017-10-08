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

public class Check8 extends Check{
    //right method for question:
    //Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
    public static String greet(String s)
    {
        return "Hello " + s + "!";
    }
    
    //check method looking to test cases for comparing users' methods' output with the right method 
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("greet", String.class);
        if( greet("berat").equals(m.invoke(null, "berat"))
               && greet("beyza").equals(m.invoke(null, "beyza"))
               && greet("g�kberk").equals(m.invoke(null, "g�kberk"))
               && greet("").equals(m.invoke(null, "")))
            return true;
        else
            return false;   
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check8.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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