import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This draws the card to the JPanel, and is a dragBox, meaning it can be dragged
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public class JCard extends DragBox
{
    // This is the card that is drawn
    private final Card c1;
    private final CardTable table;
    private final String cardBack = new StringBuilder().appendCodePoint(0x1f0a0).toString();
    private boolean movable;

    public JCard(Card card1, int xPos, int yPos, CardTable panel)
    {
        // Sets the position of the drag box
        setPosition(xPos, yPos);
        // sets the size of the drag box, multiplied by a scale
        setSize(new Dimension(36*CardTable.SCALE, 274*CardTable.SCALE/5));
        // uses the addTo method in DragBox to get the panel that uses it.
        // It is used for determining the mouse location for the drag box
        addTo(panel);

        table = panel;
        // sets the value of the card
        c1 = card1;
        // Card settings
        movable = true;
    }

    @Override
    public void onMouseClicked(MouseEvent event) {
        super.onMouseClicked(event);
        c1.flip();
        table.repaint();
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public void draw(Graphics page)
    {
        // This is the background of the card, a white rectangle
        page.setColor(Color.white);
        page.fillRect(x, y, w, h);
        // the draw string, with the unicode character of the card back with the
        // position being scaled
        page.setColor(c1.getColor());
        page.drawString(c1.toString(), x - 8 * CardTable.SCALE / 5, y + 48 * CardTable.SCALE);
    }
}
