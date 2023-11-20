public class Ninja
        extends ImagemMovida
        implements Runnable
{
    private static final String AliveNinja = "ninja.png";
    private static final String DeadNinja = "dead-ninja.png";
    public static final int Size = 150;
    private static final int Velocity = 1;
    private static final int SleepTime = 20;
    private boolean IsAlive = true;
    private boolean Forward = true;
    
    public Ninja(int containerWidth, int containerHeight)
    {
        super(containerWidth, containerHeight);
        setPicture(AliveNinja);
        
        var startY = containerHeight - Size - 1;
        setX(10);
        setY(startY);
        
        new Thread(this).start();
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Move();
                Thread.sleep(SleepTime);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void Move()
    {
        try
        {
            moverDireita(Forward ? Velocity : -Velocity);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
