import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Imagem {
    private BufferedImage Picture;
    private int x;
    private int y;

    public void DrawWithSize(Graphics graphics, int width, int height)
    {
        graphics.drawImage(getPicture(), this.getX(), getY(), width, height, null);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
