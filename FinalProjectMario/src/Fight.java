import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Fight implements ActionListener {
	int intX, intY;
	int x, y, shootMove;
	Image img, spray;
	Timer shoot;

	Fight(int weaponX, int weaponY) {
		intX = weaponX;
		intY = weaponY;
		shoot = new Timer(100, this);
		shoot.start();
		
	}

	public void shoot(Image p) {
		spray = getImage("spray.png", 10, 20);
	}

	public void hit(Image p1, Image p2, Image p3) {

	}
	
	public void stop() {
		shoot.stop();
		shootMove = 0;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			shootMove += 10;
	}
}
