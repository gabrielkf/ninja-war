
public class Shuriken 
		extends ImagemMovida
		implements Runnable
{
	private static final String ImagePath = "shuriken.png";
	public static final int Size = 50;
	private static final double Velocity = 5;
	private static final int SleepTime = 20;
	private static final int StopMargin = 3;
	private int TargetX;
	private int TargetY;

	public Shuriken(int containerWidth, int containerHeight)
	{
		super(containerWidth - Size, containerHeight - Size);
		this.setPicture(ImagePath);
		
		var startX = containerWidth / 2;
		var startY = containerHeight / 2;
		setX(startX);
		setY(startY);
		SetTarget(startX, startY);

		new Thread(this).start();
	}
	
	public void SetTarget(int x, int y)
	{
		TargetX = x;
		TargetY = y;
	}
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				ChaseTarget();
				Thread.sleep(SleepTime);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	private void ChaseTarget()
	{
		var xDiff = TargetX - getX() - Size/2;
		var yDiff = TargetY - getY() - Size/2;
		
		if (Math.abs(xDiff) < StopMargin && Math.abs(yDiff) < StopMargin) return;
		
		var hypotenuse = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		
		var xStep = (double)xDiff * Velocity / hypotenuse;
		var yStep = (double)yDiff * Velocity / hypotenuse;
		
		try
		{
			moverDireita((int)xStep);
			moverBaixo((int)yStep);			
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
}