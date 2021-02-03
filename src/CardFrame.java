import javax.swing.*;
import java.io.File;

/**
 * CardFrame is the JFrame that contains the main CardTable. When the reset method is
 * called, a new CardTable is created, and added to the JFrame
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class CardFrame extends JFrame
{
    // This is the cardTable that is added to the JFrame
    private CardTable t1;

    public CardFrame()
    {
        // sets the title of the JFrame to 21
        super("21");
        // The program will terminate when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // creates a new Card Table with this CardFrame as a parameter, so that it
        // can call the reset method later
        t1 = new CardTable();
        // the Card table is added to the JFrame, it is packed, and it is set visible
        setUndecorated(true);
        getContentPane().add(t1);
        ImageIcon img = new ImageIcon(new File("cards.jpeg").toString());
        setIconImage(img.getImage());
        pack();
        setVisible(true);
        // These JOptionPanes display a message explaining how the game works
        // It is placed here so that it doesn't pop up every time the panel is reset
    }

    public void reset()
    {
        // the CardTable as we know it is removed from the JFrame
        getContentPane().remove(t1);
        // A new CardTable is created and added to the JFrame, and is packed
        t1 = new CardTable();
        getContentPane().add(t1);
        pack();
    }
}
