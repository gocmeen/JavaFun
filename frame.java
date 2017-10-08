package GUI;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import storyprinter.*;
import quest.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen, Beyza Tugce Bilgic, Berat Bicer, Baran Ataman
 * 
 * frame class for taking all GUIs in a CardLayout with all ActionListeners
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class frame
{
    //constants
    private final Font FONT = new JLabel().getFont();
    
    //properties
    private CardLayout cardLayout;
    private JPanel cardpanel;
    private MainMenu m;
    private StorySelection s;
    private QuestionPage q;
    private OptionsMenuGUIex op;
    private CreditsGUI cr;
    private CongratsPage cp;
    private StoryPrinter storyPrint;
    private JFrame f;
    private QuestionList list;//extra
    private static int story;
    private static int storyPart;
    private int questionIndex;
    
    public frame()
    {
        // initializes the frame's properties
        f = new JFrame();
        f.setTitle("Java Fun");
        f.setPreferredSize( new Dimension(650, 670));
        f.getContentPane().setBackground(Color.RED);
        f.setLayout(new FlowLayout());
        
        // creates instances of GUI stuff and layout for transition
        cardLayout = new CardLayout();
        cardpanel = new JPanel( cardLayout);
        m = new MainMenu();
        s = new StorySelection();
        q = new QuestionPage();
        op =  new OptionsMenuGUIex();
        cr = new CreditsGUI();
        cp = new CongratsPage();
        storyPrint = new StoryPrinter();
        list = new QuestionList("quest\\questions.txt");
        story = 0;
        questionIndex = -1;
        
        // adds instances to cardpanel
        cardpanel.add(m, "1");
        cardpanel.add(s, "2");
        cardpanel.add(q, "3");
        cardpanel.add(op, "4");
        cardpanel.add(cr, "5");
        cardpanel.add(cp, "6");
        
        // adds cardpanel to frame
        f.add(cardpanel);
        f.pack();
        f.setVisible(true); 
        
        // shows main menu screen first
        cardLayout.show( cardpanel, "1");
        
        // adds ActionListeners to all buttons
        m.getButton("start").addActionListener( new MyActionListener() );
        m.getButton("options").addActionListener( new MyActionListener() );
        m.getButton("credits").addActionListener( new MyActionListener() );
        m.getButton("exit").addActionListener( new MyActionListener() );
        s.getButton("main").addActionListener( new MyActionListener() );
        s.getButton("next").addActionListener( new MyActionListener() );
        q.getButton("back").addActionListener( new MyActionListener() );
        q.getButton("next").addActionListener( new MyActionListener() );
        q.getButton("check").addActionListener( new MyActionListener() );
        cr.getButton("back").addActionListener( new MyActionListener() );
        op.getButton("back").addActionListener( new MyActionListener() );
        op.getRadioButton("box1").addActionListener( new MyActionListener() );
        op.getRadioButton("box2").addActionListener( new MyActionListener() );
        cp.getButton("main").addActionListener( new MyActionListener() );
        s.getRadio("story1").addActionListener( new MyActionListener() );
        s.getRadio("story2").addActionListener( new MyActionListener() );
        s.getRadio("story3").addActionListener( new MyActionListener() );
        
    }
    
    // method for changing fonts of all components in each GUI instance with a recursive method
    public static void changeFont ( Component component, Font font )
    {
        component.setFont ( font );
        if ( component instanceof Container )
        {
            for ( Component child : ( ( Container ) component ).getComponents () )
            {
                changeFont ( child, font );
            }
        }
    }
    
    public int getIndex() {
        return questionIndex + 1;
    }
    
    // method for changing background of parent panels in each GUI instance with a recursive method
    public void setPanelColor(Container parent, Color panelColor)
    {
        for(Component c : (parent.getComponents()))
        {
            if(c instanceof Container)
            {
                c.setBackground(panelColor);
                setPanelColor((Container)c, panelColor);
            }
        }
    }
    
    // MyActionListener for listening buttons( All ActionListeners are here since we used CardLayout to organize)
    class MyActionListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            CardLayout cardLayout = (CardLayout)(cardpanel.getLayout());
            JComponent pressedButton = (JComponent) e.getSource();
            
            if( pressedButton == q.getButton("check"))
            {
                try {
                    boolean compiled = q.compile();
                    System.out.println(getIndex());
                    boolean bq = q.check(getIndex());
                    System.out.println(bq);
                    if (bq)
                    {
                        q.getButton("check").setText( "CORRECT!!!");
                        q.getButton("next").setEnabled(true);
                    }
                    else
                        q.getButton("check").setText( "INCORRECT!!! TRY AGAIN!!!");
                }
                catch (Exception localIOException) {}
            }
            //main menu start button
            else if ( pressedButton == m.getButton("start"))
            {
                cardLayout.show( cardpanel, "2");
                System.out.println( "select" );
            }
            // back to main menu button in StorySelection GUI
            else if ( pressedButton == s.getButton("main") )
            {
                cardLayout.show( cardpanel, "1");
            }
            // next button in StorySelection GUI
            else if (  pressedButton == s.getButton("next") )
            {
                storyPart = 0;
                // selects a story and initializes properties in order to display story parts and questions 
                if (  s.getRadio("story1").isSelected() )
                {
                    story = 1;
                    questionIndex= 0;
                    System.out.println( "story 1 selected" );
                }
                else if( s.getRadio("story2").isSelected())
                {
                    story = 2;
                    questionIndex= 10;
                    System.out.println( "story 2 selected" );
                }
                else if( s.getRadio("story3").isSelected())
                {
                    story = 3;
                    questionIndex= 22;
                    System.out.println( "story 3 selected" );
                }
                
                //starts the selected story
                storyPart++;
                q.setTextField("story",storyPrint.setStoryPart(story, storyPart));
                q.setTextField("question", list.getQuestion(questionIndex).getQuestion());
                //extraaaa
                q.getButton("check").setText( "Check Answer...");
                if( getIndex() == 1)
                    q.setAnswerField( "public static boolean isEven(int i){\n\n}");
                else if( getIndex() == 11 )
                    q.setAnswerField( " public static boolean first2Repeats(String s){\n\n}");
                else if( getIndex() == 23)
                    q.setAnswerField( "public static int howManyInString(String s, char ch){\n\n}");
                
                
                cardLayout.show( cardpanel, "3");
            }
            // next button in QuestionPage GUI
            else if ( pressedButton == q.getButton("next"))
            {
                // if story is not finished, proceeds to next story part and question each time
                // next button pressed in QuestionPage GUI
                if( !storyPrint.isFinished())
                {
                    storyPart++;
                    questionIndex++;
                    q.setTextField("story",storyPrint.setStoryPart(story, storyPart));
                    q.setTextField("question", list.getQuestion(questionIndex).getQuestion());
                    
                    if( getIndex() == 1)
                        q.setAnswerField( "public static boolean isEven(int i){\n\n}");
                    else if( getIndex() == 2 )
                        q.setAnswerField( "public static boolean isPrime(int i) {\n\n}");
                    else if( getIndex() == 3 )
                        q.setAnswerField( "public static boolean isPalindrome(String s) {\n\n}");
                    else if( getIndex() == 4 )
                        q.setAnswerField( "public static boolean isArmstrong(int i) {\n\n}");
                    else if( getIndex() == 5 )
                        q.setAnswerField( "public static int factorial(int i) {\n\n}");
                    else if( getIndex() == 6 )
                        q.setAnswerField( "public static boolean lookFor6(int[] i) {\n\n}");
                    else if( getIndex() == 7 )
                        q.setAnswerField( "public static int[] returnPi() {\n\n}");
                    else if( getIndex() == 8 )
                        q.setAnswerField( "public static String greet(String s) {\n\n}");
                    else if( getIndex() == 9 )
                        q.setAnswerField( "public static String stringSandwich(String s1, String s2) {\n\n}");
                    else if( getIndex() == 10 )
                        q.setAnswerField( "public static boolean endLy(String s) {\n\n}");
                    else if( getIndex() == 11 )
                        q.setAnswerField( " public static boolean first2Repeats(String s){\n\n}");
                    else if( getIndex() == 12 )
                        q.setAnswerField( "public static String removeX(String s) {\n\n}");
                    else if( getIndex() == 13)
                        q.setAnswerField( "public static String clone2Chars(String s) {\n\n}");
                    else if( getIndex() == 14)
                        q.setAnswerField( "public static String putTogether(String s1, String s2) {\n\n}");
                    else if( getIndex() == 15)
                        q.setAnswerField( "public static String concatenate(String s1, String s2) {\n\n}");
                    else if( getIndex() == 16)
                        q.setAnswerField( "public static int forbiddenInterval(int a,int b) {\n\n}");
                    else if( getIndex() == 17)
                        q.setAnswerField( "public static int biggerNumber(int a, int b) {\n\n}");
                    else if( getIndex() == 18)
                        q.setAnswerField( "public static boolean isInRange(int a) {\n\n}");
                    else if( getIndex() == 19)
                        q.setAnswerField( "public static String charAtString( String s,int n ) {\n\n}");
                    else if( getIndex() == 20)
                        q.setAnswerField( "public static int sum(int a,int b) {\n\n}");
                    else if( getIndex() == 21)
                        q.setAnswerField( "public static int nearestValue(int a,int b) {\n\n}");
                    else if( getIndex() == 22)
                        q.setAnswerField( " public static int sumOrDoubleSum(int a,int b) {\n\n}");
                    else if( getIndex() == 23)
                        q.setAnswerField( "public static int howManyInString(String s, char ch){\n\n}");
                    else if( getIndex() == 24)
                        q.setAnswerField( "public static boolean modFive(int a) {\n\n}");
                    else if( getIndex() == 25)
                        q.setAnswerField( "public static boolean multipleOf(int a) {\n\n}");
                    else if( getIndex() == 26)
                        q.setAnswerField( "public static int[] evenButNotDivisibleByThree() {\n\n}");
                    else if( getIndex() == 27)
                        q.setAnswerField( "public static void swap(int[] a) {\n\n}");
                    else if( getIndex() == 28)
                        q.setAnswerField( "public static boolean sameTwoElements(int[] a) {\n\n}");
                    else if( getIndex() == 29)
                        q.setAnswerField( "public static String reverseString(String s) {\n\n}");
                    else if( getIndex() == 30 )
                        q.setAnswerField( "public static boolean isConsecutive(int[] givenArray) {\n\n}");
                    else if( getIndex() == 31 )
                        q.setAnswerField( "public static String deleteSubstring(String s) {\n\n}");
                    else if( getIndex() == 32 )
                        q.setAnswerField( "public static String remover(String given) {\n\n}");
                    
                    System.out.println( "story in progress" );
                    q.getButton("check").setText( "Check Answer...");
                    q.getButton("next").setEnabled(false);
                    q.setTextField("answer", "");
                }
                // if story is finished, proceeds to CongratsPage when next button pressed
                // in QuestionPage GUI
                else
                {
                    storyPart = 0;
                    System.out.println( "story finished" );
                    cardLayout.show( cardpanel, "6");
                }
            }
            // back button in QuestionPage GUI
            else if (  pressedButton == q.getButton("back") )
            {
                //decrement
                storyPart--;
                questionIndex--;
                // if story did not come to beginning, goes back to previous story part and question
                // each time back 
                if( storyPart >= 1)
                {
                    System.out.println( "back" );
                    q.setTextField("story",storyPrint.setStoryPart(story, storyPart));
                    q.setTextField("question", list.getQuestion(questionIndex).getQuestion());
                    // extraaaaa
                    q.getButton("next").setEnabled(true);
                    if( getIndex() == 1)
                        q.setAnswerField( "public static boolean isEven(int i){\n\n}");
                    else if( getIndex() == 2 )
                        q.setAnswerField( "public static boolean isPrime(int i) {\n\n}");
                    else if( getIndex() == 3 )
                        q.setAnswerField( "public static boolean isPalindrome(String s) {\n\n}");
                    else if( getIndex() == 4 )
                        q.setAnswerField( "public static boolean isArmstrong(int i) {\n\n}");
                    else if( getIndex() == 5 )
                        q.setAnswerField( "public static int factorial(int i) {\n\n}");
                    else if( getIndex() == 6 )
                        q.setAnswerField( "public static boolean lookFor6(int[] i) {\n\n}");
                    else if( getIndex() == 7 )
                        q.setAnswerField( "public static int[] returnPi() {\n\n}");
                    else if( getIndex() == 8 )
                        q.setAnswerField( "public static String greet(String s) {\n\n}");
                    else if( getIndex() == 9 )
                        q.setAnswerField( "public static String stringSandwich(String s1, String s2) {\n\n}");
                    else if( getIndex() == 10 )
                        q.setAnswerField( "public static boolean endLy(String s) {\n\n}");
                    else if( getIndex() == 11 )
                        q.setAnswerField( " public static boolean first2Repeats(String s){\n\n}");
                    else if( getIndex() == 12 )
                        q.setAnswerField( "public static String removeX(String s) {\n\n}");
                    else if( getIndex() == 13)
                        q.setAnswerField( "public static String clone2Chars(String s) {\n\n}");
                    else if( getIndex() == 14)
                        q.setAnswerField( "public static String putTogether(String s1, String s2) {\n\n}");
                    else if( getIndex() == 15)
                        q.setAnswerField( "public static String concatenate(String s1, String s2) {\n\n}");
                    else if( getIndex() == 16)
                        q.setAnswerField( "public static int forbiddenInterval(int a,int b) {\n\n}");
                    else if( getIndex() == 17)
                        q.setAnswerField( "public static int biggerNumber(int a, int b) {\n\n}");
                    else if( getIndex() == 18)
                        q.setAnswerField( "public static boolean isInRange(int a) {\n\n}");
                    else if( getIndex() == 19)
                        q.setAnswerField( "public static String charAtString( String s,int n ) {\n\n}");
                    else if( getIndex() == 20)
                        q.setAnswerField( "public static int sum(int a,int b) {\n\n}");
                    else if( getIndex() == 21)
                        q.setAnswerField( "public static int nearestValue(int a,int b) {\n\n}");
                    else if( getIndex() == 22)
                        q.setAnswerField( " public static int sumOrDoubleSum(int a,int b) {\n\n}");
                    else if( getIndex() == 23)
                        q.setAnswerField( "public static int howManyInString(String s, char ch){\n\n}");
                    else if( getIndex() == 24)
                        q.setAnswerField( "public static boolean modFive(int a) {\n\n}");
                    else if( getIndex() == 25)
                        q.setAnswerField( "public static boolean multipleOf(int a) {\n\n}");
                    else if( getIndex() == 26)
                        q.setAnswerField( "public static int[] evenButNotDivisibleByThree() {\n\n}");
                    else if( getIndex() == 27)
                        q.setAnswerField( "public static void swap(int[] a) {\n\n}");
                    else if( getIndex() == 28)
                        q.setAnswerField( "public static boolean sameTwoElements(int[] a) {\n\n}");
                    else if( getIndex() == 29)
                        q.setAnswerField( "public static String reverseString(String s) {\n\n}");
                    else if( getIndex() == 30 )
                        q.setAnswerField( "public static boolean isConsecutive(int[] givenArray) {\n\n}");
                    else if( getIndex() == 31 )
                        q.setAnswerField( "public static String deleteSubstring(String s) {\n\n}");
                    else if( getIndex() == 32 )
                        q.setAnswerField( "public static String remover(String given) {\n\n}");
                }
                else
                    cardLayout.show( cardpanel, "2");
            }
            else if ( pressedButton == op.getButton("back") )
            {
                cardLayout.show( cardpanel, "1");
            }
            else if (  pressedButton == cr.getButton("back"))
            {
                cardLayout.show( cardpanel, "1");
            }
            else if ( pressedButton == m.getButton("options"))
            {
                cardLayout.show( cardpanel, "4");
            }
            else if ( pressedButton == m.getButton("credits"))
            {
                cardLayout.show( cardpanel, "5");
            }
            else if (  pressedButton == m.getButton("exit") )
            {
                f.dispose();
            }
            else if ( pressedButton == cr.getButton("back") )
            {
                cardLayout.show( cardpanel, "1");
            }
            else if ( pressedButton == cp.getButton("main") )
            {
                storyPrint.setFinished();
                System.out.println( " back to main" );
                cardLayout.show( cardpanel, "1");
            }
            
            
            
            //extra
            if ( pressedButton == op.getRadioButton("box1") )
            {
                if( op.getRadioButton("box1").isSelected())
                {
                    changeFont( op, new Font("Apple Chancery", Font.ITALIC, 15));
                    changeFont( s, new Font("Apple Chancery", Font.ITALIC, 15));
                    changeFont( m, new Font("Apple Chancery", Font.ITALIC, 15));
                    changeFont( q, new Font("Apple Chancery", Font.ITALIC, 15));
                    changeFont( cr, new Font("Apple Chancery", Font.ITALIC, 15));
                }
                else
                {
                    changeFont( op, FONT);
                    changeFont( s, FONT);
                    changeFont( m, FONT);
                    changeFont( q, FONT);
                    changeFont( cr, FONT);
                }
            }
            if( pressedButton == op.getRadioButton("box2") )
            {
                if( op.getRadioButton("box2").isSelected())
                {
                    
                    setPanelColor( op,Color.YELLOW);
                    setPanelColor( m,Color.YELLOW);
                    setPanelColor( cr,Color.YELLOW);
                    setPanelColor( f,Color.YELLOW);
                    q.getPanel("p1").setBackground(Color.BLUE);
                    q.getPanel("p2").setBackground(Color.PINK);
                    q.getPanel("p3").setBackground(Color.WHITE);
                    q.getTextField("story").setBackground(Color.WHITE);
                    q.getTextField("question").setBackground(Color.WHITE);
                    q.getTextField("answer").setBackground(Color.WHITE);
                    s.getPanel("s1").setBackground(Color.BLUE);
                    s.getPanel("s2").setBackground(Color.PINK);
                    s.getPanel("s3").setBackground(Color.CYAN);
                    s.getTextField("t1").setBackground(Color.WHITE);
                    s.getTextField("t2").setBackground(Color.WHITE);
                    s.getTextField("t3").setBackground(Color.WHITE);
                    m.setButtonBackground( Color.WHITE);
                    q.setButtonBackground( Color.WHITE);
                    cr.setButtonBackground( Color.WHITE);
                    op.setButtonBackground( Color.WHITE);
                    s.setButtonBackground( Color.WHITE);
                }
                else
                {
                    setPanelColor( f, Color.RED);
                    setPanelColor( op,Color.RED);
                    setPanelColor( m, Color.RED);
                    setPanelColor( cr, Color.RED);
                    q.getPanel("p1").setBackground(Color.BLUE);
                    q.getPanel("p2").setBackground(Color.PINK);
                    q.getPanel("p3").setBackground(Color.WHITE);
                    q.getTextField("story").setBackground(Color.WHITE);
                    q.getTextField("question").setBackground(Color.WHITE);
                    q.getTextField("answer").setBackground(Color.WHITE);
                    s.getPanel("s1").setBackground(Color.BLUE);
                    s.getPanel("s2").setBackground(Color.PINK);
                    s.getPanel("s3").setBackground(Color.CYAN);
                    s.getTextField("t1").setBackground(Color.WHITE);
                    s.getTextField("t2").setBackground(Color.WHITE);
                    s.getTextField("t3").setBackground(Color.WHITE);
                    m.setButtonBackground( Color.WHITE);
                    q.setButtonBackground( Color.WHITE);
                    cr.setButtonBackground( Color.WHITE);
                    op.setButtonBackground( Color.WHITE);
                    s.setButtonBackground( Color.WHITE);
                }
            }
            
            if( pressedButton == op.getRadioButton("box3") )
            {
                if( op.getRadioButton("box3").isSelected())
                {
                    
                }
                else
                {
                    
                }
            }  
        }
    }
    
    // main method
    public static void main( String[] args)
    {    
        new frame();
    } 
}

