import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagem
{
    private BufferedImage Picture;
    private int X;
    private int Y;
    private final int Width;
    private final int Height;
    
    public Imagem(int width, int height, int startX, int startY)
    {
        Width = width;
        Height = height;
        X = startX;
        Y = startY;
    }

    public void DrawWithSize(Graphics graphics)
    {
        graphics.drawImage(getPicture(), this.getX(), getY(), Width, Height, null);
    }

    public BufferedImage getPicture() {
        return Picture;
    }

    public void setPicture(String path) {
        File fileImg = new File(path);
        
        try 
        {
            Picture = ImageIO.read(fileImg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public int getWidth() { return Width; }
    
    public int getHeight() { return Height; }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }
}
