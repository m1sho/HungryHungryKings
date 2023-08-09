import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Background extends JPanel implements KeyListener, ActionListener, MouseListener{

	Image img;
	boolean jumping, right, left, play, menu = true, pause, quit, player1, player2, bottleB, broomB, isleft, gameover ;
	static boolean s;
	static boolean st;
	static boolean str;
	static boolean sound;
	
	static boolean shoot;
	boolean hit;
	int BulletX;
	int butt;
	int marioInt = 0;
	int difficulty;
	int marioX = 300;
	int weaponInt = 330;
	int MonsterX;
	int Monsterx2;
	int weaponX = weaponInt;
	int shotMove = 20;
	int marioY = 440;
	int score = 0;
	int health = 100;
	Image marioImage = getImage("JanitarioStill.png", 40, 70);
	Image marioImage2 = getImage("JanitarioStill2.png", 40, 70);
	Image turtleImage = getImage("turtle.png", 250, 150);
	Image bricks = getImage("marioBricks.png", 20, 20);
	Image menuBack = getImage("MenuMario.jpg", 600, 600);
	Image gordon = getImage("gordon.png", 60, 60);
	Image kanye = getImage("med.png", 60, 60);
	Image easy = getImage("easy.png", 60, 60);
	Image Background = getImage("BackgroundMario.png", 600, 600);
	Image sun = getImage("sun.png", 220, 200);
	Image em = getImage("em.png", 220, 200);
	Image castle = getImage("castle.png", 220, 200);

	//Image broom = getImage("broom.png", 40, 40);
	Image turkey = getImage("turkey.png", 50,50);;
	Image spaghetti = getImage("spaghetti.png", 50,50);;
	double intVelocity = -6, gravity = 0.26887, time = 1;
	double velocity = intVelocity;
	
	
	int backgroundX = 600;
	public ArrayList<Brick> arBricks;
	//Music music = new Music();
	//EasySound jump, menuSound;
	//MusicThread music2;
	Font font = new Font("Serif", Font.BOLD, 40);
	Font font2 = new Font("Serif", Font.BOLD, 10);
	Font font3 = new Font("Serif", Font.BOLD, 20);
	private HashSet keys = new HashSet();
	//Image spray = getImage("spray.png",30 , 40);
	//Fight f = new Fight(weaponX, marioY);
	Bullet b;
	Monster m = new Monster();
	Monster2 l = new Monster2();
	Brick br = new Brick(600);
	
	
	
	public void updateKeys() {
		
		if(keys.contains(KeyEvent.VK_UP)) {
			jumping = true;
		}
		if(keys.contains(KeyEvent.VK_LEFT)) {
			left = true;
			right = false;
			isleft = true;
			 weaponX = marioX -40 ;
			 
			// butt = marioX +200;
				
			
		}
		if(keys.contains(KeyEvent.VK_RIGHT)) {
			right = true;
			left = false;
			isleft = false;
			weaponX= marioX +40 ;
			 
			// butt = marioX -90;
				
		}
		if(keys.contains(KeyEvent.VK_SPACE)) {
			if(bottleB) {
				shoot = true;
			} else if(bottleB) {
				hit = true;
			
			}
			if(play == true) {
				health +=100;
			}
		}
	}


	public Background(){
		//arBricks = new ArrayList<Brick>();
		//arBricks.add(new Brick(600, 500));

		Timer timer = new Timer(20, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double ratioX = getWidth()/600.0;
		double ratioY = getHeight()/600.0;
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(ratioX, ratioY);
		
		sound = false;
		

		/*for(int i = 0; i < arBricks.size(); i++){
			arBricks.get(i).updatePosition();
		}
		for(int i = 0; i < arBricks.size(); i++){
			arBricks.get(i).draw(g);
		}*/

		for(int i = 0; i <= getWidth()/20; i++) {
			g.drawImage(bricks, i * 20, 500, null);
		}

		g.drawImage(Background, 0, 0, null);


		//draw bricks



		//for(; backgroundX<30; backgroundX++) {
		//g.drawImage(bricks, backgroundX*20, 500, null);
		//}
		/*while(play){
			for(; shift < 800;) {
				g.drawImage(bricks, backgroundX+i, 500, null);
				shift+=20;
			}
			shift = 0;
			play = false;
		}*/


		// paint mario 
		g.drawImage(getPlayer(), marioX, (int) (marioY+velocity), null);

		g.drawImage(getWeapon(), weaponX, (int) (marioY+velocity), null);
if(isleft == true){
	turkey = getImage("turkey.png", 50,40);
}
else{
	turkey = getImage("turkey.png", 50,40);
}
		if(jumping) {
			marioY += velocity*time;
			velocity += gravity*time;
			time++;


			if(marioY >= 440) {

				velocity = intVelocity;
				time = 1;
				marioY = 440;
				if(!right || left) {
					//marioImage = getImage("JanitarioStill.png", 40, 70);
				} else {

				}
				jumping = false;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(right) {
				//marioImage = getImage("JanitarioRunning.png", 40, 70);
				marioX += 20;
				weaponX += 20;
				right = false;
				//marioImage = getImage("JanitarioRunningOther.png", 40, 70);
			}
			if(left) {
				marioX -= 20;
				weaponX -= 20;
				left = false;
			}

		}


		if(right) {
			if(!(marioX>=550)) {
				marioX += 10;
				weaponX += 10;
			}
			right = false;
		}
		if(left) {
			if(!(marioX<=0)) {
				marioX -= 10;
				weaponX -= 10;
			}
			left = false;
		}

		
		if(shoot) {
			int alpha = 127;
			Color inv = new Color(0,0,0, 0);
			g.setColor(inv);
			g.drawRect(weaponX + b.move, marioY - 10, 10, 10);
			//g.drawImage(spray, weaponX + b.move, b.getY(), null);
		
			Timer playSound = new Timer(200, new ActionListener() {
		    	
		    	public void actionPerformed(ActionEvent e)
		    	{
		    		
		    	}
		    	
		    });
			playSound.start();
			
			
			//System.out.println(b.move);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		} else if(hit) {
			
		}

		if(menu) {
		m.monsterappear = false;
		l.monsterappear = false;
			//m.img = getImage("pg.png",120 ,100 );
			//l.img= getImage("pg.png",120 ,100 );
	score = 0;

			g.setColor(Color.CYAN);
			//g.fillRect(0, 0, getWidth()+50, getHeight()+50);
			g.drawImage(Background, 0, 0, null);
			g.setColor(Color.red);
			g.setFont(font);
			g.drawString("Hungry Hungry King", 100, 100);
			g.setColor(Color.blue);
			g.fillRect(400, 400, 50, 25);
			g.fillRect(200, 400, 50, 25);
			g.setColor(Color.CYAN);
			g.setFont(font2);
			g.drawString("PLAY", 410, 415);
			g.drawString("QUIT", 205, 415);
			g.setFont(font3);
			g.drawString("Choose character", 200, 180);
			g.drawImage(marioImage, 200, 200, null);
			g.drawImage(marioImage2, 300, 200, null);
			g.drawString("Choose weapon", 200, 290);
			g.drawImage(turkey, 300, 310, null);
			g.drawString("Difficulty:", 480, 180);
			
			g.drawImage( gordon, 480, 340, null);
			
			g.drawImage( easy, 480, 200, null);
			
			g.drawImage( kanye, 480, 260, null);
			
			g.drawImage(spaghetti, 200, 310, null);
			if(player1) {
				g.drawOval(193, 190, 60, 90);
			} else if(player2) {
				g.drawOval(290, 194, 60, 90);
			}
			if(broomB) {
				g.drawOval(195, 310, 60, 60);
			} else if(bottleB) {
				g.drawOval(295, 297, 60, 60);
			}
			
					
		if(difficulty ==1){
			s= true;
		
			g.drawOval(460, 180, 100, 100);
		}
			if(difficulty ==2){
				st = true;
					
			
				m.move+=4;
				g.drawOval(460, 240, 100, 100);
			}
			if(difficulty ==3){
				str= true;
			m.move+=8;
			
				g.drawOval(460, 320, 100, 100);
			}
			play = false;
		} else if(pause){
		
		
			l.monsterappear= false;
			m.monsterappear =false;
			m.move= 0;
			l.move=0;
			
		
			
			g.setColor(Color.CYAN);
			//g.fillRect(0, 0, getWidth()+50, getHeight()+50);
			g.drawImage(Background, 0, 0, null);
			g.setColor(Color.red);
			g.setFont(font);
			g.drawString("paused", 220, 100);
			g.setColor(Color.blue);
			g.fillRect(400, 400, 50, 25);
			g.fillRect(200, 400, 50, 25);
			g.setColor(Color.CYAN);
			g.setFont(font2);
			g.drawString("PLAY", 410, 415);
			g.drawString("RESET", 205, 415);
		}
		else if(gameover){
			
			m.move= 0;
			l.move=0;
			
			
			
			g.setColor(Color.CYAN);
			//g.fillRect(0, 0, getWidth()+50, getHeight()+50);
			g.drawImage(Background, 0, 0, null);
			g.setColor(Color.red);
			g.setFont(font);
			g.drawString("KING HUNGRY!",150, 500);
			g.drawString("Game Over", 220, 100);
			g.drawString("You Scored:"+ score, 220, 200);
			g.setColor(Color.blue);
			
			g.fillRect(200, 400, 50, 25);
			g.setColor(Color.CYAN);
			g.setFont(font2);
			
			g.drawString("RESET", 205, 415);
			g.drawImage(em,20, 100, null);
		}
		
	
		 MonsterX = 600-m.move;
		 Monsterx2 = 100+ l.move;
		 BulletX = weaponX;
		if(m.monsterappear) {
			//if(play) {
				int alpha = 127;
				Color inv = new Color(0,0,0, 0);
				g.setColor(inv);
				g.drawRect(600-m.move, 430, 60, 50);
				g.drawImage(m.img, 600-m.move, 430, null);
				//System.out.println("bulletX: " + BulletX + " monsterX2: " + Monsterx2+"monsterX" + MonsterX + "Mario" +marioX);
				
				
			//}
		} else {
			System.out.println("delete");
		}
		if(l.monsterappear) {
			//if(play) {
			l.img = getImage("monsterReverse.png",120 ,100 );
				int alpha = 127;
				Color inv = new Color(0,0,0, 0);
				g.setColor(inv);
				g.drawRect(100+l.move, 430, 60, 50);
				g.drawImage(l.img, l.move, 430, null);
			//	System.out.println("bulletX: " + BulletX + " monsterX2: " + Monsterx2+"monsterX" + MonsterX+ "weapon"+weaponX );
				
				
			//}
		} else {
			System.out.println("delete");
		}
		if(weaponX> MonsterX && menu == false){
			MusicThread.play("dinner.wav");
			score++;
			m.monsterappear = false;
			m.move = 0;
			m.monsterappear = true;
			
			
		}
		if(weaponX<Monsterx2 && menu == false) {
			MusicThread.play("dinner.wav");
			score++;
			l.monsterappear = false;
			l.move = 0;
			l.monsterappear = true;
			
			
		
		
		}
		repaint();

		if(play) {
		
		
			gameover = false;
			
			if(MonsterX<marioX) {
				health-=10;}
			else if(Monsterx2>marioX) {
				health-=10;}
			m.monsterappear = true;
			l.monsterappear = true;
			m.img = getImage("monster.png", 120, 100);
			g.drawImage(castle, -170, 320, null);
			g.drawImage(castle, 530,320 , null);
			if(score > 100){
				l.monsterappear = false;
				m.monsterappear = false;
				
				g.drawImage(sun, 200, 200, null);
				g.drawString("GoodJob!", 200, 300);
			
				 if(score>60 && difficulty ==1){
					difficulty =2;;
				}
					else if(score >60&& difficulty ==2){
						difficulty =3;;
				}
		
			}
				
			
		
				
			if(difficulty ==1){
				m.move+= 24;
				l.move+= 24;
				 
			}
				if(difficulty ==2){
					m.move+=28;
					l.move+= 38;
					
				}
				if(difficulty ==3){
					
					
				m.move+=32;
				l.move+= 32;
					
				}
		
			
			g.setColor(Color.red);
			g.drawString("Score: "+score+"", 10, 10);
			
			g.drawString("Health:" + health+ "", 10,20);
			
			}
		
		if(health ==0){
			gameover = true;
		}
		repaint();
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

	public Image getPlayer(){
		if(player1) {
			if(jumping){
				return getImage("JumpingJanitario.png", 40, 70);
			}else if(right) {
				return getImage("JanitarioRunning.png", 40, 70);
			}else if(left) { 
				
				
				return getImage("JanitarioRunningreversed.png", 40, 70);
				
				
			}else {
				return getImage("JanitarioStill.png", 40, 70);
			}
		} else if(player2) {
			if(jumping){
				return getImage("JanitarioJumping.png", 40, 70);
			}else if(left) {
			
				return getImage("JanitarioRunningRightreversed.png", 40, 70);
			}else if(right) { 
				return getImage("JanitarioRunningLeft.png", 40, 70);
			}else {
				return getImage("JanitarioStill2.png", 40, 70);
			}
		}
		return getImage("JanitarioStill2.png ", 40, 70);
	}

	public Image getWeapon() {
		if(bottleB) {
			return turkey;
		}
		return spaghetti;
	

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//jump = new EasySound("jumping.wav");
		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(play) {
				keys.add(KeyEvent.VK_UP);
				//jumping = true;
				//jump.play();
				MusicThread.play("jumping.wav");
			}
			break;

		case KeyEvent.VK_LEFT:
			if(play)
				keys.add(KeyEvent.VK_LEFT);
				//left = true;
			break;

		case KeyEvent.VK_RIGHT:
			if(play) {
				keys.add(KeyEvent.VK_RIGHT);
				//right = true;
			}
			break;

		case KeyEvent.VK_ESCAPE:
			if(play) {
				pause = true;
				play = false;
			}
			break;


			
			
			//MusicThread.play("shoot.wav");
			//b.fire();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//jump = new EasySound("jumping.wav");
		switch(keyCode) {
		case KeyEvent.VK_UP:
			if(play) {
				keys.remove(KeyEvent.VK_UP);
				//jumping = true;
				//jump.play();
				MusicThread.play("jumping.wav");
				
			}
			break;

		case KeyEvent.VK_LEFT:
			if(play)
				keys.remove(KeyEvent.VK_LEFT);
				//left = true;
			
			break;

		case KeyEvent.VK_RIGHT:
			if(play) {
				keys.remove(KeyEvent.VK_RIGHT);
				//right = true;
				
			}
			
		case KeyEvent.VK_SPACE:
			sound = true;
			
			
			keys.remove(KeyEvent.VK_SPACE);
					}
	}


	public static void main(String[] args) {
		//		JFrame window = new JFrame("Drawings");
		//		window.setBounds(100, 100, 600, 600);
		//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//		Background back = new Background();
		//		window.addKeyListener(back);
		//		window.setBackground(Color.WHITE);
		//		back.setBackground(Color.white);
		//		window.getContentPane().add(back);
		//		//window.setEnabled(false);
		//		window.setVisible(true);

		JFrame window = new JFrame("Landscape");
		window.setBounds(0, 0, 600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Background back = new Background();
		//JPanel canvas = new Background();
		//canvas.setBackground(Color.WHITE);
		//window.getContentPane().add(canvas);
		window.addKeyListener(back);
		back.addMouseListener(back);
		window.getContentPane().add(back);
		back.setBackground(Color.white);
		window.setVisible(true);
		window.setResizable(false);
		MusicThread.play("spaghetti.wav");
		window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		}
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		updateKeys();
		//backgroundX--;
		
		m.move();
		repaint();		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!SwingUtilities.isRightMouseButton(e)) {
			int y = e.getY();
			int x = e.getX();
			if(y>=381 && y<=404 && x>=395 && x<=444) {
				menu = false;
				pause = false;
				gameover =false;
				play = true;
				System.out.println("mouse pressed");
			} else if(y>=381 && y<=404 && x>=195 && x<=244) {
				if(menu) {
					System.exit(0);
				}
				menu = true;
				health +=100;
				pause = false;
				play = false;
				marioX = marioInt;
				weaponX = weaponInt;
				marioX = 300;
				MonsterX = 600;
				Monsterx2 = 0;
				
			} else if(y>=191 && y<= 256 && x>=202 && x<=245) {
				player1 = true;
				player2 = false;
				System.out.println("player1");
			} else if(y>=191 && y<=256 && x>=298 && x<=340) {
				player1 = false;
				player2 = true;
				System.out.println("player2");
			} else if(y>=297 && y<=336 && x>=201 && x<=238) {
				broomB = true;
				bottleB = false;
				System.out.println("broom");
			} else if(y>=300&& y<=345 && x>=300 && x<=330) {
				bottleB =true;
				broomB = false;
				System.out.println("bottle");
			} else if(y>=200 && y<=250 && x>=480 && x<=530) {
				difficulty = 1;
			} else if(y>=250 && y<=280 && x>=480 && x<=530) {
				difficulty =2;
			} else if(y>=320 && y<=400 && x>=480 && x<=530) {
	
			difficulty = 3;
			}
			
			System.out.println("x:" + x + "y:"+ y);
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
