
public class Shuriken 
		extends ImagemMovida
		implements Runnable
{
	private static final String ImagePath = "shuriken.png";
	private static final int Size = 50;
	private static final int SleepTime = 20;

	public Shuriken(int containerWidth, int containerHeight)
	{
		super(
			Size,
			Size,
			containerWidth / 2,
			containerHeight / 2,
			containerWidth,
			containerHeight);
		
		this.setPicture(ImagePath);
		
		SetTarget(getX(), getY());

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
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	@Override
	protected void Move() throws PosicaoInvalidaException
	{
		var xDiff = getTargetX() - getX() - getWidth()/2;
		var yDiff = getTargetY() - getY() - getHeight()/2;

		if (HasReachedTarget(xDiff, yDiff)) return;

		var hypotenuse = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

		var xStep = (double)xDiff * Velocity / hypotenuse;
		var yStep = (double)yDiff * Velocity / hypotenuse;

		moverDireita((int)xStep);
		moverBaixo((int)yStep);
	}
}