package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot[] r = new Robot[5];
		int x = 300;
		int y = 300;
		boolean run = true;
		for (int i = 0; i < 3; i++) {
			if (i < 3) {
				r[i] = new Robot(x, y);
				x += 300;
			}
		}
		x = 450;
		y = 500;

		for (int i = 3; i < 5; i++) {
			r[i] = new Robot(x, y);
			x += 300;
			r[i].setSpeed(1);
		}

		Thread[] t = new Thread[5];
		Thread[] turn = new Thread[5];

		for (int i = 0; i < 5; i++) {
			int num = i;
			r[i].penDown();
			t[i] = new Thread(() -> r[num].move(100));
			turn[i] = new Thread(() -> r[num].turn(20));
		}
		while (run) {
			for (int i = 0; i < 5; i++) {
				int num = i;
				t[i].start();
				turn[i].start();
				t[i] = new Thread(() -> r[num].move(100));
				turn[i] = new Thread(() -> r[num].turn(20));
			}
		}

	}

}
