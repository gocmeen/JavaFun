package storyprinter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * date: 3 May 2016
 * author: Berat Bicer
 * 
 * StoryPrinter Class for reading stories from a txt file
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */ 

public class StoryPrinter
{      
    File file;
    int length;
    boolean finished = false;
    
    public StoryPrinter(){}
    
    public String setStoryPart ( int story,int part )
    {
        if( story == 1 )
        {
            file = new File("storyprinter\\LordOfTheRings.txt");
            length = 10;
        }
        else if( story == 2 )
        {
            file = new File("storyprinter\\DoctorWhoSeason9.txt");
            length = 12;
        }
        else if( story == 3 )
        {
            file = new File("storyprinter\\Sherlock.txt");
            length = 11;
        }
        else
        {
            file = null;
            length = 0;
        }
        
        int count = 0;
        String str="";
        
        if( part == length )
            finished = true;
        if( 0 < part && part < length +1 )
        {
            try
            {
                Scanner scan = new Scanner( file );
                
                while ( scan.hasNextLine() == true )
                {
                    String s = scan.nextLine();                        
                    
                    if( !s.equals( "*****" ) && count + 1 == part )
                        str+=s;
                    else if( s.equals( "*****" ) )
                        count++;
                }
                scan.close();
                return str;
            } 
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return "";
    }
    
    public boolean isFinished()
    {
        return finished;
    }
    
    public void setFinished()
    {
        finished = false;
    }
    public static void main( String[] args )
    {
        StoryPrinter x = new StoryPrinter();
        System.out.println(x.setStoryPart( 1,2 ));
    }
}
