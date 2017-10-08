package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/*
 * date: 3 May 2016
 * authors: Mehmet Oguz Gocmen, Beyza Tugce Bilgic, Berat Bicer, Baran Ataman
 * 
 * frame class for taking all GUIs in a CardLayout with all ActionListeners
 * 
 * NOTE: The version uploaded before had bugs, this is the debugged version with comments included
 */

public class OptionsMenuGUIex extends JPanel
{
    private JPanel checkBoxPanel,panel1,panel2,buttonPanel,headerPanel;
    private JRadioButton box1,box2,box3;
    private JLabel headerLabel;
    private JButton backButton;
    
    public OptionsMenuGUIex()
    {
        this.setPreferredSize( new Dimension( 300,300 ) );
        this.setLayout( new BorderLayout());
        this.setBackground( Color.RED );
        
        //header panel for header
        headerPanel = new JPanel();
        headerPanel.setBackground( Color.RED);
        headerLabel = new JLabel("Options");
        headerPanel.add( headerLabel, BorderLayout.CENTER);
        headerPanel.setPreferredSize( new Dimension(100,100));
        
        //empty panels east and west
        panel1 = new JPanel();
        panel1.setPreferredSize( new Dimension(100,100));
        panel1.setBackground( Color.RED);
        panel2 = new JPanel();
        panel2.setPreferredSize( new Dimension(100,100));
        panel2.setBackground( Color.RED);
        
        // buttonPanel for back button
        buttonPanel = new JPanel();
        //buttonPanel.setLayout( new BorderLayout());
        buttonPanel.setPreferredSize( new Dimension(100,100));
        buttonPanel.setBackground( Color.RED);
        backButton = new JButton( "<--- BACK");
        backButton.setOpaque(true);
        buttonPanel.add( backButton, BorderLayout.WEST);
        
        // checkBoxPanel for center
        checkBoxPanel = new JPanel();
        checkBoxPanel.setPreferredSize( new Dimension( 100,100 ) );
        checkBoxPanel.setBackground( Color.RED);    
        checkBoxPanel.setLayout( new BoxLayout( checkBoxPanel,BoxLayout.Y_AXIS));
        checkBoxPanel.setAlignmentY( JComponent.CENTER_ALIGNMENT);
        checkBoxPanel.add(Box.createVerticalGlue());
        checkBoxPanel.setLayout( new FlowLayout()); 
        box1 = new JRadioButton( "FONT ");
        box1.setOpaque(false);
        box1.setHorizontalTextPosition( SwingConstants.LEFT);
        box2 = new JRadioButton( "BACKGROUND ");
        box2.setOpaque(false);
        box2.setHorizontalTextPosition( SwingConstants.LEFT);
        box3 = new JRadioButton( "Option 3 ");
        box3.setOpaque(false);
        box3.setHorizontalTextPosition( SwingConstants.LEFT);
        checkBoxPanel.add( box1);
        checkBoxPanel.add( box2);
        checkBoxPanel.add( box3);
        
        
        
        // add to main panel
        this.add( headerPanel, BorderLayout.NORTH);
        this.add( panel1, BorderLayout.WEST);
        this.add( panel2, BorderLayout.EAST);
        this.add( buttonPanel, BorderLayout.SOUTH);
        this.add(checkBoxPanel, BorderLayout.CENTER);          
        
    }
    
    public JButton getButton( String name)
    {
        if ( name.equals("back") )
        {
            return backButton; 
        }
        return null;
    }
    
    //radiobutton getter
    public JRadioButton getRadioButton( String name)
    {
        if ( name.equals("box1"))
        {
            return box1; 
        }
        if ( name.equals("box2"))
        {
            return box2; 
        }
        if ( name.equals("box3"))
        {
            return box3; 
        }
        return null;
    }
    // background setter
    public void setButtonBackground( Color color)
    {
        box3.setBackground(color);
        box2.setBackground(color);
        box1.setBackground(color);
        backButton.setBackground(color);
    }
    
    //test
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new OptionsMenuGUIex() );
        frame.pack();
        frame.setVisible( true );
    }     
}
