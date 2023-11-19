public class ImagemMovida extends Image {
	private final int MaxX;
	private final int MaxY;
	
	public ImagemMovida(int maxX, int maxY)
	{
		MaxX = maxX;
		MaxY = maxY;
	}
	
	public void moverDireita(int shift) throws PosicaoInvalidaException
	{
		var x = this.getX() + shift;
		
		if (x > MaxX || x < 0)
		{
			throw new PosicaoInvalidaException();
		}
		
		this.setX(x);
	}
	
	public void moverBaixo(int shift) throws PosicaoInvalidaException
	{
		var y = getY() + shift;
		
		if (y > MaxY || y < 0)
		{
			throw new PosicaoInvalidaException();
		}
		
		this.setY(y);
	}
}
