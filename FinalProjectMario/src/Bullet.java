import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Bullet  {//implements ActionListener

	//static Timer timer;
	static int weaponX;
	static int moveInt =0;
	int y;
	static int move = moveInt;

	Bullet(int weaponX, int y) {
		this.weaponX = weaponX;
		this.y = y;
		//timer = new Timer(10, this);
		//timer.start();
		System.out.println(moveInt);
	

	//public void fire(){
	//	if(move >= moveInt+100){
			//timer.stop();
		//	move = moveInt;
			//Background.shoot = false;
		//} else {
			move += 20;
		//	System.out.println("move is"+move);

		}
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(move >= moveInt+100){
			timer.stop();
			move = moveInt;
			Background.shoot = false;
		} else {
			move += 10;
			System.out.println("move is"+move);

		}
		
		
	}*/
	public int getY(){
		return this.y;
	}
}
