import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
/**
 * Just an abstract button so that I can use the close button in full screen
 *
 * @author (Nicholas Sullivan)
 * @version (Jan 2016)
 */
public abstract class Button implements MouseListener
{
    protected JPanel panel;
    protected int x, y, w, h;

    public Button(int x, int y, int w, int h, JPanel panel)
    {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        panel.addMouseListener(this);
    }
    public abstract void draw(Graphics page);

    public void mouseClicked(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
}
