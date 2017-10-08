package quest;
import java.util.ArrayList;
import java.io.*;

/**
 * QuestionList class will take Strings from 
 * a txt file which are questions and answers,
 * contain them in Question objects and throw
 * them in a Question ArrayList.
 * 
 * @Oguz Gocmen
 */

public class QuestionList
{
    // properties
    ArrayList<Question> list;
    Question question;
    int i = -1;
    
    // constructor
    public QuestionList( String questionFile)//, String answerFile)
    {
        list = new ArrayList<Question>();
        
        // takes inputs from two seperate txt files(q & a), combines them and adds them to ArrayList
        try {
            BufferedReader questions = new BufferedReader(new FileReader( questionFile));
            //BufferedReader answers = new BufferedReader(new FileReader( answerFile));
            String q, a;
            while (( q = questions.readLine()) != null )//&& (a = answers.readLine()) != null)
            {
                question = new Question( q);//, a);
                list.add( question);
            }
            questions.close();
            //answers.close();
        } catch (IOException e) {
        }
    }
    
    //methods
    
    //getQuestion
    public Question getQuestion( int index)
    {
       return list.get(index);
    }
}