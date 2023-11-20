import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Screen extends JFrame implements MouseMotionListener
{
    private static final String Title = "NinjaWar";
    private static final int Width = 1300;
    private static final int Height = 700;

    private Shuriken Weapon;
    private Scenario NinjaVillage;
    private Ninja Character;
    
    public Screen()
    {
        Weapon = new Shuriken(Width, Height);
        NinjaVillage = new Scenario();
        Character = new Ninja(Width, Height);
        
        addMouseMotionListener(this);
        setTitle(Title);
        setSize(Width, Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(this);
        
        createBufferStrategy(1);
        setVisible(true);
        createBufferStrategy(2);
    }

    public void paint(Graphics g) {
        this.renderGraphics();
        repaint();
    }

    public void renderGraphics() {
        if (!getBufferStrategy().contentsLost())
        {
            getBufferStrategy().show();
        }

        var graphicsContext = getBufferStrategy().getDrawGraphics();
        var graphics = graphicsContext.create();
        
        renderizarImagens(graphics);
        
        graphicsContext.dispose();
        graphics.dispose();
    }

    public void renderizarImagens(Graphics graphics) {
        NinjaVillage.DrawWithSize(
                graphics,
                Width,
                Height);
        Character.DrawWithSize(
                graphics,
                Ninja.Size,
                Ninja.Size);
        Weapon.DrawWithSize(
                graphics,
                Shuriken.Size,
                Shuriken.Size);
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        Weapon.SetTarget(e.getX(), e.getY());
    }
    @Override
    public void mouseMoved(MouseEvent e)
    {
        Weapon.SetTarget(e.getX(), e.getY());
    }
}
