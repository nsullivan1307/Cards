import javax.swing.JPanel;
import java.awt.*;
/**
 * This draws the card to the JPanel, and is a dragBox, meaning it can be dragged
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class JCard extends DragBox
{
    // This is the card that is drawn
    private Card c1;
    private CardTable cardPanel;
    public JCard(Card card1, int xPos, int yPos, JPanel panel)
    {
        // Sets the position of the drag box
        setPosition(xPos, yPos);
        // sets the size of the drag box, multiplied by a scale
        setSize(new Dimension(37*CardTable.SCALE, 274*CardTable.SCALE/5));
        // uses the addTo method in DragBox to get the panel that uses it.
        // It is used for determining the mouse location for the drag box
        addTo(panel);
        // sets the value of the card
        c1 = card1;
        cardPanel = (CardTable) panel;
    }
    public void draw(Graphics page)
    {
        // This is the background of the card, a white rectagle
        page.setColor(Color.white);
        page.fillRect(x, y, w, h);
        // if the suit is hearts or diamonds, set the color to red, otherwise black
        if (c1.SUIT == Suit.hearts || c1.SUIT == Suit.diamonds)
        {
            page.setColor(Color.red);
        }
        else
        {
            page.setColor(Color.black);
        }
        // the draw string, with the unicode character of the card with the
        // position being scaled
        page.drawString(c1.toString(), x-6*CardTable.SCALE/5, y+48*CardTable.SCALE);
    }
}
