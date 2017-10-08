package checkers;
import java.lang.reflect.*;
import java.io.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen
 * 
 * Abstract Check class, template for the checker classes.
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public abstract class Check
{
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception {
        return false;
    }
    
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return null;
        }
    }
}
