import java.awt.*;
import javax.swing.*;

public class Animal implements Comparable<Animal>
{
    private String name;
    private Image image;

    public Animal(String n)
    {    
        name  = n;
        image = new ImageIcon(name + ".png").getImage();
    }

    public String getName()
    {
        return name;
    }

    public int getWidth()
    {
        return image.getWidth(null);
    }

    public int getHeight()
    {
        return image.getHeight(null);
    }

    public Image getImage()
    {
        return image;
    }

    public int compareTo(Animal other)
    {
	return Integer.compare(this.getHeight(), other.getHeight());
    }
}