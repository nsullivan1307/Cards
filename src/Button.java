import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
/**
 * Write a description of class Button here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Button implements MouseListener
{
    // instance variables - replace the example below with your own
    protected JPanel panel;
    protected int x, y, w, h;

    /**
     * Constructor for objects of class Button
     */
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
