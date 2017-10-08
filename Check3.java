package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #3
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check3 extends Check{
    //right method for question:
    //Check the number whether it is a palindrome or not. return true if it is.
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        else if ( s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        else
            return isPalindrome(s.substring(1, s.length() - 1));
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        boolean checks = true;
        
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("isPalindrome", String.class);
        
        if (checks && (isPalindrome("") != (boolean)m.invoke(null, "")))
            checks = false;
        if (checks && (isPalindrome("a") != (boolean)m.invoke(null, "a")))
            checks = false;
        if (checks && (isPalindrome("ab") != (boolean)m.invoke(null, "ab")))
            checks = false;
        if (checks && (isPalindrome("ey edip adanada pide ye") != (boolean)m.invoke(null, "ey edip adanada pide ye")))
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check3.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
