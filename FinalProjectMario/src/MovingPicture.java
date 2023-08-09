import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MovingPicture extends JPanel implements KeyListener{
	Image img;
	boolean inAir;
	int x, y;
	
	public void walk(int d) {
		x+=d;
	}
	
	public int jump() {
		int h;
		for(h = img.getHeight(null); h >= h+100; h++) {
			return h;
			//repaint();
		}
		return h;
	}
	
	public int inAir() {
		int h = img.getHeight(null);
		for(; h <= 500;) {
			h--;
			return h;
		}
		return h;
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		switch(keyCode) {
		case KeyEvent.VK_UP:
			jump();
			break;

		case KeyEvent.VK_LEFT:
			walk(-5);
			break;
			
		case KeyEvent.VK_RIGHT:
			walk(5);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
