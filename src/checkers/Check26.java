package checkers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
 * date: 3 May 2016
 * authors: Gokberk Aktulay, Beyza Tugce Bilgic, Baran Ataman, Berat Bicer
 * 
 * Checker class for question #26
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class Check26 extends Check
{
    //right method for question:
    //Return a list of first 15 even numbers which are not divisible by 3.
    public static int[] evenButNotDivisibleByThree()
    {
        int[] array = new int[15];
        int count = 0;
        int number = 0;
        
        while(count<15)
        {
            number++;
            
            if(number%2==0 && number%3!=0)
            {
                array[count]=number;
                count++;
            }
        }
        return array; 
    }
    //check method looking to test cases for comparing users' methods' output with the right method
    public static boolean check() throws Exception
    {
        Class<?> c = new AnswerLoader().loadClass("answer.Answer");
        Method m = c.getMethod("evenButNotDivisibleByThree");
        if( Arrays.equals(((int[])m.invoke(null, new Object[] {})),evenButNotDivisibleByThree()))
            return true;
        return false;
    }
    // inner class for creating a class file to compile from user input
    static class AnswerLoader extends ClassLoader {
        @Override 
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            if (name.equals("answer.Answer")) {
                try {
                    InputStream is = Check26.class.getClassLoader().getResourceAsStream("answer/Answer.class");
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
