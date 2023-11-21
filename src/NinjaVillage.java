
public class NinjaVillage extends Imagem
{
	private static final String ImagePath = "village.png";
	
	public NinjaVillage(int width, int height)
	{
		super(width, height, 0, 0);
		this.setX(0);
		this.setY(0);
		this.setPicture(ImagePath);
	}
}
