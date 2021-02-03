import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is the visual representation of the deck. When clicked, a card appears below it.
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class JDeck
{
    // This is the x and y positions, the width and height of the deck
    private final int x;
    private final int y;
    private final int w;
    private final int h;
    // This will be the string with the character of the back of a card
    private final String cardPic;
    // Deck that the JDeck uses
    private final Deck d1;
    // The cardTable panel
    private final CardTable p;

    public JDeck(int xp, int yp, CardTable panel)
    {
        // xp and yp are the x and y positions of the deck
        x = xp;
        y = yp;
        // The width and height are set, according to a scaling size
        w = 37*CardTable.SCALE;
        h = 274*CardTable.SCALE/5;
        // d1 is created
        d1 = new Deck();
        // the string with the back of the card is created. For more details about
        // this method, see the Card class.
        cardPic = new StringBuilder().appendCodePoint(0x1f0a0).toString();
        // This is the panel that the JDeck is put into.
        // It is used so that the mouse clicked position can be detected, within
        // the JPanel
        p = panel;
        // This adds a MouseListener to the JPanel, which detects where and
        // how a mouse has clicked in the JPanel
        p.addMouseListener(new clickListener());
    }

    public void draw(Graphics page)
    {
        // This method draws the JDeck by drawing a white rectangle as a
        // background for the card
        page.setColor(Color.white);
        page.fillRect(x, y, w, h);
        // And then a black back of the card is drawn, with the position scaled
        page.setColor(Color.black);
        page.drawString(cardPic, x-6*CardTable.SCALE/5, y+48*CardTable.SCALE);
    }
    // This is the clickListener, added to the JPanel earlier
    private class clickListener implements MouseListener
    {
        // If the mouse has been clicked:
        public void mouseClicked(MouseEvent event)
        {
            // Get the point that the mouse has been clicked
            // The point of the mouse, used to determine whether the mouse is over the deck
            Point point1 = event.getPoint();
            int xp = point1.x;
            int yp = point1.y;
            // If the point has been clicked is within the bounds of the drawn deck:
            if (x < xp && xp < x + w && y < yp && yp < y + h)
            {
                // A card is removed from the deck, and added to the JPanel
                p.addCard(d1.removeRandomCard());
            }
        }
        // These are not needed:
        public void mousePressed(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }
}
