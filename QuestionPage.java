package GUI;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.DefaultCaret;
import java.io.*;
import com.sun.tools.javac.*;
import java.io.*;
import checkers.*;
import java.net.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen, Beyza Tugce Bilgic, Berat Bicer, Baran Ataman
 * 
 * frame class for taking all GUIs in a CardLayout with all ActionListeners
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class QuestionPage extends JPanel
{
    //properties
    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2;
    JTextArea story,question,answer;
    ImageIcon im1, im2;
    JScrollPane scroll1,scroll2,scroll3;
    JButton b, n, check;
    StorySelection s;
    
    //constructor
    public QuestionPage()
    {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        story = new JTextArea();
        question = new JTextArea();
        answer = new JTextArea();
        b = new JButton("<--- Back");
        //b.setOpaque(true);
        n = new JButton("Next--->");
        //n.setOpaque(true);
        check = new JButton("Check Answer...");
        //n.setOpaque(true);
        n.setEnabled(false);
        
        
        story.setText("STORY CONNECTION HERE.......");
        question.setText("QUESTION HERE........");
        story.setEditable(false);
        question.setEditable(false);
        
        //scroll panes
        scroll1 = new JScrollPane (story);
        scroll2 = new JScrollPane (question);
        scroll3 = new JScrollPane (answer);
        
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        story.setBounds(5, 35, 385, 330);
        story.setLineWrap(true);
        story.setWrapStyleWord(true);
        
        question.setBounds(5, 35, 385, 330);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        
        answer.setBounds(5, 35, 385, 330);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        
        scroll1.setBounds(20, 30, 100, 40);
        scroll2.setBounds(20, 30, 100, 40);
        scroll3.setBounds(20, 30, 100, 40);
        
        //adding images to stroy panel and question panel
        im1 = new ImageIcon( getClass().getResource("cop-adam.jpg"));
        Image img = im1.getImage();
        Image newimg = img.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
        im1 = new ImageIcon(newimg);  
        l1 = new JLabel();
        l1.setIcon(im1);
        im2 = new ImageIcon( getClass().getResource("image.jpg"));
        Image img2 = im2.getImage();
        Image newimg2 = img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
        im2 = new ImageIcon(newimg2); 
        l2 = new JLabel();
        l2.setIcon(im2);
        
        //Adding elements to panels
        p1.setLayout( new BoxLayout( p1,BoxLayout.X_AXIS));
        p2.setLayout( new BoxLayout( p2,BoxLayout.X_AXIS));
        p3.setLayout( new BoxLayout( p3,BoxLayout.X_AXIS));
        p4.setLayout( new BorderLayout());
        p5.setLayout( new BoxLayout( p5, BoxLayout.X_AXIS));
        p5.setLayout( new BorderLayout());
        
        p1.add(l1);
        p1.add(scroll1);
        
        p2.add(l2);
        p2.add(scroll2);
        
        p3.add(scroll3);
        p4.add(check, BorderLayout.CENTER);
        p5.add(b, BorderLayout.WEST);
        p5.add(n, BorderLayout.EAST);
        
        p1.setPreferredSize( new Dimension(600, 200));
        p2.setPreferredSize( new Dimension(600, 150));
        p3.setPreferredSize( new Dimension(600, 150));
        p4.setPreferredSize( new Dimension(600, 30));
        p5.setPreferredSize( new Dimension(600, 30));
        
        p1.setBackground( Color.BLUE);
        p2.setBackground( Color.PINK);
        p3.setBackground( Color.WHITE);
        p4.setBackground( Color.RED);
        p5.setBackground( Color.RED);
        
        this.setPreferredSize( new Dimension(600, 650));
        this.setBackground( Color.RED);
        this.setLayout( new FlowLayout());
        this.add( p1);
        this.add( p2);
        this.add( p3);
        this.add( p4);
        this.add( p5);
        
    }
    //panel getter
    public JPanel getPanel( String name )
    {
        if ( name.equals("p1") )
        {
            return p1; 
        }
        else if ( name.equals("p2") )
        {
            return p2;
        }
        else if ( name.equals("p3") )
        {
            return p3;
        }
        return null;
    }
    //textArea getter
    public JTextArea getTextField( String name)
    {
        if ( name.equals("story") )
        {
            return story; 
        }
        else if ( name.equals("question") )
        {
            return question;
        }
        else if ( name.equals("answer") )
        {
            return answer;
        }
        return null;
    }
    
    //textField setter for story and questions
    public void setTextField( String name, String nextPart)
    {
        if ( name.equals("story") )
        {
            story.setText( nextPart);
            scroll1.setViewportView( story) ;
        }
        else if ( name.equals("question") )
        {
            question.setText( nextPart);
            scroll2.setViewportView( question) ;
        }
    }
    
    //answerField setter for answers
    public void setAnswerField( String init)
    {
        answer.setText( init);
        scroll2.setViewportView( question) ;
    }
    
    // button getter
    public JButton getButton( String name)
    {
        if ( name.equals("next") )
        {
            return n; 
        }
        else if ( name.equals("back") )
        {
            return b;
        }
        else if ( name.equals("check"))
            return check;
        return null;
    }
    
    // background setter
    public void setButtonBackground( Color color)
    {
        n.setBackground(color);
        b.setBackground(color);
        check.setBackground(color);
    }
    
    // create Answer.java and compile
    public boolean compile() throws IOException
    {
        try
        {
            File file = new File("answer\\Answer.java");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            String os = "package answer;\npublic class Answer {\n\t";
            if (!file.exists()) {
                file.createNewFile();
            }
            
            bw.write(os + answer.getText() + "}");
            bw.close();
            
            String classpath = (new File("com\\sun\\tools\\javac\\Main")) + "";
            String sourcepath = (new File("")) + "";
            String savepath = (new File(".")) + "";
            String targetFile = file + "";
            String[] comp = new String[] {"-classpath", classpath, "-sourcepath", sourcepath, "-d", savepath, targetFile};
            com.sun.tools.javac.Main compiler = new com.sun.tools.javac.Main();
            int compilationResult = compiler.compile(comp);
            if (compilationResult == 0)
            {
                System.out.println("Compilation is successful");
                return true;
            }
            else
            {
                System.out.println("Compilation Failed");
                return false;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    // checker method for validity
    public boolean check(int i){
        try {
            if (i == 1)
                return Check1.check();
            else if (i == 2)
                return Check2.check();
            else if (i == 3)
                return Check3.check();
            else if (i == 4)
                return Check4.check();
            else if (i == 5)
                return Check5.check();
            else if (i == 6)
                return Check6.check();
            else if (i == 7)
                return Check7.check();
            else if (i == 8)
                return Check8.check();
            else if (i == 9)
                return Check9.check();
            else if (i == 10)
                return Check10.check();
            else if (i == 11)
                return Check11.check();
            else if (i == 12)
                return Check12.check();
            else if (i == 13)
                return Check13.check();
            else if (i == 14)
                return Check14.check();
            else if (i == 15)
                return Check15.check();
            else if (i == 16)
                return Check16.check();
            else if (i == 17)
                return Check17.check();
            else if (i == 18)
                return Check18.check();
            else if (i == 19)
                return Check19.check();
            else if (i == 20)
                return Check20.check();
            else if (i == 21)
                return Check21.check();
            else if (i == 22)
                return Check22.check();
            else if (i == 23)
                return Check23.check();
            else if (i == 24)
                return Check24.check();
            else if (i == 25)
                return Check25.check();
            else if (i == 26)
                return Check26.check();
            else if (i == 27)
                return Check27.check();
            else if (i == 28)
                return Check28.check();
            else if (i == 29)
                return Check29.check();
            else if (i == 30)
                return Check30.check();
            else if (i == 31)
                return Check31.check();
            else if (i == 32)
                return Check32.check();
        }
        catch (Exception grgse) {
            return false;
        }
        return false;
    }
    
    //test
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new QuestionPage() );
        frame.pack();
        frame.setVisible( true );
    } 
}