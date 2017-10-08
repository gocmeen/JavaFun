package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen, Beyza Tugce Bilgic, Berat Bicer, Baran Ataman
 * 
 * CongratsPage which displayed after a story finished.
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class CongratsPage extends JPanel
{
    
    //properties
    JPanel mp;
    JPanel tx;
    JButton mb;
    JTextArea ta;
    JLabel l;
    ImageIcon im;
    
    public CongratsPage()
    {
        this.setPreferredSize( new Dimension(600, 600));
        this.setBackground(Color.RED);    
        this.setLayout( new BorderLayout());
        
        //Init CongratsPage
        mb = new JButton("<---Main menu");  
        mb.setPreferredSize( new Dimension(200, 40));
        mb.setBackground(Color.WHITE);
        
        mp = new JPanel();
        mp.setPreferredSize( new Dimension(600, 40));
        mp.setBackground(Color.RED);
        mp.setLayout( new BorderLayout());
        mp.add( mb, BorderLayout.WEST);
        
        ta = new JTextArea();
        ta.setPreferredSize( new Dimension(300, 300));
        ta.setText("\n\n\n\n\n\n\n\n\n\n\n   You completed the story. Well done!\n\n    Remember... Practice makes it better...");
        ta.setEditable(false);
        ta.setBackground(Color.YELLOW);
        Font font = ta.getFont();
        float size = font.getSize() + 5.0f;
        ta.setFont( font.deriveFont(size) );
        
        
        im = new ImageIcon( getClass().getResource("com.jpg"));
        Image img = im.getImage();
        Image newimg = img.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        im = new ImageIcon(newimg); 
        l = new JLabel();
        l.setIcon(im);
        
        
        tx = new JPanel();
        tx.setLayout( new BoxLayout( tx,BoxLayout.X_AXIS));
        tx.setPreferredSize( new Dimension(500, 400));
        tx.setBackground(Color.CYAN);
        tx.add(l);
        tx.add(ta);
        
        this.add(tx, BorderLayout.CENTER);
        this.add(mp, BorderLayout.SOUTH); 
        
    }
    
    //button getter
    public JButton getButton( String name)
    {
        if ( name.equals("main") )
        {
            return mb; 
        }
        return null;
    }
    
    //background setter
    public void setButtonBackground( Color color)
    {
        mb.setBackground(color);
    }
    
    public static void main( String[] args)
    {
        JFrame f = new JFrame();
        f.setTitle("Java Fun");
        f.setPreferredSize( new Dimension(650, 650));
        f.setBackground(Color.RED);
        f.setLayout(new FlowLayout());
        f.add( new CongratsPage());
        f.pack();
        f.setVisible(true);
    }
    
}