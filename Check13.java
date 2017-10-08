package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #13
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */
public class Check13 extends Check{
    //right method for question:
    //Given a string, return a new string made of 3 copies of the first 2chars of the original string. The string may be any length. If there are  fewer than 2 chars, use whatever is there.
    public static String clone2Chars(String s) {
        // No 13
        String str = "";
        if (s.length() > 1) {
            str = s.substring(0,2);
            str = str + str + str;
        }
        else if (s.length() == 1) {
            str = s.substring(0,1);
            str = str + str + str;
        }
        else
            str="Unexpected value!";
        return str;
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("clone2Chars", String.class);
        if(clone2Chars("abcd").equals(m.invoke(null, "abcd"))
               && clone2Chars("q").equals(m.invoke(null, "q"))
               && clone2Chars("ch").equals(m.invoke(null, "ch"))
               && clone2Chars("qwedsadqwd").equals(m.invoke(null, "qwedsadqwd")))
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
                    InputStream is = Check13.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
