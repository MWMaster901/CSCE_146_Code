/*
 * Written by Christopher Schweninger
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class fractalTriangle extends Canvas
{
	//The "front end"
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Fractal Triangle");
		frame.setSize(750,750);
		fractalTriangle fT = new fractalTriangle();
		frame.add(fT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//This replaces the paint method with this
	public void paint(Graphics g)
	{
		drawTriangle(0,this.getSize().width,this.getSize().width,g);
	}
	/*
	 * This will recursively draw the triangles.
	 * First the triangle points are determined.
	 * Then the triangle gets drawn.
	 * Then the will be in the center and be of a different color to "remove" it.
	 * The position and size of the triangle will be the inner quarter of the triangle
	 * Then this recursively continues with the upper triangle,
	 * lower left triangle,
	 * and lower right triangle.
	 * Until the draw size is LESS THAN or EQUAL to 4.
	 */
	public void drawTriangle(int startX, int startY, int length, Graphics g)
	{
		//Initializing
		int sub = length / 2;
		int sub2 = length / 4;
		int[] xPoss = new int[3];
		int[] yPoss = new int[3];
		//Main triangle points
		xPoss[0] = startX;
		xPoss[1] = startX + sub;
		xPoss[2] = startX + length;
		yPoss[0] = startY;
		yPoss[1] = startY - length;
		yPoss[2] = startY;
		//Draws main triangle
		g.setColor(Color.black);
		g.fillPolygon(xPoss, yPoss, xPoss.length);
		//Inner triangle points
		xPoss[0] = xPoss[0] + sub2;
		xPoss[2] = xPoss[2] - sub2;
		yPoss[0] = yPoss[0] - sub;
		yPoss[1] = yPoss[1] + length;
		yPoss[2] = yPoss[2] - sub;
		//Drawing inner triangle, I used cyan so it would be easier to see if done step by step.
		g.setColor(Color.cyan);
		g.fillPolygon(xPoss, yPoss, xPoss.length);
		//Recursion
		if(sub > 4)
		{
			//Top
			drawTriangle(startX+sub2, startY-sub, sub, g);
			//Left
			drawTriangle(startX, startY, sub, g);
			//Right
			drawTriangle(startX+sub, startY, sub, g);
		}
	}
	
}
