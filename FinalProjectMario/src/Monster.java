import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class Monster extends JPanel implements ActionListener  {
	Image img;
	private int tickmonster = 100;
	boolean monsterappear = true;
	static int move = 0;
	Image marioImage = getImage("monster.png", 120, 100);

	
	public Monster() {
		Timer timer = new Timer(100, this);
		timer.start();
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

	
	public void die() {
		//if(Bullet.move > 600-move) {
			monsterappear = false;
			
		}
	//}
	
	public void move(){
		move += 0;
		if(tickmonster == 0){
			tickmonster = 100;
			
			
		}
		else{
			tickmonster--;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		move += 1;
		//monsterappear = true;
	}
	
	Point s = new Point(600-move, 430);
}


