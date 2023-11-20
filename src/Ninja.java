import java.util.function.IntPredicate;

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
    private int[][] Positions;
    private int State = 0;
    
    public Ninja(int containerWidth, int containerHeight)
    {
        super(Size, Size, 0, 0, containerWidth, containerHeight);
        
        var offset = Size / 2;
        Positions = new int[][]
        {
            { offset, offset },
            { offset, containerHeight - Size },
            { containerWidth - Size, containerHeight - Size },
            { containerWidth - Size, offset },
        };
        
        setPicture(AliveNinja);
        
        setX(Positions[0][0]);
        setY(Positions[0][1]);
        
        new Thread(this).start();
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true) {
                if (HasReachedTarget(Positions[State][0], Positions[State][1]))
                {
                    State++;
                    State = State % Positions.length;
                    
                    SetTarget(Positions[State][0], Positions[State][1]);
                }
                    
                ChaseTarget();
                Thread.sleep(SleepTime);
            }
        }
        catch(Exception exception)
        {
            
        }
    }
}
