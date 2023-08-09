import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick {
	Image img;
	Image brick = getImage("marioBricks.png", 20, 20);
	int x, y = randomY();
	
	public int randomY() {
		return (int)(Math.random()*100)-1;
	}
	
	public Brick(int x) {
		x = this.x;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(brick, x, y, null);
		g.fillRect(x, y, 20, 20);
	}
	
	public void updatePosition(){
		x -= 20;
	}
	public Image getImage(String n, int width, int height) {
		try {
			img = ImageIO.read(new File(n));
		} catch (IOException e) {
			System.out.println("There is not image file");
		}
		if(img != null) {
			img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		} 
		return img;
	}
}
