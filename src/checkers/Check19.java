package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer, Mehmet Oguz Gocmen
 * 
 * Checker class for question #19
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check19 extends Check{
    //right method for question:
    //Given a non-empty string and an int n, return a new string where the char at index n has been removed.
    public static String charAtString( String s,int n )
    {
        // No 4
        if(s.equals("")== false && n >= 0 && n < s.length() )
            return s.charAt(n)+"";
        else
            return "Unexpected value!";
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("charAtString", String.class, int.class);
        boolean checks = true;
        if (!checks && !charAtString("baran", 4).equals(m.invoke(null, "baran", 4))  && !charAtString("baran", 0).equals(m.invoke(null, "baran", 0)) && !charAtString("baran",1).equals(m.invoke(null, "baran", 1)) )
            checks = false;
        return checks;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check19.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
