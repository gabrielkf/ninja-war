public class Ninja
        extends ImagemMovida
        implements Runnable
{
    private static final String AliveNinja = "ninja.png";
    private static final String DeadNinja = "dead-ninja.png";
    public static final int Size = 150;
    private static final int SleepTime = 5;
    private static final int StopTime = 500;
    private static final int Offset = 50;
    private final int[][] Positions;
    
    private boolean Alive = true;
    private boolean CounterClockwise = true;
    private int State;
    
    public Ninja(int containerWidth, int containerHeight)
    {
        super(Size, Size, Offset, Offset, containerWidth, containerHeight);
        
        Positions = new int[][]
        {
            { Offset, Offset },
            { Offset, containerHeight - Size - Offset },
            { containerWidth - Size - Offset, containerHeight - Size - Offset },
            { containerWidth - Size - Offset, Offset },
        };
        
        setPicture(AliveNinja);
        State = 0;
        
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
//                var myBox = "Ninja: (" + getArea().getX() + "," + getArea().getY() + "), " + getWidth() + ", " + getHeight(); 
//                System.out.println(myBox);
                Thread.sleep(StopTime);
            }
        }
        catch (CollisionException collisionException)
        {
            setPicture(DeadNinja);
            System.out.println(collisionException.getMessage());
        }
        catch(Exception exception)
        {
            System.out.println("Ninja: " + exception.getMessage());
        }
    }

    @Override
    protected void Move() throws PosicaoInvalidaException, CollisionException, InterruptedException
    {
        if (!Alive) return;
        
        var nextState = (State + 1) % Positions.length;
        SetTarget(Positions[nextState][0], Positions[nextState][1]);

        var xDiff = getTargetX() - getX();
        var yDiff = getTargetY() - getY();

        while (!HasReachedTarget(xDiff, yDiff))
        {
            if (CollidedWithWeapon())
            {
                throw new CollisionException();
            }
            
            var hypotenuse = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

            var xStep = (double)xDiff * Velocity / hypotenuse;
            var yStep = (double)yDiff * Velocity / hypotenuse;

            moverDireita((int)Math.round(xStep));
            moverBaixo((int)Math.round(yStep));

            xDiff = getTargetX() - getX();
            yDiff = getTargetY() - getY();

            Thread.sleep(SleepTime);
        }

        State = nextState;
    }
    
    private boolean CollidedWithWeapon()
    {
        if (getCollider() == null) return false;
        
        var xDiffCenters = getArea().getCenterX() - getCollider().getArea().getCenterX();
        var yDiffCenters = getArea().getCenterY() - getCollider().getArea().getCenterY();
        var distance = Math.sqrt(xDiffCenters * xDiffCenters + yDiffCenters * yDiffCenters);
        
        return distance < (double) getWidth() / 2;
    }
}
