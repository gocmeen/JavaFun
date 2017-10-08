package quest;
/**
 * Question class for making question objects 
 * which will store the question along with
 * its' answer...
 * 
 * @Oguz Gocmen
 */

public class Question
{
    // properties
    private String question, answer;
    
    // constructor
    public Question( String givenQuestion)//, String givenAnswer)
    {
        this.question = givenQuestion;
        //this.answer = givenAnswer;
    }
    
    // methods
    
    // returns the question
    public String getQuestion()
    {
        return this.question;
    }
    
    // toString method for displaying the question and answer in console
    public String toString()
    {
        return "Question: " + this.question ;//+ "Answer: " + this.answer;
    }
}
