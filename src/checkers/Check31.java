package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #31
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check31 extends Check
{
    //right method for question:
    //If the string ìhiî appears, return a string that ìhiî has been deleted. Otherwise, return the unchanged string.
    public static String deleteSubstring(String s)
    {
        // No 16
        if(s.length()>=2)
        {
            String str=s.replaceAll("hi","");
            return str;
        }
        else
            return "Unexpected value!";
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("deleteSubstring", String.class);
        if ( deleteSubstring("").equals(m.invoke(null,"")) 
                && deleteSubstring("answer").equals(m.invoke(null,"answer")) 
                && deleteSubstring("question").equals(m.invoke(null,"question")))
            return true;
        
        return false;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check30.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
