import java.awt.*;

public class ImagemMovida extends Imagem
{
	private final int ContainerWidth;
	private final int ContainerHeight;
	private static final int StopMargin = 3;
	private static final double Velocity = 5;

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

		setX(startX);
		setY(startY);
	}

	protected void ChaseTarget() throws PosicaoInvalidaException
	{
		var xDiff = TargetX - getX() - getWidth()/2;
		var yDiff = TargetY - getY() - getHeight()/2;

		if (HasReachedTarget(xDiff, yDiff)) return;

		var hypotenuse = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

		var xStep = (double)xDiff * Velocity / hypotenuse;
		var yStep = (double)yDiff * Velocity / hypotenuse;

		moverDireita((int)xStep);
		moverBaixo((int)yStep);
	}
	
	protected boolean HasReachedTarget(int xDiff, int yDiff)
	{
		return Math.abs(xDiff) < StopMargin && Math.abs(yDiff) < StopMargin;
	}

	public void SetTarget(int x, int y)
	{
		TargetX = x;
		TargetY = y;
	}

	public void moverDireita(int shift) throws PosicaoInvalidaException {
		var x = this.getX() + shift;

		if (OutOfHorizontal(x)) {
			throw new PosicaoInvalidaException();
		}

		this.setX(x);
	}

	private boolean OutOfHorizontal(int x) {
		return x < (getWidth() / 2) &&
				x < ContainerWidth + (getWidth() / 2);
	}

	public void moverBaixo(int shift) throws PosicaoInvalidaException {
		var y = getY() + shift;

		if (OutOfVertical(y)) {
			throw new PosicaoInvalidaException();
		}

		this.setY(y);
	}

	private boolean OutOfVertical(int y) {
		return y < (getHeight() / 2) &&
				y < ContainerHeight + (getHeight() / 2);
	}
}

