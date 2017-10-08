package GUI;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen, Beyza Tugce Bilgic, Berat Bicer, Baran Ataman
 * 
 * frame class for taking all GUIs in a CardLayout with all ActionListeners
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */ 

public class StorySelection extends JPanel 
{
    
    //properties
    JPanel s1;
    JPanel s2;
    JPanel s3;
    JPanel s4;
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JButton m;
    JButton n;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    
    
    //constructor
    public StorySelection()
    {   
        s1 = new JPanel();
        s2 = new JPanel();
        s3 = new JPanel();
        s4 = new JPanel();
        
        s1.setLayout( new BoxLayout( s1,BoxLayout.Y_AXIS));
        s2.setLayout( new BoxLayout( s2,BoxLayout.Y_AXIS));
        s3.setLayout( new BoxLayout( s3,BoxLayout.Y_AXIS));
        s4.setLayout( new BoxLayout( s4,BoxLayout.X_AXIS));
        
        s4.setLayout( new BorderLayout());
        
        b1 = new JRadioButton("Story 1");
        b1.setOpaque(false);
        b2 = new JRadioButton("Story 2");
        b2.setOpaque(false);
        b3 = new JRadioButton("Story 3");
        b3.setOpaque(false);
        b1.addActionListener( new RadioListener());
        b2.addActionListener( new RadioListener());
        b3.addActionListener( new RadioListener());
        
        m = new JButton("<---Main menu");
        m.setOpaque(true);
        n = new JButton("Next--->");
        n.setOpaque(true);
        n.setEnabled(false);
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        
        t1.setText("Lord of the Rings");
        t2.setText("Doctor Who Season 9");
        t3.setText("Sherlock");
        
        s1.setPreferredSize( new Dimension(600, 190));
        s2.setPreferredSize( new Dimension(600, 190));
        s3.setPreferredSize( new Dimension(600, 190));
        s4.setPreferredSize( new Dimension(600, 30));
        
        s1.add(b1);
        s2.add(b2);
        s3.add(b3);
        s1.add(t1);
        s2.add(t2);
        s3.add(t3);
        s4.add(m, BorderLayout.WEST);
        s4.add(n, BorderLayout.EAST);
        
        s1.setBackground( Color.YELLOW);
        s2.setBackground( Color.PINK);
        s3.setBackground( Color.CYAN);
        s4.setBackground( Color.RED);
        
        this.setPreferredSize( new Dimension(600, 650));
        this.setBackground( Color.RED);
        this.setLayout( new FlowLayout());
        this.add( s1);
        this.add( s2);
        this.add( s3);
        this.add( s4);
    }
    
    // panel getter
    public JPanel getPanel( String name )
    {
        if ( name.equals("s1") )
        {
            return s1; 
        }
        else if ( name.equals("s2") )
        {
            return s2;
        }
        else if ( name.equals("s3") )
        {
            return s3;
        }
        return null;
    }
    //textfield getter
    public JTextField getTextField( String name)
    {
        if ( name.equals("t1") )
        {
            return t1; 
        }
        else if ( name.equals("t2") )
        {
            return t2;
        }
        else if ( name.equals("t3") )
        {
            return t3;
        }
        return null;
    }
    
    //button getter
    public JButton getButton( String name)
    {
        if ( name.equals("main") )
        {
            return m; 
        }
        else if ( name.equals("next") )
        {
            return n;
        }   
        return null;
    }
    
    //radiobutton getter
    public JRadioButton getRadio( String name)
    {
        if ( name.equals("story1") )
        {
            return b1; 
        }
        else if ( name.equals("story2") )
        {
            return b2; 
        }
        else if ( name.equals("story3") )
        {
            return b3; 
        }
        return null;
    }
    
    // bakground setter
    public void setButtonBackground( Color color)
    {
        m.setBackground(color);
        n.setBackground(color);
    }
    
    //Radio listeners
    public class RadioListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            JRadioButton button = (JRadioButton) e.getSource();
            
            if ( button == b1 )
            {
                n.setEnabled(true);
                b1.setSelected(true);
                b2.setSelected(false);
                b3.setSelected(false); 
            }
            else if ( button == b2 )
            {
                n.setEnabled(true);
                b1.setSelected(false);
                b2.setSelected(true);
                b3.setSelected(false);
            }
            else if ( button == b3 )
            {
                n.setEnabled(true);
                b1.setSelected(false);
                b2.setSelected(false);
                b3.setSelected(true); 
            }   
        }
    }
}