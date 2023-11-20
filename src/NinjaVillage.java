
public class NinjaVillage extends Imagem
{
	private static final String ImagePath = "village.png";
	
	public NinjaVillage(int width, int height, int startX, int startY)
	{
		super(width, height, startX, startY);
		this.setX(0);
		this.setY(0);
		this.setPicture(ImagePath);
	}
}
