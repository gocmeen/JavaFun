package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #27
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check27 extends Check
{
    //right method for question:
    //Given an array of ints, swap the first and last elements in the array.
    public static void swap(int[] a)
    {
        // No 12
        if(a.length>=2)
        {
            int tmp = 0;
            
            tmp = a[0];
            a[0]= a[a.length -1];
            a[a.length-1]=tmp;
        }
        else
            System.out.println("Unexpected value!");
    }
//check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    { 
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("swap", int[].class);
        int[] x = {2,3,5,8,2,3,9,7};
        int[] y = {2,3,5,8,2,3,9,7};
        swap(x);
        m.invoke(null, y);
        
        for ( int i = 0; i < x.length; i++ )
        {
            if ( x[i] != y[i]  )
                return false;
        }  
        return true;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check27.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
