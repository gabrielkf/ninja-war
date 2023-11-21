import java.awt.*;

public abstract class ImagemMovida extends Imagem
{
	private static final int StopMargin = 3;
	private final int ContainerWidth;
	private final int ContainerHeight;

	protected double Velocity = 5;
	protected Rectangle Area;
	private int TargetX;
	private int TargetY;

	public ImagemMovida(int width,
						int height,
						int startX,
						int startY,
						int containerWidth,
						int containerHeight)
	{
		super(width, height, startX, startY);
		
		Area = new Rectangle(startX, startY, width, height);
		ContainerWidth = containerWidth;
		ContainerHeight = containerHeight;
		
		SetTarget(startX, startY);

		setX(startX);
		setY(startY);
	}

	protected abstract void Move() throws PosicaoInvalidaException, InterruptedException;
	
	protected boolean HasReachedTarget(int xDiff, int yDiff)
	{
		return Math.abs(xDiff) < StopMargin && Math.abs(yDiff) < StopMargin;
	}

	public void SetTarget(int x, int y)
	{
		TargetX = x;
		TargetY = y;
	}
	
	public int getTargetX() { return TargetX; }
	public int getTargetY() { return TargetY; }

	public void moverDireita(int shift) throws PosicaoInvalidaException {
		var x = getX() + shift;
		Area.setLocation(getX(), getY());

		if (OutOfHorizontal(x)) {
			throw new PosicaoInvalidaException();
		}

		this.setX(x);
	}

	public void moverBaixo(int shift) throws PosicaoInvalidaException {
		var y = getY() + shift;
		Area.setLocation(getX(), getY());

		if (OutOfVertical(y)) {
			throw new PosicaoInvalidaException();
		}

		this.setY(y);
	}

	private boolean OutOfHorizontal(int x) {
		return x < -getWidth() / 2 &&
				x < ContainerWidth - getWidth() / 2;
	}

	private boolean OutOfVertical(int y) {
		return y < -getHeight() / 2 &&
				y < ContainerHeight - getHeight() / 2;
	}
}

