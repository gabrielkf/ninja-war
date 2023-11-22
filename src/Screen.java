import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Screen extends JFrame implements MouseMotionListener
{
    private Imagem Background;
    private ImagemMovida Weapon;
    private ImagemMovida Target;
    
    public Screen(Imagem background, ImagemMovida weapon, ImagemMovida target, String title)
    {
        Background = background;
        Weapon = weapon;
        Target = target;
        
        Weapon.setCollider(target);
        Target.setCollider(weapon);
        
        addMouseMotionListener(this);
        setTitle(title);
        setSize(background.getWidth(), background.getHeight());
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
        Background.DrawWithSize(graphics);
        Target.DrawWithSize(graphics);
        Weapon.DrawWithSize(graphics);
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
