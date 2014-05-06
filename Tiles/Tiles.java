import java.awt.*;
import java.util.*;

/**
 * @author Nikita Chrystephan
 * @assignment 11: Tiling
 * @grading target: standard
 * The Tiles class creates a series of windows containing tessellations.
 */
public class Tiles {

	/**
	 * The Height and Width values are constant.
	 */
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;

	/**
	 * The main  method calls the various methods. Each method
	 * contains a pattern drawn on/in a drawingpanel.
	 * @param String[] args.
	 */
	public static void main(String[] args) {
		Tiles ti = new Tiles();
		ti.basketweave();
		ti.mediterranean1();
		ti.mediterranean2();
		ti.openWeave();
		ti.pythagorean();
		//	ti.pythagorean2();
	}

	// public void pythagorean2() {
	//	 DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
	//	 java.awt.Graphics g = dp.getGraphics();
	//	 dp.setTitle("Pythagorean");
	//	 Color blue = new Color(64,64,192);
	//	 Color cyan = new Color(136,204,204);
	//	 g.setColor(Color.lightGray);
	//	 g.fillRect(-20, -20, WIDTH+20, HEIGHT+20);
	//	 for(int h = -5; h < HEIGHT+50; h += 50) {
	//		 for(int w = -15; w < WIDTH+50; w +=50) {
	//			 
	//		 }
	//	 }
	//
	// }

	/**
	 * This is the method that draws the "pythagorean" pattern. 
	 */
	public void pythagorean() {
		DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
		java.awt.Graphics g = dp.getGraphics();
		dp.setTitle("Pythagorean");
		Color blue = new Color(64,64,192);
		Color cyan = new Color(136,204,204);
		g.setColor(cyan);
		g.fillRect(-20, -20, WIDTH+20, HEIGHT+20);
		for(int h = -5; h < HEIGHT+50; h += 50) {
			for(int w = -15; w < WIDTH+50; w +=50) {
				g.setColor(blue);
				g.fillRect(w+20, h, 10, 10);
				g.fillRect(w-10, h+10, 10, 10);
				g.fillRect(w+10, h+20, 10, 10);
				g.fillRect(w, h-10, 10, 10);
				g.fillRect(w+30, h+30, 10, 10);
				g.setColor(Color.black);
				g.drawRect(w,h,20,20);
				g.drawRect(w+20, h+10, 20, 20);
				g.drawRect(w+30, h-10, 20, 20);
				g.drawRect(w+10, h-20, 20, 20);
				g.drawRect(w-10, h-30, 20, 20);
				g.drawRect(w-20, h-10, 20, 20);
				g.drawRect(w-30, h+10, 20, 20);
			}
		}
	}

	/**
	 * This is the method that draws the "Open Weave" pattern.
	 */
	public void openWeave() {
		DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
		java.awt.Graphics g = dp.getGraphics();
		dp.setTitle("Open Weave");
		Color pink = new Color(204,136,204);
		Color red = new Color(154,32,64);
		g.setColor(pink);
		g.fillRect(-20, -20, WIDTH+20, HEIGHT+20);
		for(int h = -25; h < HEIGHT+60; h += 60) {
			for(int w = -25; w < WIDTH+60; w += 60) {
				g.setColor(red);
				g.fillRect(w, h, 10, 10);
				g.fillRect(w+30, h, 10, 10);
				g.fillRect(w, h+30, 10, 10);
				g.fillRect(w+30, h+30, 10, 10);
				g.setColor( Color.black);
				g.drawRect(w, h+10, 40, 20);
				g.drawRect(w+10, h-30, 20, 40);
				g.drawRect(w-20, h, 20, 40);
				g.drawRect(w-30, h-20, 40, 20);
			}
		}
	}

	/**
	 * This is the method that draws the "Basket Weave" pattern.
	 */
	public void basketweave() {
		DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
		java.awt.Graphics g = dp.getGraphics();
		dp.setTitle("Basket Weave Pattern");
		Color orange = new Color(255,201,14);
		Color brown = new Color(185,122,87);
		for(int a = 0; a < HEIGHT + 80; a += 80) {
			for(int i = 0; i < WIDTH + 80; i += 80) {
				g.setColor(orange);
				g.fillRect(i, a, 40, 40);
				g.fillRect(i+40, a+40, 40, 40);
				g.setColor(brown);
				g.fillRect(i+40, a, 40, 40);
				g.fillRect(i, a+40, 40, 40);

				g.setColor(Color.black);
				g.drawRect(i, a, 20, 40);
				g.drawRect(i+20, a, 20, 40);
				g.drawRect(i+40, a, 40, 20);
				g.drawRect(i+40, a+20, 40, 20);
				g.drawRect(i+40, a+40, 20, 40);
				g.drawRect(i+60, a+40, 20, 40);
				g.drawRect(i, a+40, 40, 20);
				g.drawRect(i, a+60, 40, 20); 
			}
		}
	}

	/**
	 * This method draws the "Mediterranean" pattern.
	 */
	public void mediterranean1() {
		DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
		java.awt.Graphics g = dp.getGraphics();
		dp.setTitle("Med 1");
		Color red = Color.red;
		Color yellow = new Color(255,255,64);
		g.setColor(yellow);
		g.fillRect(-20,-20,WIDTH+24,HEIGHT+20);
		for(int h = 0; h < HEIGHT+24; h += 24) {
			g.setColor(Color.black);
			g.drawLine(-20, h+17, WIDTH+20, h+17);
			g.drawLine(h+17, 0, h+17, HEIGHT+20);
		}

		for(int h = 0; h < HEIGHT; h += 24) {
			for(int w = 0; w < WIDTH; w += 24) {
				int x[] = new int[] {w+17,w+10,w+17,w+24};
				int y[] = new int[] {h+10,h+17,h+24,h+17};
				g.setColor(red);
				g.fillPolygon(x,y,4);
				g.setColor(Color.black);
				g.drawPolygon(x,y,4);
			}
		}
	}

	/**
	 * This method draws the rotated "Mediterranean" pattern.
	 */
	public void mediterranean2() {
		DrawingPanel dp = new DrawingPanel(WIDTH,HEIGHT);
		java.awt.Graphics g = dp.getGraphics();
		dp.setTitle("Med 2");
		Color green = new Color(192,192,128);
		Color blue = new Color(0,112,192);
		g.setColor(green);
		g.fillRect(-20, -20, WIDTH+20, HEIGHT+20);
		for(int h = 0; h < HEIGHT+34; h += 34) {
			g.setColor(Color.black);
			g.drawLine(0, h, WIDTH, h+WIDTH);
			g.drawLine(0, -h, WIDTH, WIDTH-h);
			g.drawLine(WIDTH, h-7, 0, WIDTH+h-7);		 
			g.drawLine(WIDTH, -h-7, 0, WIDTH-h-7);
		}

		for(int h = 0; h < HEIGHT+34; h += 34) {
			for(int w = 0; w < WIDTH+34; w += 34) {
				g.setColor(blue);
				g.fillRect(w+7, h+7, 10, 10);
				g.fillRect(w+24, h+24, 10, 10);
				g.setColor(Color.black);
				g.drawRect(w+7, h+7, 10, 10);
				g.drawRect(w+24, h+24, 10, 10);

			}
		}
	}
}
