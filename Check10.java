package checkers;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #10
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */ 

public class Check10 extends Check{
    //right method for question:
    //  Given a string, return true if it ends in "ly".  
    public static boolean endLy(String s){
        // No 10
        if (s.length() >= 2) {
            if (s.substring(s.length()- 2, s.length()).equals("ly"))
                return true;
            else
                return false;
        }
        else
            return false;            
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("endLy", String.class);
        if( endLy("endly")== (boolean)m.invoke(null, "endly")
               && endLy("")== (boolean)m.invoke(null, "")
               && endLy("EndLlLyYL")== (boolean)m.invoke(null, "EndLlLyYL") )
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
                    InputStream is = Check10.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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