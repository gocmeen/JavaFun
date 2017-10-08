package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #32
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check32 extends Check
{
    //right method for question:
    //Given a string, compute recursively a new string where all the ëyí chars have been removed.
    public static String remover(String given)
    {
        // No 17
        if (given.length() == 0)
        {
            return given;
        }
        
        if (given.charAt(0) == 'y')
        {
            return "" + remover(given.substring(1));
        }
        return given.charAt(0) + remover(given.substring(1));
    }
    
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("deleteSubstring", String.class);
        
        if ( remover("").equals(m.invoke(null, ""))
                && remover("answer").equals(m.invoke(null, "answer")) 
                && remover("question").equals(m.invoke(null, "question")) )
            return true;
        
        return false;
    } 
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check32.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
