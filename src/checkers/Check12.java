package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #12
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */ 

public class Check12 extends Check{
    //right method for question:
    //Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.
    public static String removeX(String s) {
        if(s.length()>1)
        {
            // No 12
            if (s.charAt(0) == 'x')
                s = s.substring(1);
            if (s.charAt(s.length() - 1) == 'x')
                s = s.substring(0, s.length() - 1);
            return s;
        }
        else
            return "Unexpected value!";
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("removeX", String.class);
        if( removeX("beratx").equals(m.invoke(null, "beratx"))
               && removeX("xberatx").equals(m.invoke(null, "xberatx"))
               && removeX("q").equals(m.invoke(null, "q"))
               && removeX("").equals(m.invoke(null, ""))
               && removeX("xbxexrxaxtx").equals(m.invoke(null, "xbxexrxaxtx")))
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
                    InputStream is = Check12.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
