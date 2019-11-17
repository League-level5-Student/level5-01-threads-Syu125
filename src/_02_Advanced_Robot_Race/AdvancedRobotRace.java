package _02_Advanced_Robot_Race;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] r = new Robot[3];
		Thread[] t = new Thread[3];
		int speed = 3;
		int x = 300;
		
		for (int i = 0; i < t.length; i++) {
			r[i] = new Robot(x, 800);
			x += 300;
			r[i].setSpeed(speed);
			speed += 3;
		}
		for (int i = 0; i < r.length; i++) {
			int num = i;
			t[i] = new Thread(()-> r[num].move(500));
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}

	}
}
