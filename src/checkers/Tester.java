package checkers;
import answer.*;
import java.util.*;
import java.lang.reflect.*;
import java.io.*;
import java.net.*;

public class Tester {
   
   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      
      int i = scan.nextInt();
      
      while (i != 0) {
         try {
            if (i == 1)
            {
            	System.out.println(Check1.check());
               
            }
            if (i == 2)
            {
                System.out.println(Check2.check());
            }
            if (i == 3)
            {
            	System.out.println(Check3.check());
            }
            if (i == 4)
            {
            	System.out.println(Check4.check());
            }
            if (i == 5)
            {
            	System.out.println(Check5.check());
            }
            if (i == 6)
            {
            	System.out.println(Check6.check());
            }
            if (i == 7)
            {
            	System.out.println(Check7.check());
            }
            
         }
         catch (Exception e) {
            System.out.println(e);
         }
         i = scan.nextInt();
      }
    scan.close();  
   }
}
