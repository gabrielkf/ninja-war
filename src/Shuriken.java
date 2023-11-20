
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
				ChaseTarget();
				Thread.sleep(SleepTime);
			}
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
}