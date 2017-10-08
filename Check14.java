package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #14
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */
public class Check14 extends Check{
    //right method for question:
    //Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
    public static String putTogether(String s1, String s2) {
        // No 14
        return s1 + s2 + s2 + s1;
    } 
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("putTogether", String.class, String.class);
        if(putTogether("abc","def").equals(m.invoke(null, "abc", "def"))
               && putTogether("","").equals(m.invoke(null, "", ""))
               && putTogether("abc","").equals(m.invoke(null, "abc", ""))
               && putTogether("","def").equals(m.invoke(null, "", "def"))
               && putTogether("abcafasdasdasd","dsdsadassdasdsef").equals(m.invoke(null, "abcafasdasdasd", "dsdsadassdasdsef")))
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
                    InputStream is = Check14.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
