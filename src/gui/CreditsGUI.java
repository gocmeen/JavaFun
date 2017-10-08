package GUI;
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

public class CreditsGUI extends JPanel
{
    private JPanel panel, buttonPanel, labelPanel;
    private JButton back;
    private JLabel label;
    private JTextArea textArea;
    
    public CreditsGUI()
    {
        this.setPreferredSize( new Dimension( 600,600 ) );
        this.setLayout( new FlowLayout() );
        this.setBackground( Color.RED );
        
        //Init credits
        textArea = new JTextArea();
        textArea.setPreferredSize( new Dimension(400, 400));
        textArea.setText("Bilkent University,Ankara,Turkey\n\nCS102-2" 
                             + "\nSpring 2016\nGroup2D:" + "\n-->Berat Bicer" + "\n-->Beyza Tugce Bilgic"+
                         "\n-->Baran Ataman" + "\n-->Oguz Gocmen" + "\n-->Gokberk Aktulay" );
        textArea.setEditable(false);
        textArea.setBackground(Color.RED);
        Font font = textArea.getFont();
        float size = font.getSize() + 5.0f;
        textArea.setFont( font.deriveFont(size) );
        back = new JButton( "<--- Back" );
        
        panel = new JPanel();
        panel.setPreferredSize( new Dimension(400, 500));
        panel.setBackground( Color.RED );
        panel.add(textArea);
        
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize( new Dimension( 600,30 ) );
        buttonPanel.setBackground( Color.RED );
        buttonPanel.setLayout( new BorderLayout());
        buttonPanel.add ( back, BorderLayout.WEST);
        
        label = new JLabel("Credits");
        font = label.getFont();
        size = font.getSize() + 5.0f;
        label.setFont( font.deriveFont(size) );
        labelPanel = new JPanel();
        labelPanel.setPreferredSize( new Dimension(600, 50));
        labelPanel.setBackground( Color.RED );
        labelPanel.add(label);
        
        this.add( labelPanel );
        this.add( panel);
        this.add( buttonPanel);          
        
    }
    
    //button getter
    public JButton getButton( String name)
    {
        if ( name.equals("back") )
        {
            return back; 
        }
        return null;
    }
    
    //bakground setter
    public void setButtonBackground( Color color)
    {
        back.setBackground(color);
    }
    
    //test
    public static void main( String[] args )
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( new CreditsGUI() );
        frame.pack();
        frame.setVisible( true );
    }
}
