import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the table in which all the cards are placed. This is by far the largest class
 * here, since it controls just about everything.
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class CardTable extends JPanel
{
    // The Fonts that are used, f1 is for the text, f2 is for the playing cards
    private Font f1, f2;
    // This is JDeck that is displayed
    private JDeck jd1;
    // These are all the cards and JCards that will be on the JPanel. The oldCards and oldJCards
    // are used for copying the first two arrays for creating a new length of card array
    private Card[] cards, oldCards;
    private JCard[] jcards, oldjcards;
    // Numcards is the number of cards on the JPanel, and sum is the sum of the cards
    private int numCards, sum;
    // message is the the message displaying the number of points at the top of the screen
    private String message;
    // This is the Screen size of the computer. SCALE is created to be used by other classes
    // such as JCard1 and JDeck to draw the cards and decks at the appropriate size for the screen
    public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCALE = (int)SCREEN.getHeight()/320;
    // This is the CardFrame, used for reseting the CardTable.
    private CardFrame Frame1;
    private CloseButton c;
    public CardTable(CardFrame f)
    {
        // A new JDeck is created. This card table is passed to it in order for it to determine
        // the position of a mouse clicked. The position is scaled, and positioned
        // just below the message will be placed
        jd1 = new JDeck(25*SCALE, 25*SCALE, this);
        // The number of cards on the JPanel is initially 0
        numCards = 0;
        // new card and JCard arrays are created (with 0 positions)
        cards = new Card[numCards];
        jcards = new JCard[numCards];
        // The background is set to an rgb value, a dark green
        setBackground(new Color(25, 77, 30));
        // f1 is the font of the message
        f1 = new Font("Arial", Font.PLAIN, 10*SCALE);
        // f2 is the font of the playing cards, which needs to be a special font to display
        f2 = new Font("Segoe UI Symbol", Font.PLAIN, 60*SCALE);
        // The preferred screen size for the game of 21 is the whole screen
        setPreferredSize(SCREEN);
        // the sum of the cards is 0 at first
        sum = 0;
        // the frame is set to the parameter passed in
        Frame1 = f;
        c = new CloseButton(this);
    }
    // This adds a card to the JPanel
    public void addCard(Card ca1)
    {
        // The oldCards are set to the new cards to save the data
        oldCards = cards;
        oldjcards = jcards;
        // The card arrays gain one more index to fit the next card
        cards = new Card[numCards+1];
        jcards = new JCard[numCards+1];
        // For each member of the old array, set it equal to the corresonding index of the
        // new array, leaving one posiiton empty at the end
        for (int i = 0; i < numCards; i++)
        {
            // The card at each position is equal to the old card, and each jcard at each position
            // is equal to the old jcard
            cards[i] = oldCards[i];
            jcards[i] = oldjcards[i];
        }
        // The last card in the card array is equal to the card passed in as a parameter
        cards[numCards] = ca1;
        // The last jcard in the jcard array is equal to a new jcard with the value of the card
        // passed as a parameter
        jcards[numCards] = new JCard(ca1, (40+numCards*8)*SCALE, 25*SCALE, this);
        // The number of cards increases by 1;
        numCards++;
        // if the sum is equal to 21:
        // finally, repaints the JPanel again
        repaint();
    }
    // This is what paints the Jpanel
    public void paintComponent(Graphics page)
    {
        // Tells JPanel to paint its component
        super.paintComponent(page);
        // sets the graphics font to the card supportive font
        page.setFont(f2);
        // Draws the deck to the panel
        jd1.draw(page);
        // Draws each JCard
        for (int i = 0; i < numCards; i++)
        {
            jcards[i].draw(page);
        }
        c.draw(page);
        // Sets the graphics font to the font used for the message
        //page.setFont(f1);
        // Sets the color to black, because the colour might have changed, in drawing the cards
        //page.setColor(Color.black);
        // creates the point display
        //message = "Points: " + sum;
        // Draws the point display at the top of the screen with scaled positions
        //page.drawString(message, 40*SCALE, 20*SCALE);
    }
    private class CloseButton extends Button
    {
        public CloseButton(CardTable table)
        {
            super(SCREEN.width - (10 * SCALE), 0, 10*SCALE, 10*SCALE, table);
        }
        public void draw(Graphics page)
        {
            //page.setColor(new Color(255, 255, 255, 100));
            //page.fillRect(x, y, w, h);
            page.setColor(new Color(255, 255, 255));
            page.setFont(f1);
            page.drawString("X", x+2*SCALE, y+8*SCALE);
        }
        public void mouseClicked(MouseEvent e)
        {
            int xPos = e.getX();
            int yPos = e.getY();
            if (xPos > x && xPos < x + w && yPos > y && yPos < y + h)
            {
                System.exit(0);
            }


        }
        public void mousePressed(MouseEvent e)
        {
            int xPos = e.getX();
            int yPos = e.getY();
            if (xPos > x && xPos < x + w && yPos > y && yPos < y + h)
            {
                Graphics page = panel.getGraphics();
                page.setColor(new Color(255, 255, 255));
                page.fillRect(x, y, w, h);
                page.setColor(Color.red);
                page.setFont(f1);
                page.drawString("X", x+2*SCALE, y+8*SCALE);
            }


        }
    }
}
