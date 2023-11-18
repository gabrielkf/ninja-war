import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Screen extends JFrame implements MouseMotionListener
{
    private static final String Title = "NinjaWar";
    private static final int Width = 1300;
    private static final int Height = 700;
    
    public Screen()
    {
        setVisible(true);
        setTitle(Title);
        setSize(Width, Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}
