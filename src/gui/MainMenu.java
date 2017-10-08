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

public class MainMenu extends JPanel
{  
    //properties
    
    JButton start;
    JButton options;
    JButton credits;
    JButton exit;
    JPanel panel;
    ImageIcon ok;
    JPanel a, b, c, d;
    StorySelection s = new StorySelection();
    
    //constructor
    public MainMenu()
    {
        panel = new JPanel(); 
        a = new JPanel();
        b = new JPanel();
        c = new JPanel();
        d = new JPanel();
        
        options = new JButton("Options");
        options.setOpaque(true);
        credits = new JButton("Credits");
        credits.setOpaque(true);
        exit = new JButton("Exit");
        exit.setOpaque(true);
        
        
        //Start button
        ok = new ImageIcon( getClass().getResource("photo.jpg"));
        Image img = ok.getImage();
        Image newimg = img.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
        ok = new ImageIcon(newimg);    
        start = new JButton(ok);
        start.setOpaque(true);
        //start.addActionListener( new MyActionListener());
        
        panel.setPreferredSize( new Dimension(100, 100));
        a.setPreferredSize( new Dimension(600, 70));
        b.setPreferredSize( new Dimension(600, 70));
        c.setPreferredSize( new Dimension(200, 600));
        d.setPreferredSize( new Dimension(200, 600));
        a.setBackground(Color.RED);
        b.setBackground(Color.RED);
        c.setBackground(Color.RED);
        d.setBackground(Color.RED);
        a.setLayout( new BorderLayout());
        
        options.setPreferredSize( new Dimension(200, 50));
        credits.setPreferredSize( new Dimension(200, 50));
        exit.setPreferredSize( new Dimension(200, 50));
       
        //adding things  to panel
        panel.setBackground(Color.RED);     
        panel.setLayout( new BoxLayout( panel,BoxLayout.Y_AXIS));   
        panel.setAlignmentX( JComponent.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue());
        panel.setLayout( new FlowLayout()); 
        panel.add( start);
        panel.add( options);
        panel.add( credits);
        panel.add( exit);
        
        this.setPreferredSize( new Dimension(600, 600));
        this.setBackground(Color.RED);    
        this.setLayout( new BorderLayout());
        this.add( panel, BorderLayout.CENTER);
        this.add( a, BorderLayout.NORTH);
        this.add( b, BorderLayout.SOUTH);
        this.add( c, BorderLayout.EAST);
        this.add( d, BorderLayout.WEST);   
    }
    
    // button getter
    public JButton getButton( String name)
    {
        if ( name.equals("start") )
        {
            return start; 
        }
        else if ( name.equals("options") )
        {
            return options; 
        }
        else if ( name.equals("credits") )
        {
            return credits;
        }
        else if ( name.equals("exit") )
        {
            return exit;
        }
        return null;
    }
    
    //background setter
    public void setButtonBackground( Color color)
    {
        start.setBackground(color);
        options.setBackground(color);
        credits.setBackground(color);
        exit.setBackground(color);
    }
}
